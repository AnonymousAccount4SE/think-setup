package com.mps.think.setup.sorl;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.http.ResponseEntity;
@SolrDocument(solrCoreName = "PaymentsInfo")
//@SolrDocument(solrCoreName = "Payments")

public class Document3 {
	
	@Id
	  @Field
	  private String id;
	  @Field
	  private String docType;
	 
	  
	  @Field
	  private String docTitle;
	  @Field
	  private Object thinkObject;
	  public Document3() {
	  }
	  
	  
	  public Document3(String id, String docType, String docTitle){
	    this.id = id;
	    this.docTitle = docTitle;
	    this.docType = docType;
	  }
	  
	  public Document3(String id, String docType, String docTitle,  Object thinkObject){
		    this.id = id;
		    this.docTitle = docTitle;
		    this.docType = docType;
		    this.thinkObject = thinkObject;
		  }
	  
	  public void setId(String id){
	    this.id = id;
	  }
	  
	  public String getId(){
	    return this.id;
	  }
	  
	  @Override
	public String toString() {
		return "Document [id=" + id + ", docType=" + docType + ", docTitle=" + docTitle + ", thinkObject=" + thinkObject
				+ "]";
	}


	public String getDocType() {
	    return docType;
	  }
	  public void setDocType(String docType) {
	    this.docType = docType;
	  }
	  public String getDocTitle() {
	    return docTitle;
	  }
	  public void setDocTitle(String docTitle) {
	    this.docTitle = docTitle;
	  }


	public void setThinkObject(Object thinkObject) {
		this.thinkObject = thinkObject;
	}
	}




