package com.minorproject.homegarden.plants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plant_care_details")
public class PlantCareDetails {
	@Id
	private Long id;
	@Column(name = "water_details")
	private String waterDetails;
	@Column(name = "temperature_details")
	private String temperatureDetails;
	@Column(name = "light_details")
	private String lightDetails;
	@Column(name = "soil_details")
	private String soilDetails;
	@OneToOne
	@MapsId
	private PlantDetails plantInfo;

	public PlantCareDetails(String waterDetails, String temperatureDetails, String lightDetails, String soilDetails) {
		super();
		this.waterDetails = waterDetails;
		this.temperatureDetails = temperatureDetails;
		this.lightDetails = lightDetails;
		this.soilDetails = soilDetails;
	}

	public Long getId() {
		return id;
	}

	public String getWaterDetails() {
		return waterDetails;
	}

	public String getTemperatureDetails() {
		return temperatureDetails;
	}

	public String getLightDetails() {
		return lightDetails;
	}

	public String getSoilDetails() {
		return soilDetails;
	}

	public PlantDetails getPlantInfo() {
		return plantInfo;
	}

	public void setWaterDetails(String waterDetails) {
		this.waterDetails = waterDetails;
	}

	public void setTemperatureDetails(String temperatureDetails) {
		this.temperatureDetails = temperatureDetails;
	}

	public void setLightDetails(String lightDetails) {
		this.lightDetails = lightDetails;
	}

	public void setSoilDetails(String soilDetails) {
		this.soilDetails = soilDetails;
	}

	public void setPlantInfo(PlantDetails plantInfo) {
		this.plantInfo = plantInfo;
	}

	@Override
	public String toString() {
		return "PlantCareDetails [id=" + id + ", waterDetails=" + waterDetails + ", temperatureDetails="
				+ temperatureDetails + ", lightDetails=" + lightDetails + ", soilDetails=" + soilDetails
				+ ", plantInfo=" + plantInfo + "]";
	}
}
