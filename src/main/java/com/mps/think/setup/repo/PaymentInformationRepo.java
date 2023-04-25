package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.PaymentInformation;

@Repository
public interface PaymentInformationRepo extends JpaRepository<PaymentInformation, Integer> {

	List<PaymentInformation> findByPublisherId(Integer pub);
	List<PaymentInformation> findByOrderCustomerIdCustomerId(Integer customerId);
	PaymentInformation findByOrderOrderId(Integer orderId);
}
