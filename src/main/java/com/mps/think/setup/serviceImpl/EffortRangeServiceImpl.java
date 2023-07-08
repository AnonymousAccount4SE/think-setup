package com.mps.think.setup.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.EffortRange;
import com.mps.think.setup.repo.EffortRangeRepo;
import com.mps.think.setup.service.EffortRangeService;
import com.mps.think.setup.vo.EffortRangeVO;

@Service
public class EffortRangeServiceImpl implements EffortRangeService {
	
	@Autowired
	private EffortRangeRepo effortRangeRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<EffortRange> getAllEffortRange() {
		return effortRangeRepo.findAll();
	}

	@Override
	public EffortRange saveEffortRange(EffortRangeVO effortRange) {
		return effortRangeRepo.saveAndFlush(mapper.convertValue(effortRange, EffortRange.class));
	}

	@Override
	public EffortRange updateEffortRange(EffortRangeVO effortRange) {
		return effortRangeRepo.saveAndFlush(mapper.convertValue(effortRange, EffortRange.class));
	}

	@Override
	public EffortRange findbyEffortRangeId(Integer id) {
		return effortRangeRepo.findById(id).get();
	}

	@Override
	public EffortRange deleteByEffortRangeId(Integer id) {
		EffortRange delete = findbyEffortRangeId(id);
		effortRangeRepo.delete(delete);
		return delete;
	}

	@Override
	public List<EffortRange> findAllEffortRangeByAddRenewalsId(Integer id) {
		return effortRangeRepo.findByAddRenewalId(id);
	}
}
