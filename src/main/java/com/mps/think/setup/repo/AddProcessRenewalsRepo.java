package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.AddProcessRenewals;

@Repository
public interface AddProcessRenewalsRepo extends JpaRepository<AddProcessRenewals, Integer>{

	List<AddProcessRenewals> findByPubIdId(Integer pubId);
	
}
