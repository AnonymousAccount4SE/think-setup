package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.SettleRetryDefinitions;

 
@Repository
public interface SettleRetryDefinitionsRepo extends JpaRepository<SettleRetryDefinitions, Integer> {

	List<SettleRetryDefinitions> findSettleRetryDefinitionsByPublisherId(@Param("pubId") Integer pubId);

	
	
	
}
