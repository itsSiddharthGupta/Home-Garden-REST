package com.minorproject.homegarden.plants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plant_care_details")
public class PlantCareDetails {
	@Id
	private Long id;
	@Column(name = "water_details", columnDefinition = "TEXT", length = 1000000)
	private String waterDetails;
	@Column(name = "temperature_details", columnDefinition = "TEXT", length = 1000000)
	private String temperatureDetails;
	@Column(name = "light_details", columnDefinition = "TEXT", length = 1000000)
	private String lightDetails;
	@Column(name = "soil_details", columnDefinition = "TEXT", length = 1000000)
	private String soilDetails;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JsonIgnore
	private PlantDetails plantInfo;

	public PlantCareDetails() {
	}

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
