package com.minorproject.homegarden.plants;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plant_details")
public class PlantDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "plant_name", nullable = false, unique = true)
	private String name;
	@Column(name = "image_url", columnDefinition = "TEXT", length = 1000000)
	private String imageUrl;
	@Column(name = "is_indoor_plant")
	private Boolean isIndoor;
	private String temperature;
	private String water;
	@Lob
	@Column(nullable = false, name = "plant_description")
	private String description;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "plantInfo")
	private PlantCareDetails careInfo;

	public PlantDetails() {
	}

	public PlantDetails(String name, String description, Boolean isIndoor) {
		this.description = description;
		this.name = name;
		this.isIndoor = isIndoor;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getTemperature() {
		return temperature;
	}

	public String getWater() {
		return water;
	}

	public String getDescription() {
		return description;
	}

	public PlantCareDetails getCareInfo() {
		return careInfo;
	}

	public Boolean getIsIndoor() {
		return isIndoor;
	}

	public void setIsIndoor(Boolean isIndoor) {
		this.isIndoor = isIndoor;
	}

	public void setCareInfo(PlantCareDetails careInfo) {
		this.careInfo = careInfo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PlantDetails [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", isIndoor=" + isIndoor
				+ ", temperature=" + temperature + ", water=" + water + ", description=" + description + ", careInfo="
				+ careInfo + "]";
	}
}
