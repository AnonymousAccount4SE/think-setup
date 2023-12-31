package com.mps.think.setup.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.OutputValue;

@Repository
public interface OutputValueRepo extends JpaRepository<OutputValue, Integer>{
	
	public List<OutputValue> findByPubIdId(Integer pubId);

}
