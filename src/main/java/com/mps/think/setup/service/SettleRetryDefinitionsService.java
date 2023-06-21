package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.SettleRetryDefinitions;
import com.mps.think.setup.vo.SettleRetryDefinitionsVO;

public interface SettleRetryDefinitionsService {

	 public List<SettleRetryDefinitions> getAllSettleRetryDefinitions();

	public SettleRetryDefinitions saveSettleRetryDefinitions(SettleRetryDefinitionsVO settleRetryDefinitions);

	public SettleRetryDefinitions updateSettleRetryDefinitions(SettleRetryDefinitionsVO settleRetryDefinitions);

	public SettleRetryDefinitions getSettleRetryDefinitionsByid(Integer id);

	public SettleRetryDefinitions deleteSettleRetryDefinitionsById(Integer id);

}
