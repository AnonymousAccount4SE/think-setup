package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.ExtractFilter;
import com.mps.think.setup.model.ExtractFilterGroup;
import com.mps.think.setup.model.ExtractFilterGroupBreak;
 import com.mps.think.setup.model.Order;
import com.mps.think.setup.repo.ExtractFilterGroupBreakRepo;
import com.mps.think.setup.repo.ExtractFilterGroupRepo;
import com.mps.think.setup.repo.ExtractFilterRepo;
 import com.mps.think.setup.service.ExtractFilterService;
import com.mps.think.setup.vo.ExtractFilterGroupVO;
import com.mps.think.setup.vo.ExtractFilterVO;
 
@Service
public class ExtractFilterServiceImpl implements ExtractFilterService {
	
	@Autowired
	private ExtractFilterRepo extractFilterRepo;
	@Autowired
	private ExtractFilterGroupRepo extractFilterGroupRepo;
	@Autowired
	private ExtractFilterGroupBreakRepo extractFilterGroupBreakRepo;
	 
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<ExtractFilter> getAllExtractFilter() {
		return extractFilterRepo.findAll();
	}

	@Override
	public ExtractFilter  saveExtractFilter(ExtractFilterVO extractFilter) {
		  
		return extractFilterRepo.saveAndFlush(mapper.convertValue(extractFilter, ExtractFilter.class));
		 
	}

	@Override
	public ExtractFilter updateExtractFilter(ExtractFilterVO extractFilter) {
		return extractFilterRepo.saveAndFlush(mapper.convertValue(extractFilter, ExtractFilter.class));
	}

	@Override
	public ExtractFilter findbyExtractFilterId(Integer id) {
		return extractFilterRepo.findById(id).get();
	}

	@Override
	public ExtractFilter deleteByExtractFilterId(Integer id) {
		ExtractFilter delete = findbyExtractFilterId(id);
		extractFilterRepo.delete(delete);
		return delete;
	}

	  @Override
	public List<String> getAllColumnsOfTables(String tableName) {
 		return extractFilterRepo.getAllColumnsOfTables(tableName);
	}  

}
