package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.SubmitJob;

@Repository
public interface SubmitJobRepo  extends JpaRepository<SubmitJob, Integer> {
	
	public List<SubmitJob> findByPubIdId(Integer publisherId);

	@Query(value = "SELECT issue_id FROM job_pub_oc WHERE job_id=:jobId",nativeQuery = true)
	List<Integer> getListOfIssue(@Param ("jobId") Integer jobId);
	
}
