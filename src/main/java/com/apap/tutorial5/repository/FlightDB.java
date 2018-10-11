package com.apap.tutorial5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial5.model.FlightModel;

@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long> {
	List<FlightModel> findByPilotLicenseNumber(String licenseNumber);
	void deleteById(long id);
	FlightModel findById(long id);
}
