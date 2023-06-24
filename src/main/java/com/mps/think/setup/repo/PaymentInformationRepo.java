package com.mps.think.setup.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.PaymentInformation;

@Repository
public interface PaymentInformationRepo extends JpaRepository<PaymentInformation, Integer> {

	Page<PaymentInformation> findByPublisherId(Integer pub, Pageable page);
	Page<PaymentInformation> findByOrderCustomerIdCustomerId(Integer customerId, Pageable page);

	Page<PaymentInformation> findByOrderOrderId(Integer orderId, Pageable page);
	
	@Query("SELECT pinfo FROM PaymentInformation pinfo WHERE (pinfo.publisher.id = :pubId OR :pubId IS NULL) AND (DATE(pinfo.createdAt) >= :paymentStart AND DATE(pinfo.createdAt) <= :paymentEnd)")
	Page<PaymentInformation> findAllDailyCashReport(
			@Param("pubId") Integer pubId,
			@Param("paymentStart") Date paymentStart, 
			@Param("paymentEnd") Date paymentEnd, Pageable page);
	
	@Query(value="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'think_setup_new' AND TABLE_NAME = 'payment_info';",nativeQuery = true)
	public List<String> findAllColumnForPaymentInfo();
}
