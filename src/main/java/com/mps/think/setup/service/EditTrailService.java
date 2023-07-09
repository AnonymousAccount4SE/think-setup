package com.mps.think.setup.service;

import java.util.List;
import com.mps.think.setup.model.EditTrail;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.SubmitJob;
import com.mps.think.setup.vo.EditTrailVO;
import com.mps.think.setup.vo.OrderVO;

public interface EditTrailService {

	public List<EditTrail> getAllEditTrail(Integer pubId);

	public EditTrail saveEditTrailForAddOrder(Order order);
	
//	public EditTrail saveEditTrailForSubmitJob(SubmitJob submitJob);
	
//	public EditTrail saveEditTrailFor(SubmitJob submitJob);

	public EditTrail updateEditTrail(EditTrailVO editTrailVO);

	public EditTrail findByEditTrailId(Integer id);

	public List<EditTrail> getAllEditTrailByCustId(Integer custId);

}
