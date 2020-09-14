package com.minorproject.homegarden.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
	@Autowired
	private PlantDetailRepository plantsRepo;
	@Autowired
	private PlantCareDetailsRepository careRepo;

	public PlantDetails addPlant(PlantDetails details) {
		PlantDetails plant = new PlantDetails(details.getName(), details.getDescription());
		plant.setCareInfo(details.getCareInfo());
		plant.setTemperature(details.getTemperature());
		plant.setWater(details.getWater());
		PlantCareDetails care = new PlantCareDetails(details.getCareInfo().getWaterDetails(),
				details.getCareInfo().getTemperatureDetails(), details.getCareInfo().getLightDetails(),
				details.getCareInfo().getSoilDetails());
		care.setPlantInfo(plant);
		return plantsRepo.save(plant);
	}
}
