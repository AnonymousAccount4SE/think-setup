package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.ExtractFilter;
import com.mps.think.setup.model.ExtractFilterGroup;
import com.mps.think.setup.vo.ExtractFilterGroupVO;
import com.mps.think.setup.vo.ExtractFilterVO;

@Service
public interface ExtractFilterService {
	
	public List<ExtractFilter> getAllExtractFilter();
	
	public ExtractFilter saveExtractFilter(ExtractFilterVO id);

	public ExtractFilter updateExtractFilter(ExtractFilterVO extractFilter);

	public ExtractFilter findbyExtractFilterId(Integer id);
	
	public ExtractFilter deleteByExtractFilterId(Integer id);

 
 	 public List<String> getAllColumnsOfTables(String tableName);

}
