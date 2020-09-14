package com.minorproject.homegarden.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
	@Autowired
	private PlantDetailRepository plantsRepo;
	
	public PlantDetails addPlant(PlantDetails details) {
		PlantDetails plant = new PlantDetails(details.getName(), details.getDescription());
		plant.setCareInfo(details.getCareInfo());
		plant.setTemperature(details.getTemperature());
		plant.setWater(details.getWater());
		return plantsRepo.save(plant);
	}
}
