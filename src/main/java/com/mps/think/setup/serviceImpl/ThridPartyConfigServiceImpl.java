package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.ThridPartyConfiguration;
import com.mps.think.setup.repo.ThridPartyConfigRepo;
import com.mps.think.setup.service.ThridPartyConfigService;
import com.mps.think.setup.vo.ThridPartyConfigurationVO;

@Service
public class ThridPartyConfigServiceImpl implements ThridPartyConfigService {

	@Autowired
	ThridPartyConfigRepo thridPartyConfigRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<ThridPartyConfiguration> getThridPartyConfiguration() {
		return thridPartyConfigRepo.findAll();
	}

	@Override
	public ThridPartyConfiguration saveThridPartyConfiguration(ThridPartyConfigurationVO thridPartyConfigurationVO) {
		return thridPartyConfigRepo
				.saveAndFlush(mapper.convertValue(thridPartyConfigurationVO, ThridPartyConfiguration.class));
	}

	@Override
	public ThridPartyConfiguration updateThridPartyConfiguration(ThridPartyConfigurationVO thridPartyConfigurationVO) {
		return thridPartyConfigRepo
				.saveAndFlush(mapper.convertValue(thridPartyConfigurationVO, ThridPartyConfiguration.class));

	}

	@Override
	public ThridPartyConfiguration findbyThridPartyConfiguration(Integer id) {
		// TODO Auto-generated method stub
		return thridPartyConfigRepo.findById(id).get();
	}

	@Override
	public ThridPartyConfiguration deleteByThridPartyConfiguration(Integer id) {

		ThridPartyConfiguration delete = findbyThridPartyConfiguration(id);
		thridPartyConfigRepo.delete(delete);
		return delete;
	}

}
