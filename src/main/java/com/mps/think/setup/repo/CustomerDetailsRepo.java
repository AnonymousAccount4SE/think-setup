package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.Addresses;
import com.mps.think.setup.model.CancelReasons;
import com.mps.think.setup.model.CustomerAddresses;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.OrderAddressMapping;
import com.mps.think.setup.vo.EnumModelVO;
import com.mps.think.setup.vo.EnumModelVO.CustomerStatus;

@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, Integer> {

	public CustomerDetails findBycustomerId(Integer customerId);

//	@Query("SELECT c From CustomerDetails c WHERE " 
//			+ "(c.fname LIKE '%'||:firstName||'%' OR :firstName IS NULL)"
//			+ "AND (c.lname LIKE '%'||:lastName||'%' OR :lastName IS NULL)")
//	public Page<CustomerDetails> getAllCustomerDetailsForSearch(@Param("firstName") String firstName,
//			@Param("lastName") String lastName, Pageable page);

//	@Query("SELECT cd FROM CustomerDetails cd JOIN cd.customerAddresses cda JOIN cda.address cadd WHERE "
//			+ "CONCAT(cadd.addressName, ' ', cadd.addressId, ' ', cadd.name, ' ', cadd.city, ' ', cadd.countryCode, ' ' ,cadd.addressType, ' ' ,cadd.addressLine1,' ', cadd.addressLine2, ' '"
//			+ ",cadd.state,' ',cadd.addressCategory, ' ',cadd.country, ' ', cadd.frequency, ' ', cadd.phone, ' '"
//			+ ", cadd.addressAuxJSON) LIKE '%'||:search||'%' OR "
//			+ "cadd.zipCode LIKE '%'||:search||'%' OR "
//			+ "cd.customerId LIKE '%'||:search||'%' OR "
//			+ "cd.fax LIKE '%'||:search||'%' OR "
//			+ "(cd.institutionalId LIKE '%'||:search||'%') OR "
//			+ "(cd.parentInstitutionalId LIKE '%'||:search||'%') OR "
//			+ "CONCAT(cd.fname, ' ', cd.lname, ' ', cd.company, ' ', cd.department, ' ', cd.email, ' ' ,cd.initialName, ' ',cd.suffix, ' ', cd.countryCode, ' ', cd.primaryPhone, ' ', cd.mobileNumber, ' ', cd.taxId, ' ', COALESCE(cd.secondaryEmail, ''), ' ', COALESCE(cd.secondaryPhone, ''), ' ',cd.listRental, ' ', cd.salesRepresentative, ' ', cd.creditStatus, ' ', cd.fax, ' ', COALESCE(cd.newOrderCommission, ''), ' ', COALESCE(cd.renewalCommission, ''), ' ',COALESCE(cd.paymentThreshold, ''), ' ',COALESCE(cd.custAuxFieldJSON, '')) LIKE '%'||:search||'%'"
//			+ "GROUP BY cd.customerId")
//	public Page<CustomerDetails> getAllCustomerDetailsForSearchSingle(@Param("search") String search, Pageable page);

	@Query("SELECT c FROM Order o LEFT JOIN o.keyOrderInformation keyInfo LEFT JOIN keyInfo.orderCode ocs LEFT JOIN ocs.orderCodes oc RIGHT JOIN o.customerId c LEFT JOIN "
			+ "c.customerAddresses ca JOIN ca.address a LEFT JOIN c.paymentThreshold pthres WHERE ((c.publisher.id = :pubId OR :pubId IS NULL) AND (:search IS NULL OR "
			+ "((a.addressLine1 LIKE '%'||:search||'%') OR (a.city LIKE '%'||:search||'%') OR (a.state LIKE '%'||:search||'%') "
			+ "OR (a.country LIKE '%'||:search||'%') OR (a.addressName LIKE '%'||:search||'%') OR (a.addressId LIKE '%'||:search||'%') "
			+ "OR (a.name LIKE '%'||:search||'%') OR (a.countryCode LIKE '%'||:search||'%') "
			+ "OR (a.addressType LIKE '%'||:search||'%') OR (a.addressLine2 LIKE '%'||:search||'%') OR (a.addressAuxJSON LIKE '%'||:search||'%') "
			+ "OR (a.zipCode LIKE '%'||:search||'%') OR (c.customerId LIKE '%'||:search||'%') OR (c.fax LIKE '%'||:search||'%') "
			+ "OR (c.institutionalId LIKE '%'||:search||'%') OR (c.parentInstitutionalId LIKE '%'||:search||'%') OR (c.fname LIKE '%'||:search||'%') "
			+ "OR (c.lname LIKE '%'||:search||'%') OR (c.company LIKE '%'||:search||'%') OR (c.department LIKE '%'||:search||'%') OR (c.email LIKE '%'||:search||'%') "
			+ "OR (c.initialName LIKE '%'||:search||'%') OR (c.suffix LIKE '%'||:search||'%') "
			+ "OR (c.countryCode LIKE '%'||:search||'%') OR (c.primaryPhone LIKE '%'||:search||'%') OR (c.mobileNumber LIKE '%'||:search||'%') "
			+ "OR (c.taxId LIKE '%'||:search||'%') OR (c.secondaryEmail LIKE '%'||:search||'%') OR (c.secondaryPhone LIKE '%'||:search||'%') "
			+ "OR (c.listRental LIKE '%'||:search||'%') OR (c.salesRepresentative LIKE '%'||:search||'%') "
			+ "OR (c.creditStatus LIKE '%'||:search||'%') OR (c.newOrderCommission LIKE '%'||:search||'%') OR (c.fax LIKE '%'||:search||'%') "
			+ "OR (c.renewalCommission LIKE '%'||:search||'%') OR (pthres.paymentThresholdCode LIKE '%'||:search||'%') "
			+ "OR (c.custAuxFieldJSON LIKE '%'||:search||'%') "
			+ "OR (oc.orderCode LIKE '%'||:search||'%') OR (o.orderId LIKE '%'||:search||'%') OR (keyInfo.agent LIKE '%'||:search||'%') "
			+ "OR (keyInfo.agentReferenceNum LIKE '%'||:search||'%')))) "
			+ "GROUP BY c.customerId")
	public Page<CustomerDetails> getAllCustomerDetailsForSearchSingle(@Param("pubId") Integer pubId,
			@Param("search") String search, Pageable page);

//	@Query(value="SELECT * FROM customer where pub_id=:pubId",nativeQuery = true)
//	public Page<CustomerDetails> findAllCustomerByPubId(@Param("pubId") Integer pubId, Sort sort);
	
	@Query(value="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'think_setup_new' AND TABLE_NAME = 'customer';",nativeQuery = true)
	public List<String> findAllColumn();

	Page<CustomerDetails> findByPublisherId(Integer pubId, Pageable page);
	
	List<CustomerDetails> findByPublisherId(Integer pubId);

	@Query("SELECT COUNT(c) FROM CustomerDetails c where c.publisher.id = ?1")
	Integer countCustomersInPublisher(Integer pubId);

	@Query("SELECT oam FROM Order o JOIN o.customerId c JOIN o.orderAddresses oam JOIN oam.address a WHERE c.customerId = :customerId GROUP BY a.addressId "
			+ "ORDER BY o.orderId DESC")
	Page<OrderAddressMapping> findAllRecentAddressOfCustomerBasedOnOrder(@Param("customerId") Integer customerId, Pageable page);
	
	// this one is to show the other customer addresses while placing the order...
	@Query("SELECT c FROM CustomerDetails c WHERE (c.publisher.id = :publisherId OR :publisherId IS NULL) AND c.customerId != :customerId")
	Page<CustomerDetails> findOtherCustomer(@Param("publisherId") Integer publisherId, @Param("customerId") Integer customerId, Pageable page);

//	   @Query("SELECT c FROM CustomerDetails c WHERE " +
//	            "(LOWER(c.agencyname) LIKE LOWER(CONCAT('%', :agencyName, '%')) OR :agencyName IS NULL)")
//		@Query("SELECT c FROM CustomerDetails c JOIN c.customerCategory cc WHERE cc.custCategory LIKE '%'||'Agents'||'%' AND "
//				+ "c.publisher = :publisher AND c.agencyname LIKE '%'||:agencyName||'%'")
	
//	@Query("SELECT c FROM CustomerDetails c JOIN c.customerCategory cc WHERE c.publisher.id = :publisher AND cc.thinkCategory = 'Agency' AND cc.custCategory LIKE '%'||:agencyName||'%'")
//	Page<CustomerDetails> getAllCustomerAgentForSearch(@Param("publisher") Integer publisher,@Param("agencyName") String agencyName, Pageable pageable);
//======================================================================================================================================================
	@Query("SELECT c.agencyname FROM CustomerDetails c WHERE c.publisher.id = :pubId AND " +
            "(LOWER(c.agencyname) LIKE LOWER(CONCAT('%', :agencyName, '%')) OR :agencyName IS NULL)")
List<String> getAllCustomerAgentForSearch(@Param("pubId") Integer pubId, @Param("agencyName") String agencyName);
//======================================================================================================================================================
	
//	@Query("SELECT ca.customer from CustomerAddresses ca WHERE ca.customer.customerId = :customerId AND ca.address.addressId = :addressId")
//	List<CustomerDetails> getCustomerDetailsIfPassedCustomerHoldTheAddress(@Param("customerId") Integer customerId, @Param("addressId") Integer addressId);
	
	@Query(value = "select count(*) from customer_addresses_mapping cam where cam.customer_id = :customerId and cam.address_id = :addressId", nativeQuery = true)
	Integer checkGivenAddressIsOfCustomer(@Param("customerId") Integer customerId, @Param("addressId") Integer addressId);
	
	@Query(value = "select cam.customer_id from customer_addresses_mapping cam where cam.address_id = :addressId", nativeQuery = true)
	List<Integer> findCustomerNameFromAddressId(@Param("addressId") Integer addressId);
	
	@Query("SELECT c FROM CustomerDetails c JOIN c.customerAddresses cam JOIN cam.address a WHERE "
			+ "(c.publisher.id = :pubId OR :pubId IS NULL) AND (c.customerId = :customerId OR :customerId IS NULL) AND (c.fname LIKE '%'||:fname||'%' OR :fname IS NULL) AND "
			+ "(c.lname LIKE '%'||:lname||'%' OR :lname IS NULL) AND (c.initialName LIKE '%'||:initialName||'%' OR :initialName IS NULL) AND "
			+ "(c.email LIKE '%'||:email||'%' OR :email IS NULL) AND (c.company LIKE '%'||:company||'%' OR :company IS NULL) AND "
			+ "(c.department LIKE '%'||:department||'%' OR :department IS NULL) AND (a.state LIKE '%'||:state||'%' OR :state IS NULL) AND "
			+ "(a.country LIKE '%'||:country||'%' OR :country IS NULL) AND (a.city LIKE '%'||:city||'%' OR :city IS NULL) AND " 
			+ "(a.zipCode LIKE '%'||:zipCode||'%' OR :zipCode IS NULL) GROUP BY c.customerId")
	Page<CustomerDetails>findCustomerSearchReport(@Param("pubId") Integer pubId, @Param("customerId")Integer customerId, @Param("fname") String fname, @Param("lname") String lname,
			@Param("initialName") String initialName, @Param("email") String email, @Param("company") String company, @Param("department") String department, @Param("country") String country, @Param("state") String state,
			@Param("city")	String city, @Param("zipCode") Integer zipCode, @Param("page") Pageable page);

	@Query("SELECT c FROM CustomerDetails c WHERE (:pubId IS NULL OR c.publisher.id = :pubId) AND (:status IS NULL OR :status = c.customerStatus)")
	public Page<CustomerDetails> findAllCustomerDetatilsReport(@Param("pubId") Integer pubId, 
			@Param("status") EnumModelVO.CustomerStatus status, Pageable page);

	
	@Query("SELECT c FROM CustomerDetails c WHERE (:pubId IS NULL OR c.publisher.id = :pubId) AND (:status IS NULL OR :status = c.customerStatus)")
	public Page<CustomerDetails> findAllAgencyDetailsReport(@Param("pubId") Integer pubId,
			@Param("status") EnumModelVO.CustomerStatus status, Pageable page);

	
//	name, fax, email, department, countrycode, company, mobile, agnecycode, agencyname, status, ordercodes
	@Query("SELECT c FROM CustomerDetails c WHERE (:pubId IS NULL OR c.publisher.id = :pubId) AND (:name IS NULL OR CONCAT(c.fname, ' ', c.lname) "
			+ "LIKE '%'||:name||'%') AND (:fax IS NULL OR c.fax LIKE '%'||:fax||'%') AND (:email IS NULL OR CONCAT(c.email, ' ', c.secondaryEmail) LIKE '%'||:email||'%') "
			+ "AND (:department IS NULL OR c.department LIKE '%'||:department||'%') AND (:countrycode IS NULL OR c.countryCode LIKE '%'||:countrycode||'%') "
			+ "AND (:company IS NULL OR c.company LIKE '%'||:company||'%') AND (:mobile IS NULL OR CONCAT(c.mobileNumber, ' ', c.primaryPhone, ' ', c.secondaryPhone) "
			+ "LIKE '%'||:mobile||'%') AND (:agencycode IS NULL OR c.agencycode LIKE '%'||:agencycode||'%') AND (:agencyname IS NULL OR c.agencyname LIKE '%'||:agencyname||'%') "
			+ "AND (:status IS NULL OR c.customerStatus LIKE '%'||:status||'%') GROUP BY c.customerId")
	Page<CustomerDetails> searchCustomerByKeys(@Param("pubId") Integer pubId, @Param("name") String name, @Param("fax") String fax, @Param("email") String email, 
			@Param("department") String department, @Param("countrycode") String countrycode, @Param("company") String company,
			@Param("mobile") String mobile, @Param("agencycode") String agencycode, @Param("agencyname") String agencyname, @Param("status") String status, Pageable page);

}
