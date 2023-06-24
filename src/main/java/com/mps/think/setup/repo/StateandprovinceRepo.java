package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.Stateandprovince;

@Repository
public interface StateandprovinceRepo extends JpaRepository<Stateandprovince, Integer>{
	
	List<Stateandprovince> findByPubIdId(Integer pubId);
	
//	List<Stateandprovince> findByCountryidId(Integer id);

}
