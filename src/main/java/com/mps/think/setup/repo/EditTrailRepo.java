package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.EditTrail;
@Repository
public interface EditTrailRepo extends JpaRepository<EditTrail, Integer>{
	
	List<EditTrail> findByPublisherId(Integer pubId);
	
	List<EditTrail> findByCustomerCustomerId(Integer custId);

}
