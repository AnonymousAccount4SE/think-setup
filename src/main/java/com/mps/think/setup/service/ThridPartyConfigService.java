package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.ThridPartyConfiguration;
import com.mps.think.setup.vo.ThridPartyConfigurationVO;


public interface ThridPartyConfigService {
	
	public List<ThridPartyConfiguration> getThridPartyConfiguration();
	
	public ThridPartyConfiguration saveThridPartyConfiguration(ThridPartyConfigurationVO thridPartyConfigurationVO);

	public ThridPartyConfiguration updateThridPartyConfiguration(ThridPartyConfigurationVO thridPartyConfigurationVO);

	public ThridPartyConfiguration findbyThridPartyConfiguration(Integer id);
	
	public ThridPartyConfiguration deleteByThridPartyConfiguration(Integer id);

}
