package com.apap.tutorial5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.repository.FlightDB;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDB flightDB;
	
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDB.save(flight);
	}

	@Override
	public List<FlightModel> getFlightDetailByPilot(String licenseNumber) {
		return flightDB.findByPilotLicenseNumber(licenseNumber);
	}

	@Override
	public void deleteById(long id) {
		flightDB.deleteById(id);
	}

	@Override
	public void updateFlight(long id, FlightModel newFlight) {
		FlightModel updateFlight = flightDB.findById(id);
		updateFlight.setTime(newFlight.getTime());	
		updateFlight.setFlightNumber(newFlight.getFlightNumber());
		updateFlight.setDestination(newFlight.getDestination());
		updateFlight.setOrigin(newFlight.getOrigin());
		flightDB.save(updateFlight);
	}

	@Override
	public FlightModel getFlightDetailById(long id) {
		return flightDB.findById(id);
	}
	
}
