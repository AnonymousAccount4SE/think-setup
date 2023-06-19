package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mps.think.setup.model.SubmitJob;
import com.mps.think.setup.vo.SubmitJobVO;

@Service
public interface SubmitJobService {
	
	public List<SubmitJob> getAllSubmitJob();

	public SubmitJob saveSubmitJob(SubmitJobVO submitJob);

	public SubmitJob updateSubmitJob(SubmitJobVO submitJob);

	public SubmitJob findbySubmitJobId(Integer submitJobId);
	
	public SubmitJob deleteBySubmitJobId(Integer submitJobId);
	
	public List<SubmitJob> findAllSubmitJobByPubId(Integer publisherId);
	
	public List<List<String>> updateProcessJobInDb(String jobStatus ,Integer jobId);

}
