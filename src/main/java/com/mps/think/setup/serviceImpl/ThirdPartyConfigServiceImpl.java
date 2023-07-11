package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.ThirdPartyConfiguration;
import com.mps.think.setup.repo.ThirdPartyConfigRepo;
import com.mps.think.setup.service.ThirdPartyConfigService;
import com.mps.think.setup.vo.ThirdPartyConfigurationVO;

@Service
public class ThirdPartyConfigServiceImpl implements ThirdPartyConfigService {

	@Autowired
	ThirdPartyConfigRepo thirdPartyConfigRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<ThirdPartyConfiguration> getThirdPartyConfiguration() {
		return thirdPartyConfigRepo.findAll();
	}

	@Override
	public ThirdPartyConfiguration saveThirdPartyConfiguration(ThirdPartyConfigurationVO thirdPartyConfigurationVO) {
		return thirdPartyConfigRepo
				.saveAndFlush(mapper.convertValue(thirdPartyConfigurationVO, ThirdPartyConfiguration.class));
	}

	@Override
	public ThirdPartyConfiguration updateThirdPartyConfiguration(ThirdPartyConfigurationVO thirdPartyConfigurationVO) {
		return thirdPartyConfigRepo
				.saveAndFlush(mapper.convertValue(thirdPartyConfigurationVO, ThirdPartyConfiguration.class));

	}

	@Override
	public ThirdPartyConfiguration findbyThirdPartyConfiguration(Integer id) {
		// TODO Auto-generated method stub
		return thirdPartyConfigRepo.findById(id).get();
	}

	@Override
	public ThirdPartyConfiguration deleteByThirdPartyConfiguration(Integer id) {

		ThirdPartyConfiguration delete = findbyThirdPartyConfiguration(id);
		thirdPartyConfigRepo.delete(delete);
		return delete;
	}

}
