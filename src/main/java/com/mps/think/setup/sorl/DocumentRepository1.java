package com.mps.think.setup.sorl;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface DocumentRepository1 extends SolrCrudRepository<Document1, String> {
	List<Document1> findByDocTitleEndsWith(String title); // find documents whose docTitle ends with specified string

	List<Document1> findByDocTitleStartsWith(String title); // find documents whose docTitle starts with specified string

	List<Document1> findByDocTypeEndsWith(String type); // find documents whose docType ends with specified string

	List<Document1> findByDocTypeStartsWith(String type);// find documents whose docType start with specified string
   
}
