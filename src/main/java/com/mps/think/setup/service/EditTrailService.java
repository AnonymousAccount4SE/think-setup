package com.mps.think.setup.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.model.EditTrail;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.SubmitJob;
import com.mps.think.setup.vo.EditTrailView;
import com.mps.think.setup.vo.OrderVO;

public interface EditTrailService {

	public List<EditTrail> getAllEditTrail(Integer pubId);

	public EditTrail saveEditTrailForAddOrder(Order order);
	
	public EditTrail saveEditTrailForSubmitJob(Order order,Integer jobId,String tableName,String before,String after,String columnName);
	
//	public EditTrail saveEditTrailFor(SubmitJob submitJob);

	public EditTrail updateEditTrail(EditTrail editTrail);

	public EditTrail findByEditTrailId(Integer id);

	public List<EditTrail> getAllEditTrailByCustId(Integer custId);
	
	public Page<EditTrailView> findEditTrialById(Integer pubId,Integer customerId,Integer orderId, Pageable page);

}
