package com.minorproject.homegarden.plants;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PlantDetailRepository extends JpaRepository<PlantDetails, Long> {

	PlantDetails findByName(String name);

}
