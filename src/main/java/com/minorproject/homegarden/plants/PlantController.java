package com.minorproject.homegarden.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<PlantDetails> addNewPlant(@RequestBody PlantDetails details){
		return new ResponseEntity<PlantDetails>(service.addPlant(details), HttpStatus.CREATED);
	}
}
