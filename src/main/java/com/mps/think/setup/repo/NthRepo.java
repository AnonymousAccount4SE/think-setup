package com.mps.think.setup.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.Nth;


@Repository
public interface NthRepo extends JpaRepository<Nth, Integer>{
	
	public List<Nth> findByPubIdId(Integer pubId);

}
