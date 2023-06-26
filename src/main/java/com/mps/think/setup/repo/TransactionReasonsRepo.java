package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 import com.mps.think.setup.model.TransactionReasons;

@Repository
public interface TransactionReasonsRepo extends JpaRepository<TransactionReasons, Integer>{

	List<TransactionReasons> findTransactionReasonsByPublisherId(@Param("pubId") Integer pubId);

	
	
	
}
