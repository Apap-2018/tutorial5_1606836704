package com.apap.tutorial5.service;

import java.util.List;

import com.apap.tutorial5.model.FlightModel;

public interface FlightService {
	List<FlightModel> getFlightDetailByPilot(String licenseNumber);
	FlightModel getFlightDetailById(long id);
	void addFlight(FlightModel flight);
	void deleteById(long id);
	void updateFlight(long id, FlightModel newFlight);
}
