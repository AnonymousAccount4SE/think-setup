package com.mps.think.setup.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.OutputSort;
import com.mps.think.setup.vo.OutputSortVO;

@Service
public interface OutputSortService {
	
	public List<OutputSort> getAllOutputSort();
	
	public OutputSort saveOutputSort(OutputSortVO outputSort);

	public OutputSort updateOutputSort(OutputSortVO outputSort);

	public OutputSort findbyOutputSortId(Integer id);
	
	public OutputSort deleteByOutputSortId(Integer id);
	
	public List<OutputSort> findAllOutputSortByPubId(Integer id);

	

}
