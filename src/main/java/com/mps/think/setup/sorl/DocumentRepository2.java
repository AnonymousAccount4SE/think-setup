package com.mps.think.setup.sorl;


import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;



public interface DocumentRepository2 extends SolrCrudRepository<Document2, String> {
	List<Document2> findByDocTitleEndsWith(String title); // find documents whose docTitle ends with specified string

	List<Document2> findByDocTitleStartsWith(String title); // find documents whose docTitle starts with specified string

	List<Document2> findByDocTypeEndsWith(String type); // find documents whose docType ends with specified string

	List<Document2> findByDocTypeStartsWith(String type);// find documents whose docType start with specified string
   
}
