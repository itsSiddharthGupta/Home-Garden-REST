package com.minorproject.homegarden.plants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/plants")
public class PlantController {
	@Autowired
	private PlantService service;
	
	@RequestMapping(method = RequestMethod.POST, path = "/add")
	public Result addNewPlant(@RequestBody PlantDetails details){
		return service.addPlant(details);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/bulk_add")
	public Result addNewPlant(@RequestBody List<PlantDetails> details){
		return service.addPlantsInBulk(details);
	}
	
	@RequestMapping(method = RequestMethod.PATCH, path = "/update")
	public Result updatePlant(@RequestBody PlantDetails details){
		return service.updatePlant(details);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
	public Result deletePlant(@PathVariable("id") Long id){
		return service.deletePlant(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Result getAllPlants(){
		return service.getAllPlants();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public Result getPlant(@RequestParam("name") String name) {
		return service.getPlantByName(name);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/upload/{plant_id}")
	public Result uploadImage(@PathVariable("plant_id") Long id, @RequestParam("file") MultipartFile file){
		return service.uploadImage(id, file);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/images/{image_id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable("image_id") Long id){
		return service.getImage(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/images/delete/{plant_id}")
	public Result deleteImage(@PathVariable("plant_id") Long id){
		return service.deleteImage(id);
	}
}
