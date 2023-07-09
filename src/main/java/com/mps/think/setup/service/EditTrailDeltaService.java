package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.EditTrailDelta;

public interface EditTrailDeltaService {
	
	public List<EditTrailDelta> getAllEditTrailDelta(Integer id);
	public EditTrailDelta saveEditTrailDelta(EditTrailDelta editTrailDelta);
	public EditTrailDelta updateEditTrailDelta(EditTrailDelta editTrailDelta);
	public EditTrailDelta findByEditTrailDeltaId(Integer id);

}
