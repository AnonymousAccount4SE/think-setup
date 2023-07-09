package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.OrderAddressMapping;

@Repository
public interface OrderAddressMappingRepo extends JpaRepository<OrderAddressMapping, Integer> {

	List<OrderAddressMapping> findByAddressAddressId(Integer addressId);
	
}
