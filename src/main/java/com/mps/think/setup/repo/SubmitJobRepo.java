package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.SubmitJob;

@Repository
public interface SubmitJobRepo  extends JpaRepository<SubmitJob, Integer> {
	
	public List<SubmitJob> findByPubIdId(Integer publisherId);

}
