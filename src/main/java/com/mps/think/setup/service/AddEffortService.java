package com.mps.think.setup.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.AddEffort;
import com.mps.think.setup.vo.AddEffortVO;


@Service
public interface AddEffortService {
	
	public List<AddEffort> getAllAddEffort();
	
	public AddEffort saveAddEffort(AddEffortVO addEffort);

	public AddEffort updateAddEffort(AddEffortVO addEffort);

	public AddEffort findbyAddEffortId(Integer id);
	
	public AddEffort deleteByAddEffortId(Integer id);
	
	List<AddEffort> findAllAddEffortForRenewalId(Integer id);

}
