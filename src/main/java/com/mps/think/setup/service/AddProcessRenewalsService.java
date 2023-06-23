package com.mps.think.setup.service;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.AddProcessRenewals;
import com.mps.think.setup.vo.AddProcessRenewalsVO;

@Service
public interface AddProcessRenewalsService {
	
	public AddProcessRenewals saveAddProcessRenewals (AddProcessRenewalsVO addRenewalPprocess);

}
