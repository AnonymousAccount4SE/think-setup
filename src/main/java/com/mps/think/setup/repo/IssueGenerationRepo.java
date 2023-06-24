package com.mps.think.setup.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.IssueGeneration;
@Repository
public interface IssueGenerationRepo extends JpaRepository<IssueGeneration, Integer> {

	@Query(value="SELECT MAX(seq_of_issue) FROM issue_generation where order_class_id=:ocId",nativeQuery = true)
	int findMaxSeqOfIssue(@Param("ocId") Integer ocId);
	
	List<IssueGeneration> findByOrderClassIdPubIdId(Integer pubId);
	
	@Query(value = "SELECT ig.*\n"
			+ "FROM issue_generation ig\n"
			+ "JOIN oc o ON ig.order_class_id = o.oc_id\n"
			+ "WHERE o.pub_id =:pubId AND ig.order_class_id=:ocId AND ig.closed IS NULL ORDER BY ig.id LIMIT 1;",nativeQuery = true)
	IssueGeneration getcurrentissue(@Param("pubId") Integer pubId,@Param("ocId") Integer ocId);
	
	
	@Query(value="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'think_setup_new' AND TABLE_NAME = 'issue_generation';",nativeQuery = true)
	public List<String> findAllIssueColumn();
}
