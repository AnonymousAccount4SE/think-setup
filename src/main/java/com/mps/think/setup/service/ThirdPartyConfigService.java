package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.ThirdPartyConfiguration;
import com.mps.think.setup.vo.ThirdPartyConfigurationVO;


public interface ThirdPartyConfigService {
	
	public List<ThirdPartyConfiguration> getThirdPartyConfiguration();
	
	public ThirdPartyConfiguration saveThirdPartyConfiguration(ThirdPartyConfigurationVO thirdPartyConfigurationVO);

	public ThirdPartyConfiguration updateThirdPartyConfiguration(ThirdPartyConfigurationVO thirdPartyConfigurationVO);

	public ThirdPartyConfiguration findbyThirdPartyConfiguration(Integer id);
	
	public ThirdPartyConfiguration deleteByThirdPartyConfiguration(Integer id);

}
