package com.mps.think.setup.sorl;


import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;



public interface DocumentRepository3 extends SolrCrudRepository<Document3, String> {
	List<Document3> findByDocTitleEndsWith(String title); // find documents whose docTitle ends with specified string

	List<Document3> findByDocTitleStartsWith(String title); // find documents whose docTitle starts with specified string

	List<Document3> findByDocTypeEndsWith(String type); // find documents whose docType ends with specified string

	List<Document3> findByDocTypeStartsWith(String type);// find documents whose docType start with specified string
   
}