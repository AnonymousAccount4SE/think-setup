package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.EditTrail;
import com.mps.think.setup.vo.EditTrailView;
@Repository
public interface EditTrailRepo extends JpaRepository<EditTrail, Integer>{
	
	List<EditTrail> findByPublisherId(Integer pubId);
	
	List<EditTrail> findByCustomerCustomerId(Integer custId);
	
	//e.baseAmount, ed.column_name
//	@Query("SELECT new com.mps.think.setup.vo.EditTrailView(e.creationDate, e.xActionName,e.edited,e.tableEnum,e.orderId,ed.beforeChange,ed.afterChange, ed.column_name) FROM EditTrail e JOIN e.editTrailDelta ed WHERE (:pubId IS NULL OR :pubId = e.publisher.id) AND (:customerId IS NULL OR :customerId=e.customer.customerId) AND (:orderId IS NULL OR :orderId=e.orderId)") 
//	Page<EditTrailView> findEditTrial(@Param("pubId") Integer pubId, @Param("customerId") Integer customerId, @Param("orderId") Integer orderId, Pageable page);
	
@Query("SELECT new com.mps.think.setup.vo.EditTrailView(e.creationDate, e.xActionName, e.edited, e.tableEnum,\r\n"
		+ "e.orderId, ed.beforeChange, ed.afterChange, ed.column_name)\r\n"
		+ "FROM EditTrail e\r\n"
		+ "JOIN e.editTrailDelta ed\r\n"
		+ "WHERE (:pubId IS NULL OR :pubId = e.publisher.id)\r\n"
		+ "  AND (:customerId IS NULL OR :customerId = e.customer.customerId)\r\n"
		+ "  AND e.tableEnum IN (:tableEnum)\r\n"
		+ "ORDER BY e.createdAt DESC")
Page<EditTrailView> findEditTrial(@Param("pubId") Integer pubId, @Param("customerId") Integer customerId,@Param("tableEnum") List<String> tableEnum, Pageable page);
}
