package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService {
	private List<PilotModel> archivePilot;
	
	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);
	}
	
	@Override
	public List<PilotModel> getPilotList(){
		return archivePilot;
	}

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		for (int i = 0; i<archivePilot.size(); i++) {
			if(archivePilot.get(i).equals(licenseNumber)) {
				return archivePilot.get(i);
			}
		}
		
		return null;
	}

	@Override
	public PilotModel getPilotDetailById(String id) {
		// TODO Auto-generated method stub
		for (PilotModel pilot : archivePilot) {
			if(pilot.getId().equalsIgnoreCase(id)) {
				return pilot;
			}
		}
		return null;
	}
	
	@Override
	public void deletePilot(PilotModel pilotModel) {
		archivePilot.remove(pilotModel);
	}

}
