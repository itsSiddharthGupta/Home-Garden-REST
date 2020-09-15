package com.minorproject.homegarden.plants;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.JDBCException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.minorproject.homegarden.plants.Result.Failure;
import com.minorproject.homegarden.plants.Result.Success;

@Service
public class PlantService {
	@Autowired
	private PlantDetailRepository plantsRepo;
	@Autowired
	private ImagesRepository imagesRepo;

	private static final String IMAGE_BASE_URL = "https://home-garden-app.herokuapp.com/plants/images/";

	public Result addPlant(PlantDetails details) {
		PlantDetails plant = new PlantDetails(details.getName(), details.getDescription(), details.getIsIndoor());
		plant.setTemperature(details.getTemperature());
		plant.setWater(details.getWater());
		PlantCareDetails care = new PlantCareDetails(details.getCareInfo().getWaterDetails(),
				details.getCareInfo().getTemperatureDetails(), details.getCareInfo().getLightDetails(),
				details.getCareInfo().getSoilDetails());
		care.setPlantInfo(plant);
		plant.setCareInfo(care);
		try {
			PlantDetails res = plantsRepo.save(plant);
			if (res != null) {
				Success<PlantDetails> suc = new Success<PlantDetails>("success", res);
				return suc;
			} else {
				Failure error = new Failure("failed", "Server error. Try again!");
				return error;
			}
		} catch (Exception e) {
			Failure error = new Failure("failed", e.getCause().getCause().getLocalizedMessage());
			return error;
		}
	}

	public Result updatePlant(PlantDetails details) {
		try {
			PlantDetails res = plantsRepo.save(details);
			if (res != null) {
				Success<PlantDetails> suc = new Success<PlantDetails>("success", res);
				return suc;
			} else {
				Failure error = new Failure("failed", "Server error. Try again!");
				return error;
			}
		} catch (Exception e) {
			Failure error = new Failure("failed", e.getLocalizedMessage());
			return error;
		}
	}

	public Result deletePlant(Long id) {
		try {
			plantsRepo.deleteById(id);
			Success<Long> suc = new Success<Long>("success", id);
			return suc;
		} catch (Exception e) {
			Failure error = new Failure("failed", e.getLocalizedMessage());
			return error;
		}
	}

	public Result getAllPlants() {
		try {
			List<PlantDetails> plants = plantsRepo.findAll();
			Success<List<PlantDetails>> suc = new Success<List<PlantDetails>>("success", plants);
			return suc;
		} catch (Exception e) {
			Failure error = new Failure("failed", e.getLocalizedMessage());
			return error;
		}
	}

	public Result uploadImage(Long id, MultipartFile file) {
		try {
			Images img = new Images();
			img.setImage(file.getBytes());
			Images res = imagesRepo.save(img);
			PlantDetails details = plantsRepo.getOne(id);
			details.setImageUrl(IMAGE_BASE_URL + res.getId());
			plantsRepo.save(details);
			Success<Long> suc = new Success<Long>("success", res.getId());
			return suc;
		} catch (Exception e) {
			Failure error = new Failure("failed", e.getLocalizedMessage());
			return error;
		}
	}

	public Result deleteImage(Long id) {
		PlantDetails details = plantsRepo.findById(id).get();
		if (details != null) {
			String url = details.getImageUrl();
			if (url != null) {
				String[] arr = url.split("/");
				Long imgId = Long.parseLong(arr[arr.length - 1]);
				Images img = imagesRepo.findById(imgId).get();
				if (img != null) {
					try {
						imagesRepo.delete(img);
					} catch (Exception e) {
						Failure error = new Failure("failed", e.getLocalizedMessage());
						return error;
					}
					try {
						details.setImageUrl(null);
						plantsRepo.save(details);
						Success<Long> suc = new Success<Long>("success", id);
						return suc;
					} catch (Exception e) {
						imagesRepo.save(img);
						Failure error = new Failure("failed", e.getLocalizedMessage());
						return error;
					}
				} else {
					Failure error = new Failure("failed", "Image does not exist.");
					return error;
				}
			} else {
				Failure error = new Failure("failed", "Image does not exist.");
				return error;
			}
		} else {
			Failure error = new Failure("failed", "Plant does not exist.");
			return error;
		}
	}

	public byte[] getImage(Long id) {
		Images img = imagesRepo.findById(id).get();
		return img != null ? img.getImage() : null;
	}
}
