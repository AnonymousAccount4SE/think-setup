package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.AddPayment;
@Repository
public interface AddPaymentRepo extends JpaRepository<AddPayment, Integer>{
	
	List<AddPayment> findByPublisherId(Integer pubId);
	List<AddPayment> findByCustomerDetailsCustomerId(Integer customerId);

}
