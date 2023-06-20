package com.mps.think.setup.sorl;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface DocumentRepository extends SolrCrudRepository<Document, String> {
	List<Document> findByDocTitleEndsWith(String title); // find documents whose docTitle ends with specified string

	List<Document> findByDocTitleStartsWith(String title); // find documents whose docTitle starts with specified string

	List<Document> findByDocTypeEndsWith(String type); // find documents whose docType ends with specified string

	List<Document> findByDocTypeStartsWith(String type);// find documents whose docType start with specified string
   
  //  List<Document> findByIdContaining(String id);


}