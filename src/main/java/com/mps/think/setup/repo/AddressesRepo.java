package com.mps.think.setup.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.Addresses;

@Repository
public interface AddressesRepo extends JpaRepository< Addresses ,Integer> {
	
	public Addresses findByaddressId(Integer addressId);
	
    @Query( value ="SELECT e FROM Addresses  WHERE e.created_at BETWEEN  :today  AND  =  :yesterday" ,nativeQuery = true)
    List<Addresses> findTodayAndYesterdayRecords(@Param("today") LocalDate today, @Param("yesterday") LocalDate yesterday);
    
	@Query(value="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'think_setup_new' AND TABLE_NAME = 'addresses';",nativeQuery = true)
	public List<String> findAllColumnforAddresses();

}
