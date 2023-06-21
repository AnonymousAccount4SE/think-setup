package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.LableKeyLine;
import com.mps.think.setup.model.RowsInKeylineLables;
import com.mps.think.setup.repo.LableKeyLineRepo;
import com.mps.think.setup.service.LableKeyLineService;
import com.mps.think.setup.vo.LableKeyLineVO;

@Service
public class LableKeyLineServiceImpl implements LableKeyLineService {

	@Autowired
	LableKeyLineRepo lableKeyLineRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<LableKeyLine> findAllLableKeyLine() {
		return lableKeyLineRepo.findAll();
	}

	@Override
	public LableKeyLine saveLableKeyLine(LableKeyLineVO lableKeyLineVo) {
		return lableKeyLineRepo.saveAndFlush(mapper.convertValue(lableKeyLineVo, LableKeyLine.class));
	}

	@Override
	public LableKeyLine updateLableKeyLine(LableKeyLineVO lableKeyLineVo) {
		return lableKeyLineRepo.saveAndFlush(mapper.convertValue(lableKeyLineVo, LableKeyLine.class));
	}

	@Override
	public LableKeyLine findbyLableKeyLine(Integer lableKeyLineId) {
		Optional<LableKeyLine> ll = lableKeyLineRepo.findById(lableKeyLineId);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		if (ll.isPresent()) {
			LableKeyLine output = mapper.convertValue(ll.get(), LableKeyLine.class);
			List<RowsInKeylineLables> rows = output.getKeylableRows().stream().filter(distinctByKey(RowsInKeylineLables::getId)).collect(Collectors.toList());
			output.setKeylableRows(rows);
			return output;
		}
		return null;
	}



	private Predicate<? super RowsInKeylineLables> distinctByKey(java.util.function.Function<? super RowsInKeylineLables, ?> keyExtractor) {
		 List<Object> seenKeys = new ArrayList<>();
	        return customer -> seenKeys.stream()
	                .noneMatch(key -> Objects.equals(keyExtractor.apply(customer), key))
	                && seenKeys.add(keyExtractor.apply(customer));
	}

	@Override
	public LableKeyLine deleteByLableKeyLineId(Integer lableKeyLineId) {
		LableKeyLine delete = findbyLableKeyLine(lableKeyLineId);
		lableKeyLineRepo.delete(delete);
		return delete;
	}

	@Override
	public List<LableKeyLine> findAllLableKeyLineByPubId(Integer lableKeyLineId) {
		return lableKeyLineRepo.findByPubIdId(lableKeyLineId);
	}

	@Override
	public List<LableKeyLine> getAllLableKeyLine() {
		return lableKeyLineRepo.findAll();
	}

}
