package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.EditTrailDelta;
import com.mps.think.setup.repo.EditTrailDeltaRepo;
import com.mps.think.setup.service.EditTrailDeltaService;

public class EditTrailDeltaServiceImpl implements EditTrailDeltaService{
	
	@Autowired
	EditTrailDeltaRepo editTrailDeltaRepo;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<EditTrailDelta> getAllEditTrailDelta(Integer id) {
		return editTrailDeltaRepo.findByEditTrailEditTrailId(id);
	}

	@Override
	public EditTrailDelta saveEditTrailDelta(EditTrailDelta editTrailDelta) {
		return editTrailDeltaRepo.saveAndFlush(mapper.convertValue(editTrailDelta, EditTrailDelta.class));
	}

	@Override
	public EditTrailDelta updateEditTrailDelta(EditTrailDelta editTrailDelta) {
		return editTrailDeltaRepo.saveAndFlush(mapper.convertValue(editTrailDelta, EditTrailDelta.class));
	}

	@Override
	public EditTrailDelta findByEditTrailDeltaId(Integer id) {
		Optional<EditTrailDelta> temp = editTrailDeltaRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		}
		return null;
	}

}
