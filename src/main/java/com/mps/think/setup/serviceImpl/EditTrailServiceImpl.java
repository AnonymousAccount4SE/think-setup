package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.EditTrail;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.SubmitJob;
import com.mps.think.setup.repo.EditTrailRepo;
import com.mps.think.setup.service.EditTrailService;
import com.mps.think.setup.vo.EditTrailVO;
import com.mps.think.setup.vo.OrderVO;
@Service
public class EditTrailServiceImpl implements EditTrailService{
	
	@Autowired
	EditTrailRepo editTrailRepo;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<EditTrail> getAllEditTrail(Integer pubId) {
		return editTrailRepo.findByPublisherId(pubId);
	}

	@Override
	public EditTrail saveEditTrailForAddOrder(Order order) {
		EditTrail etrail=new EditTrail();
		etrail.setBaseAmount(order.getPaymentBreakdown().getBaseAmount());
		etrail.setLocalAmount(null);
		etrail.setCreationDate(order.getCreatedAt());
		etrail.setCurrency(order.getPaymentBreakdown().getCurrency());
		CustomerDetails customer=new CustomerDetails();
		customer.setCustomerId(order.getCustomerId().getCustomerId());
		etrail.setCustomer(customer);
		etrail.setDemographicSeq(null);
		etrail.setDocumentReferenceId(null);
		etrail.setEdited(false);
		etrail.setJobId(null);
		etrail.setOrderId(order.getOrderId());
		etrail.setPaymentSeq(null);
		etrail.setSubscripId(null);
		etrail.setTableEnum("order_parent");
		etrail.setxActionName("add_order");
		Publisher pub=new Publisher();
		pub.setId(order.getCustomerId().getPublisher().getId());
		etrail.setPublisher(pub);
		EditTrail temp = editTrailRepo.saveAndFlush(etrail);
		etrail.setEditTrailId(temp.getEditTrailId());
		return etrail;
	}

	@Override
	public EditTrail updateEditTrail(EditTrailVO editTrailVO) {
		return editTrailRepo.saveAndFlush(mapper.convertValue(editTrailVO, EditTrail.class));
	}

	@Override
	public EditTrail findByEditTrailId(Integer id) {
		Optional<EditTrail> temp = editTrailRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get() ;
		}
		return null;
	}

	@Override
	public List<EditTrail> getAllEditTrailByCustId(Integer custId) {
		return editTrailRepo.findByCustomerCustomerId(custId);
	}

//	@Override
//	public EditTrail saveEditTrailForSubmitJob(SubmitJob submitJob) {
//		
//		EditTrail etrail=new EditTrail();
//		etrail.setBaseAmount(submitJob.geto order.getPaymentBreakdown().getBaseAmount());
//		etrail.setLocalAmount(null);
//		etrail.setCreationDate(order.getCreatedAt());
//		etrail.setCurrency(order.getPaymentBreakdown().getCurrency());
//		CustomerDetails customer=new CustomerDetails();
//		customer.setCustomerId(order.getCustomerId().getCustomerId());
//		etrail.setCustomer(customer);
//		etrail.setDemographicSeq(null);
//		etrail.setDocumentReferenceId(null);
//		etrail.setEdited(false);
//		etrail.setJobId(null);
//		etrail.setOrderId(order.getOrderId());
//		etrail.setPaymentSeq(null);
//		etrail.setSubscripId(null);
//		etrail.setTableEnum("order_parent");
//		etrail.setxActionName("add_order");
//		Publisher pub=new Publisher();
//		pub.setId(order.getCustomerId().getPublisher().getId());
//		etrail.setPublisher(pub);
//		EditTrail temp = editTrailRepo.saveAndFlush(etrail);
//		etrail.setEditTrailId(temp.getEditTrailId());
//		return etrail;
//	}

}
