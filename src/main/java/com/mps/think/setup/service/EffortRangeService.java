package com.mps.think.setup.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.EffortRange;
import com.mps.think.setup.vo.EffortRangeVO;

@Service
public interface EffortRangeService {
	
	public List<EffortRange> getAllEffortRange();
	
	public EffortRange saveEffortRange(EffortRangeVO effortRange);

	public EffortRange updateEffortRange(EffortRangeVO effortRange);

	public EffortRange findbyEffortRangeId(Integer id);
	
	public EffortRange deleteByEffortRangeId(Integer id);
	
	public List<EffortRange> findAllEffortRangeByAddRenewalsId(Integer id);

}
