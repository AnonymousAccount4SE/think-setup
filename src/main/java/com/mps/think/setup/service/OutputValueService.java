package com.mps.think.setup.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.OutputValue;
import com.mps.think.setup.vo.OutputValueVO;


@Service
public interface OutputValueService {
	
	public List<OutputValue> getAllOutputValue();
	
	public OutputValue saveOutputValue(OutputValueVO outputValue);

	public OutputValue updateOutputValue(OutputValueVO outputValue);

	public OutputValue findbyOutputValueId(Integer id);
	
	public OutputValue deleteByOutputValueId(Integer id);
	
	public List<OutputValue> findAllOutputValueByPubId(Integer id);

}
