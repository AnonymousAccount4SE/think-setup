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
import com.mps.think.setup.model.LabelLayout;
import com.mps.think.setup.model.RowsInLables;
import com.mps.think.setup.repo.LabelLayoutRepo;
import com.mps.think.setup.service.LabelLayoutService;
import com.mps.think.setup.vo.LabelLayoutVO;

@Service
public class LabelLayoutServiceImpl implements LabelLayoutService{
	
	@Autowired
	private LabelLayoutRepo labelLayoutRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<LabelLayout> getAllLabelLayout() {
		return labelLayoutRepo.findAll();
	}

	@Override
	public LabelLayout saveLabelLayout(LabelLayoutVO labelLayout) {
		return labelLayoutRepo.saveAndFlush(mapper.convertValue(labelLayout, LabelLayout.class));
	}

	@Override
	public LabelLayout updateLabelLayout(LabelLayoutVO labelLayout) {
		return labelLayoutRepo.saveAndFlush(mapper.convertValue(labelLayout, LabelLayout.class));
	}

	@Override
	public LabelLayout findbyLabelLayoutId(Integer id) {
		Optional<LabelLayout> ll = labelLayoutRepo.findById(id);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		if (ll.isPresent()) {
			LabelLayout output = mapper.convertValue(ll.get(), LabelLayout.class);
			List<RowsInLables> rows = output.getLableRows().stream().filter(distinctByKey(RowsInLables::getId)).collect(Collectors.toList());
			output.setLableRows(rows);
			return output;
		}
		return null;
	}

	

    public static java.util.function.Predicate<RowsInLables> distinctByKey(java.util.function.Function<? super RowsInLables, ?> keyExtractor) {
        List<Object> seenKeys = new ArrayList<>();
        return customer -> seenKeys.stream()
                .noneMatch(key -> Objects.equals(keyExtractor.apply(customer), key))
                && seenKeys.add(keyExtractor.apply(customer));
    }

	@Override
	public LabelLayout deleteByLabelLayoutId(Integer id) {
		LabelLayout delete = findbyLabelLayoutId(id);
//		labelLayoutRepo.delete(delete);
		labelLayoutRepo.deleteById(id);
		return delete;
	}

	@Override
	public List<LabelLayout> findAllLabelLayoutForPublisher(Integer pubId) {
		return labelLayoutRepo.findByPubIdId(pubId);
	}

}
