package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mps.think.setup.model.EditTrailDelta;

public interface EditTrailDeltaRepo extends JpaRepository<EditTrailDelta, Integer>{
	
	List<EditTrailDelta> findByEditTrailEditTrailId(Integer id);
	
	

}
