package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.AddRenewals;

@Repository
public interface AddRenewalsRepo extends JpaRepository<AddRenewals, Integer>{
	
	List<AddRenewals> findByPubIdId(Integer pubId);

}
