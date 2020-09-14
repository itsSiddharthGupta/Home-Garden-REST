package com.minorproject.homegarden.plants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantCareDetailsRepository extends JpaRepository<PlantCareDetails, Long> {

}
