package com.mps.think.setup.repo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.PaymentInformation;

@Repository
public interface AddOrderRepo extends JpaRepository<Order, Integer> {
	
	@Query(value="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'think_setup_new' AND TABLE_NAME IN ( 'order_parent' ,'order_key_information' , 'order_items', 'payment_breakdown' , 'order_delivery_options', 'order_auxiliary_information', 'multi_line_item_order','oc' );",nativeQuery = true)
	public List<String> findAllColumnForOrders();
	
	
	
	public Page<Order> findAllByCustomerIdPublisherId(Pageable page,Integer pubId) throws Exception;
	
	public Page<Order> findByCustomerIdCustomerId(Integer customerId, Pageable page) throws Exception;
	
	public List<Order> findByOrderClassOcId(Integer ocId) throws Exception;

	@Query("SELECT o FROM Order o JOIN o.customerId cus JOIN o.keyOrderInformation keyInfo WHERE (cus.publisher.id = :pubId OR :pubId IS NULL) AND"
			+ "(o.orderStatus LIKE '%'||:orderStatus||'%' OR :orderStatus IS NULL) "
			+ "AND ((keyInfo.orderDate >= :ordersFrom AND keyInfo.orderDate <= :ordersTill) OR (:ordersFrom IS NULL OR :ordersTill IS NULL)) "
			+ "AND (cus.customerId LIKE '%'||:customerId||'%' OR :customerId IS NULL) "
			+ "AND (CONCAT(cus.fname, ' ', cus.lname) LIKE '%'||:customerName||'%' OR :customerName IS NULL)")
	public Page<Order> findAllOrdersForReport(
			                                  @Param("pubId") Integer pubId, 
			                                  @Param("orderStatus") String orderStatus,
											  @Param("ordersFrom") Date ordersFrom, 
											  @Param("ordersTill") Date ordersTill, 
											  @Param("customerId") Integer customerId, 
											  @Param("customerName") String customerName, Pageable page);
	
	
//	@Query("SELECT o FROM Order o "
//			+ "JOIN o.orderAddresses oa "
//			+ "JOIN o.customerId cusDet "
//			+ "JOIN o.keyOrderInformation keyInfo "
//			+ "JOIN o.orderItemsAndTerms itemTerms "
//			+ "JOIN o.paymentBreakdown payment "
//			+ "JOIN o.orderClass oc "
//			+ "JOIN o.auxiliaryInformation auxInfo "
//			+ "JOIN oa.address oadd "
//			+ "JOIN keyInfo.orderCode kioc "
//			+ "JOIN keyInfo.sourceCode srcCod "
//			+ "JOIN kioc.orderCodes ordCod "
//			+ "JOIN itemTerms.subsProdPkgDef subDef "
//			+ "JOIN itemTerms.term t "
//			+ "JOIN payment.rateCard rc "
//			+ "WHERE (ordCod.orderCode LIKE '%'||:keyword||'%') OR (srcCod.sourceCode LIKE '%'||:keyword||'%') OR "
//			+ "(CONCAT(keyInfo.orderStatus, ' ', keyInfo.orderCategory, ' ', keyInfo.purchaseOrder, ' ', COALESCE(keyInfo.agent, '')) LIKE '%'||:keyword||'%') OR "
//			+ "(keyInfo.orderDate LIKE '%'||:keyword||'%') OR "
//			+ "(keyInfo.agentReferenceNum LIKE '%'||:keyword||'%') OR "
//			+ "(CONCAT(oadd.addressName, ' ', oadd.name, ' ', oadd.addressLine1, ' ', COALESCE(oadd.addressLine2, ''), ' ', oadd.city, ' ', oadd.state, ' ', oadd.country, ' ', oadd.phone) LIKE '%'||:keyword||'%') OR "
//			+ "(CONCAT(oadd.zipCode, ' ', oadd.countryCode) LIKE '%'||:keyword||'%') OR "
//			+ "(CONCAT(o.orderType, ' ', o.orderStatus) LIKE '%'||:keyword||'%') OR "
//			+ "(o.orderId LIKE '%'||:keyword||'%') OR "
//			+ "(CONCAT(subDef.subscriptionDefCode, ' ', t.term, ' ', itemTerms.numOfIssues, ' ', itemTerms.copiesPerIssue, ' ', itemTerms.validFrom, ' ', itemTerms.validTo, ' ', "
//			+ "COALESCE(itemTerms.liabilityIssue, ''), ' ', COALESCE(itemTerms.extendedIssue, '')) LIKE '%'||:keyword||'%') OR "
//			+ "(CONCAT(rc.rateCard, ' ', payment.paymentStatus, ' ', payment.netAmount) LIKE '%'||:keyword||'%') OR "
//			+ "(CONCAT(oc.orderClassName, ' ', oc.ocType) LIKE '%'||:keyword||'%') OR "
//			+ "(CONCAT(cusDet.fname, ' ', cusDet.lname, ' ', cusDet.initialName, ' ', cusDet.company, ' ', cusDet.email, ' ', cusDet.primaryPhone) LIKE '%'||:keyword||'%') OR "
//			+ "(auxInfo.orderAuxJSON LIKE '%'||:keyword||'%') "
//			+ "GROUP BY o.orderId")
//	public Page<Order> findOrdersBySearch(@Param("keyword") String keyword, Pageable page);
	
	
	/*
	 * o -> order
	 * keyInfo -> key information in order
	 * oitem -> order item and terms in order
	 * pay -> payment breakdown in order
	 * dbil -> delivery and billing options in order
	 * auxInfo -> auxiliary information in order
	 * oadd -> order address mapping of order
	 * a -> addresses (multiple for single order) 
	 * c -> customer (many order for single customer)
	 * ocls -> order class
	 * ocs -> order code super in keyInfo
	 * oc -> order code in order code super
	 * sc -> source code in keyInfo
	 * subdef -> subscription defination in order item and terms
	 * term -> term in order item and terms
	 * rc -> rate card in payment breakdown
	 * cusCat -> customer category in customer
	 * pthres -> paymentThreshold in customer details
	 * 
	*/
	
	@Query("SELECT o FROM Order o JOIN o.keyOrderInformation keyInfo JOIN o.orderItemsAndTerms oitem JOIN o.paymentBreakdown pay JOIN o.deliveryAndBillingOptions dbil "
			+ "JOIN o.auxiliaryInformation auxInfo LEFT JOIN o.orderAddresses oadd LEFT JOIN oadd.address a LEFT JOIN o.customerId c LEFT JOIN o.orderClass ocls JOIN keyInfo.orderCode ocs "
			+ "JOIN ocs.orderCodes oc JOIN keyInfo.sourceCode sc JOIN oitem.subsProdPkgDef subdef JOIN oitem.term term JOIN pay.rateCard rc JOIN c.customerCategory cusCat LEFT JOIN c.paymentThreshold pthres WHERE "
			+ "((c.publisher.id = :pubId OR :pubId IS NULL) AND (c.customerId = :customerId OR :customerId IS NULL) AND ((o.orderId LIKE '%'||:keyword||'%') OR (o.orderType LIKE '%'||:keyword||'%') "
			+ "OR (o.orderStatus LIKE '%'||:keyword||'%') OR (keyInfo.orderCategory LIKE '%'||:keyword||'%') OR (keyInfo.orderStatus LIKE '%'||:keyword||'%') "
			+ "OR (keyInfo.orderDate LIKE '%'||:keyword||'%') OR (keyInfo.purchaseOrder LIKE '%'||:keyword||'%') OR (keyInfo.agent LIKE '%'||:keyword||'%') "
			+ "OR (keyInfo.agentReferenceNum LIKE '%'||:keyword||'%') OR (oitem.issue LIKE '%'||:keyword||'%') OR (oitem.enumeration LIKE '%'||:keyword||'%') "
			+ "OR (oitem.copiesPerIssue LIKE '%'||:keyword||'%') OR (oitem.effectiveDate LIKE '%'||:keyword||'%') OR (oitem.numOfIssues LIKE '%'||:keyword||'%') "
			+ "OR (oitem.validFrom LIKE '%'||:keyword||'%') OR (oitem.validTo LIKE '%'||:keyword||'%') OR (oitem.liabilityIssue LIKE '%'||:keyword||'%') "
			+ "OR (oitem.extendedIssue LIKE '%'||:keyword||'%') OR (oitem.extendedByDays LIKE '%'||:keyword||'%') OR (oitem.quantityOrdered LIKE '%'||:keyword||'%') "
			+ "OR (pay.currencyType LIKE '%'||:keyword||'%') OR (pay.effectiveDate LIKE '%'||:keyword||'%') OR (pay.paymentStatus LIKE '%'||:keyword||'%') "
			+ "OR (pay.baseAmount LIKE '%'||:keyword||'%') OR (pay.currency LIKE '%'||:keyword||'%') OR (pay.discount LIKE '%'||:keyword||'%') OR (pay.tax LIKE '%'||:keyword||'%') "
			+ "OR (pay.grossAmount LIKE '%'||:keyword||'%') OR (pay.commission LIKE '%'||:keyword||'%') OR (pay.shippingCharge LIKE '%'||:keyword||'%') "
			+ "OR (pay.netAmount LIKE '%'||:keyword||'%') OR (dbil.deliveryMethod LIKE '%'||:keyword||'%') OR (auxInfo.orderAuxJSON LIKE '%'||:keyword||'%') "
			+ "OR (a.addressName LIKE '%'||:keyword||'%') OR (a.addressType LIKE '%'||:keyword||'%') OR (a.addressCategory LIKE '%'||:keyword||'%') "
			+ "OR (a.status LIKE '%'||:keyword||'%') OR (a.name LIKE '%'||:keyword||'%') OR (a.addressLine1 LIKE '%'||:keyword||'%') OR (a.addressLine2 LIKE '%'||:keyword||'%') "
			+ "OR (a.zipCode LIKE '%'||:keyword||'%') OR (a.city LIKE '%'||:keyword||'%') OR (a.state LIKE '%'||:keyword||'%') OR (a.country LIKE '%'||:keyword||'%') "
			+ "OR (a.countryCode LIKE '%'||:keyword||'%') OR (a.phone LIKE '%'||:keyword||'%') OR (a.validFrom LIKE '%'||:keyword||'%') OR (a.validTo LIKE '%'||:keyword||'%') "
			+ "OR (a.frequency LIKE '%'||:keyword||'%') OR (a.selectionFrom LIKE '%'||:keyword||'%') OR (a.selectionTo LIKE '%'||:keyword||'%') OR (a.addressAuxJSON LIKE '%'||:keyword||'%') "
			+ "OR (c.fname LIKE '%'||:keyword||'%') OR (c.lname LIKE '%'||:keyword||'%') OR (c.initialName LIKE '%'||:keyword||'%') OR (c.suffix LIKE '%'||:keyword||'%') "
			+ "OR (c.company LIKE '%'||:keyword||'%') OR (c.department LIKE '%'||:keyword||'%') OR (c.email LIKE '%'||:keyword||'%') OR (c.countryCode LIKE '%'||:keyword||'%') "
			+ "OR (c.primaryPhone LIKE '%'||:keyword||'%') OR (c.mobileNumber LIKE '%'||:keyword||'%') "
			+ "OR (c.taxId LIKE '%'||:keyword||'%') OR (c.secondaryEmail LIKE '%'||:keyword||'%') OR (c.secondaryPhone LIKE '%'||:keyword||'%') OR (c.listRental LIKE '%'||:keyword||'%') "
			+ "OR (c.salesRepresentative LIKE '%'||:keyword||'%') OR (c.creditStatus LIKE '%'||:keyword||'%') OR (c.fax LIKE '%'||:keyword||'%') OR (c.institutionalId LIKE '%'||:keyword||'%') "
			+ "OR (c.parentInstitutionalId LIKE '%'||:keyword||'%') OR (c.chargeTaxOn LIKE '%'||:keyword||'%') OR (c.paymentOptions LIKE '%'||:keyword||'%') OR (c.configurationOptionsforOrders LIKE '%'||:keyword||'%') "
			+ "OR (c.newOrderCommission LIKE '%'||:keyword||'%') OR (c.renewalCommission LIKE '%'||:keyword||'%') "
			+ "OR (pthres.paymentThresholdCode LIKE '%'||:keyword||'%') OR (c.custAuxFieldJSON LIKE '%'||:keyword||'%') OR (ocls.orderClassName LIKE '%'||:keyword||'%') "
			+ "OR (ocls.ocType LIKE '%'||:keyword||'%') OR (oc.orderCode LIKE '%'||:keyword||'%') OR (oc.description LIKE '%'||:keyword||'%') "
			+ "OR (oc.orderType LIKE '%'||:keyword||'%') OR (oc.orderCodeId LIKE '%'||:keyword||'%') OR (oc.orderClassId LIKE '%'||:keyword||'%') "
			+ "OR (sc.sourceCode LIKE '%'||:keyword||'%') OR (sc.sourceCodeType LIKE '%'||:keyword||'%') OR (sc.description LIKE '%'||:keyword||'%') OR (subdef.subscriptionDefCode LIKE '%'||:keyword||'%') "
			+ "OR (subdef.description LIKE '%'||:keyword||'%') OR (subdef.subDefStatus LIKE '%'||:keyword||'%') OR (subdef.subDefId LIKE '%'||:keyword||'%') "
			+ "OR (subdef.media LIKE '%'||:keyword||'%') OR (subdef.edition LIKE '%'||:keyword||'%') OR (subdef.category LIKE '%'||:keyword||'%') "
			+ "OR (term.term LIKE '%'||:keyword||'%') OR (term.description LIKE '%'||:keyword||'%') OR (rc.rateCard LIKE '%'||:keyword||'%') OR (rc.itemtype LIKE '%'||:keyword||'%') "
			+ "OR (rc.description LIKE '%'||:keyword||'%') OR (cusCat.thinkCategory LIKE '%'||:keyword||'%') OR (cusCat.custCategory LIKE '%'||:keyword||'%'))) "
			+ "GROUP BY o.orderId")
	public Page<Order> findOrdersBySearch(@Param("pubId") Integer pubId, @Param("customerId") Integer customerId, @Param("keyword") String keyword, Pageable page);
	

	public List<Order> findByCustomerIdCustomerId(Integer customerId);
	
	@Query("SELECT o FROM Order o JOIN o.keyOrderInformation k RIGHT JOIN o.customerId c WHERE (c.customerId = :customerId) AND (k.orderDate LIKE '%'||:year||'%') GROUP BY o.orderId")
	List<Order> findOrderCountForCustomerInYear(@Param("customerId") Integer customerId, @Param("year") String year);
	
	@Query(value = "SELECT o.* FROM order_parent o JOIN customer c ON c.id = o.customer_id WHERE c.id = :customerId ORDER BY o.order_id DESC LIMIT 2",
			nativeQuery = true)
	List<Order> fetchRecentTwoOrderByCustomerId(@Param("customerId") Integer customerId);

	@Query("SELECT o FROM Order o JOIN o.keyOrderInformation keyInfo JOIN o.customerId ci WHERE (ci.publisher.id = :pubId OR :pubId IS NULL) AND "
			+"(:oredrStart IS NULL OR DATE(keyInfo.orderDate) >= :oredrStart) AND "
			+"(:orderEnd IS NULL OR DATE(keyInfo.orderDate) <= :orderEnd) AND "
			+ "(:orderType IS NULL OR o.orderType LIKE '%'||:orderType||'%')") 
	public Page<Order> findAllCustomerSalesList(
			@Param("pubId") Integer pubId,
			@Param("oredrStart") Date oredrStart, 
			@Param("orderEnd") Date orderEnd, 
			@Param("orderType") String orderType, Pageable page);

	
	@Query(value = "SELECT *\n"
			+ "FROM order_parent o WHERE o.customer_id = :customerId\n"
			+ "ORDER BY (o.order_id = :orderId) DESC, o.order_id ASC",
			nativeQuery = true)
	List<Order> fetchOrdersForPaymentsByCustomerIdPrioGivenOrderId(@Param("customerId") Integer customerId, @Param("orderId") Integer orderId);
//	countQuery = "SELECT COUNT(*) FROM order_parent o WHERE o.customer_id = :customerId",
	
	@Query("SELECT o FROM Order o JOIN o.customerId c WHERE (:publisherId IS NULL OR c.publisher.id = :publisherId) AND (:customerId IS NULL OR c.customerId = :customerId) "
			+ "AND o.orderType = :orderType GROUP BY o.orderId")
	Page<Order> findAllOrderOfGiveType(@Param("publisherId") Integer publisherId, @Param("customerId") Integer customerId, @Param("orderType") String orderType, Pageable page);

	
	@Query("SELECT o FROM Order o JOIN o.keyOrderInformation keyInfo JOIN o.customerId ci WHERE (ci.publisher.id = :pubId OR :pubId IS NULL) AND "
			+ "(:orderStartDate IS NULL OR DATE(keyInfo.orderDate) >= :orderStartDate) AND "
			+ "(:orderEndDate IS NULL OR DATE(keyInfo.orderDate) <= :orderEndDate) AND "
			+ "(:orderType IS NULL OR o.orderType LIKE '%'||:orderType||'%')")
	public Page<Order> findAllSalesListByOrderViewReport(
			@Param("pubId") Integer pubId, 
			@Param("orderStartDate") Date orderStartDate,
			@Param("orderEndDate") Date orderEndDate,
			@Param("orderType") String orderType, Pageable page);
	
	
//	@Query(value="SELECT op.*, oi.*, c.*\n"
//			+ "FROM order_parent op \n"
//			+ "JOIN order_items oi ON op.order_items_id = oi.id \n"
//			+ "JOIN customer c ON op.customer_id = c.id \n"
//			+ "WHERE DATE(:userDate) BETWEEN oi.valid_from AND oi.valid_to \n"
//			+ "  AND order_status IN ('order placed') \n"
//			+ "  AND c.pub_id = :pubId;\n"
//			+ "",nativeQuery = true)
//	public List<Order> getOrderList(@Param("pubId") Integer pubId,@Param("userDate") Date userDate);
//	
	@Query(value="SELECT op.*,oi.* FROM order_parent op\n"
			+ "JOIN order_items oi ON op.order_items_id=oi.id \n"
			+ "JOIN customer c ON op.customer_id=c.id \n"
			+ "WHERE  DATE(:userDate) BETWEEN valid_from AND valid_to AND order_status IN ('order placed','active/shipping')\n"
			+ "AND oi.liability_issue>0 AND c.pub_id =:pubId", nativeQuery = true)
public List<Order> getOrderList(@Param("pubId") Integer pubId, @Param("userDate") Date userDate);

	
	@Query("SELECT o FROM Order o JOIN o.customerId cus WHERE (:pubId IS NULL OR cus.publisher.id = :pubId) AND "
			+ "(:customerId IS NULL OR o.customerId.customerId = :customerId) AND (:orderId IS NULL OR o.orderId != :orderId) AND (o.orderStatus NOT IN :orderStatusToExclude) AND o.oldOrderId = :oldOrderId AND o.isRenewed IS FALSE")
	Page<Order> findAllNonRenewedOrder(@Param("pubId") Integer pubId, @Param("customerId") Integer customerId, @Param("orderId") Integer orderId, 
			@Param("orderStatusToExclude") List<String> orderStatusToExclude, @Param("oldOrderId") Integer oldOrderId, Pageable page);


	@Query("SELECT o FROM Order o JOIN o.customerId cus JOIN o.paymentBreakdown pay WHERE (:pubId IS NULL OR cus.publisher.id = :pubId) AND (:customerId IS NULL OR o.customerId.customerId = :customerId) "
			+ "AND (:orderId IS NULL OR o.orderId != :orderId) AND pay.paymentStatus NOT IN (:statusList) AND o.orderStatus NOT IN (:orderStatusList) AND o.orderType IN (:orderTypes) GROUP BY o.orderId")
	public Page<Order> findAllOrderForPayAnotherOrder(@Param("pubId") Integer pubId, @Param("customerId") Integer customerId, 
			@Param("orderId") Integer orderId, @Param("statusList") List<String> statusList, @Param("orderStatusList") List<String> orderStatusList,
			@Param("orderTypes") List<String> orderTypes, 
			Pageable page);
	
	public Long countByCustomerIdPublisherId(Integer publisherId) throws Exception;


	@Query(value="SELECT  op.order_id,op.order_type  FROM order_parent op JOIN order_items oi ON op.order_items_id=oi.id JOIN customer c ON op.customer_id=c.id  WHERE c.pub_id =:pubId", nativeQuery = true)
	public List<String[]> getOrderTypesCountForPublisher(@Param("pubId") Integer pubId);


	@Query(value="SELECT op.order_id,op.created_at  FROM order_parent op JOIN customer c ON op.customer_id=c.id  WHERE c.pub_id =:pubId", nativeQuery = true)
	 	public List<String[]> getOrdersPerMonthForPublisher(Integer pubId);

}
















