package com.apap.tutorial5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.repository.PilotDB;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
	@Autowired
	private PilotDB pilotDB;

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDB.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void addPilot(PilotModel pilot) {
		pilotDB.save(pilot);
	}

	@Override
	public void deleteByLicenseNumber(String licenseNumber) {
		pilotDB.deleteByLicenseNumber(licenseNumber);
	}

	@Override
	public void updatePilot(String licenseNumber, PilotModel newPilot) {
		PilotModel updatePilot = pilotDB.findByLicenseNumber(licenseNumber);
		updatePilot.setFlyHour(newPilot.getFlyHour());
		updatePilot.setLicenseNumber(newPilot.getLicenseNumber());
		updatePilot.setName(newPilot.getName());
		pilotDB.save(updatePilot);
	}
}
