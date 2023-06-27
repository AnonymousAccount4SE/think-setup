package com.mps.think.setup.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.InstallmentPlan;
import com.mps.think.setup.model.PaymentThreshold;
import com.mps.think.setup.model.SetupInstallments;

 
@Repository
public interface SetupInstallmentsRepo extends JpaRepository<SetupInstallments, Integer>{


	List<SetupInstallments> findInstallmentByPublisherId(@Param("pubId") Integer pubId);
 	
	
}
