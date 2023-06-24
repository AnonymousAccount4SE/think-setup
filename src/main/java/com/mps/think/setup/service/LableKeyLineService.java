package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.LableKeyLine;
import com.mps.think.setup.vo.LableKeyLineVO;

public interface LableKeyLineService {

	public List<LableKeyLine> findAllLableKeyLine();

	public LableKeyLine saveLableKeyLine(LableKeyLineVO lableKeyLine);

	public LableKeyLine updateLableKeyLine(LableKeyLineVO lableKeyLine);

	public LableKeyLine findbyLableKeyLine(Integer lableKeyLineId);
	
	public LableKeyLine deleteByLableKeyLineId(Integer lableKeyLineId);
	
	public List<LableKeyLine> findAllLableKeyLineByPubId(Integer lableKeyLineId);

	public List<LableKeyLine> getAllLableKeyLine();

}
