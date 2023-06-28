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
	
	@Query(value="SELECT SUM(amount) FROM payment_info\r\n"
			+ "WHERE order_id=:orderId AND STATUS='succeeded' AND payment_mode IN ('Offline','Online')", nativeQuery = true)
	public double paidAmount(@Param ("orderId") Integer orderId);
	
	@Query(value="SELECT net_amount FROM order_parent op JOIN payment_breakdown pb ON op.payment_breakdown_id=pb.id WHERE order_id=:orderId", nativeQuery = true)
	public double netAmount(@Param ("orderId") Integer orderId);
	
	@Query(value = "SELECT num_of_issues FROM order_parent op JOIN payment_breakdown pb ON op.payment_breakdown_id=pb.id\r\n"
			+ "JOIN order_items oi ON op.order_items_id=oi.id  WHERE order_id=:orderId",nativeQuery = true)
	public Integer totalIssueOrder(@Param ("orderId") Integer orderId);
	
	@Query(value = "SELECT liability_issue FROM order_parent op JOIN payment_breakdown pb ON op.payment_breakdown_id=pb.id\r\n"
			+ "JOIN order_items oi ON op.order_items_id=oi.id  WHERE order_id=:orderId",nativeQuery = true)
	public Integer totaLiabilityIssue(@Param ("orderId") Integer orderId);
}
