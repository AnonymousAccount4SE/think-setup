package com.mps.think.setup.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.EffortRange;


@Repository
public interface EffortRangeRepo extends JpaRepository<EffortRange, Integer> {
	
	public List<EffortRange> findByAddRenewalId(Integer id);

}
