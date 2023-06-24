package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.AddProcess;


@Repository
public interface AddProcessRepo extends JpaRepository<AddProcess, Integer> {
	
//	public List<AddProcess> findByprocesstypeidPid(Integer pid);
	
	List<AddProcess> findByPubIdId(Integer pubId);

}
