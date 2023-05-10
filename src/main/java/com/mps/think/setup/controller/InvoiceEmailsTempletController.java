package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.InvoiceEmailsTempletService;

@RestController
@CrossOrigin
public class InvoiceEmailsTempletController {
	
	@Autowired
	InvoiceEmailsTempletService invoiceEmailsTempletService;
	
	@PostMapping("/getAllInvoiceEmailsTamplet")
	public ResponseEntity<?> getAllInvoiceEmailsTamplet(@RequestBody Integer pubId){
		return ResponseEntity.ok(invoiceEmailsTempletService.findByInvoiceEmailsTampletId(pubId));
	}

}
