package com.mps.think.setup.repo;

import java.util.List;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
  import com.mps.think.setup.model.ExtractFilter;
 

@Repository
public interface ExtractFilterRepo extends JpaRepository<ExtractFilter, Integer>{

	 @Query(value="SELECT column_name FROM information_schema.columns WHERE table_name = :tableName", nativeQuery = true)
  	 List<String> getAllColumnsOfTables( @Param("tableName") String tableName); 
 
}
