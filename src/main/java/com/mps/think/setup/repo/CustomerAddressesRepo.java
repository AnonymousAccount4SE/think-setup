package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.CustomerAddresses;

@Repository
public interface CustomerAddressesRepo extends JpaRepository<CustomerAddresses, Integer>{

	@Query(value = "SELECT MIN(id) FROM customer_addresses_mapping WHERE customer_id = :customerId GROUP BY address_id", nativeQuery = true)
	public List<Integer> getAllUniqueCustomerAddressPairsForCustomer(@Param("customerId") Integer customerId);
	
	public List<CustomerAddresses> findByCustomerCustomerId(Integer customerId);
	
	public List<CustomerAddresses> findAllByAddressAddressIdIn(List<Integer> addressIds);
	
	@Query(value = "DELETE FROM customer_addresses_mapping WHERE id = :id", nativeQuery = true)
	void deleteCustomerAddressRow(@Param("id") Integer id);
	
	List<CustomerAddresses> findByAddressAddressId(Integer addressId);
	
	@Query("SELECT ca FROM CustomerAddresses ca WHERE ca.customer.customerId = :customerId AND ca.address.addressId = :addressId")
	List<CustomerAddresses> findAddressCustomerPair(@Param("addressId") Integer addressId, @Param("customerId") Integer customerId);
	
}
