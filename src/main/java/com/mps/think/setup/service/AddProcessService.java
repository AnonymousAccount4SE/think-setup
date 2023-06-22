package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.AddProcess;
import com.mps.think.setup.model.Addprocessmapping;
import com.mps.think.setup.model.LabelLayout;
import com.mps.think.setup.vo.AddProcessVO;


@Service
public interface AddProcessService {
	
	public List<AddProcess> getAllProcess();
	
	public AddProcess saveProcess(AddProcessVO process);

	public AddProcess updateProcess(AddProcessVO process);

	public AddProcess findbyProcessId(Integer process_id);
	
	public AddProcess deleteByProcessId(Integer process_id);

	public List<Addprocessmapping> getAllAddprocessmapping();
	
//	public List<AddProcess> findAllAddProcessByPId(Integer pId);
	
	List<AddProcess> findAllAddProcessForPublisher(Integer pubId);

}
