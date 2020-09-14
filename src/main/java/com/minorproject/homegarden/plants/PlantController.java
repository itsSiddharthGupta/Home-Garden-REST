package com.minorproject.homegarden.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
public class PlantController {
	@Autowired
	private PlantService service;
	
	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public Result addNewPlant(@RequestBody PlantDetails details){
		return service.addPlant(details);
	}
	
	@RequestMapping(method = RequestMethod.PATCH, path = "/update")
	public Result updatePlant(@RequestBody PlantDetails details){
		return service.updatePlant(details);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
	public Result deletePlant(@PathVariable("id") Long id){
		return service.deletePlant(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public Result getAllPlants(){
		return service.getAllPlants();
	}
}
