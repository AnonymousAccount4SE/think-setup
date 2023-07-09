package com.mps.think.setup.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.AddRenewals;
import com.mps.think.setup.vo.AddRenewalsVO;


@Service
public interface AddRenewalsService {
	
	public List<AddRenewals> findAllAddRenewals();

	public AddRenewals saveAddRenewals(AddRenewalsVO addRenewalsVO);

	public AddRenewals updateAddRenewals(AddRenewalsVO addRenewalsVO);
	
	public AddRenewals deleteAddRenewals(Integer id);

	public AddRenewals findbyAddRenewalsId(Integer id);
	
	public List<AddRenewals> getAllAddRenewalsForPublisher(Integer pubId);
	
	//public Page<AddRenewals> getAllAddRenewalsForPublisher(Integer pubId, Pageable page);

}
