package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.AddProcessRenewals;
import com.mps.think.setup.vo.AddProcessRenewalsVO;

@Service
public interface AddProcessRenewalsService {
	
	public AddProcessRenewals saveAddProcessRenewals (AddProcessRenewalsVO addRenewalPprocess);
	
	public List<AddProcessRenewals> getAllAddProcessRenewalsForPublisher(Integer pubId);


}
