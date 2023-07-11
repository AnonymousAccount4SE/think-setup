package com.mps.think.setup.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.OutputSort;
import com.mps.think.setup.repo.OutputSortRepo;
import com.mps.think.setup.service.OutputSortService;
import com.mps.think.setup.vo.OutputSortVO;

@Service
public class OutputSortServiceImpl implements OutputSortService {
	
	@Autowired
	private OutputSortRepo outputSortRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<OutputSort> getAllOutputSort() {
		return outputSortRepo.findAll();
	}

	@Override
	public OutputSort saveOutputSort(OutputSortVO outputSort) {
		return outputSortRepo.saveAndFlush(mapper.convertValue(outputSort, OutputSort.class));
	}

	@Override
	public OutputSort updateOutputSort(OutputSortVO outputSort) {
		return outputSortRepo.saveAndFlush(mapper.convertValue(outputSort, OutputSort.class));
	}

	@Override
	public OutputSort findbyOutputSortId(Integer id) {
		return outputSortRepo.findById(id).get();
	}

	@Override
	public OutputSort deleteByOutputSortId(Integer id) {
		OutputSort delete = findbyOutputSortId(id);
		outputSortRepo.delete(delete);
		return delete;
	}

	@Override
	public List<OutputSort> findAllOutputSortByPubId(Integer id) {
		return outputSortRepo.findByPubIdId(id);
	}

}
