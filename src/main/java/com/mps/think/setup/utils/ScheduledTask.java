package com.mps.think.setup.utils;

import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mps.think.setup.serviceImpl.SuspendOrderServiceImpl;
import com.mps.think.setup.sorl.SolrDocumentController;

@Component
public class ScheduledTask {
    
	@Autowired
	SuspendOrderServiceImpl suspendService;
	
	@Autowired
	SolrDocumentController solr;
	
    @Scheduled(cron = "0 0 1 * * *") // Cron expression for 1 am every day
    public void runTask() {
    	try {
    		suspendService.checkOrdersToContinue();
    		suspendService.checkOrdersToSuspend(null, null);			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    @Scheduled(cron = "0 05 00 * * *") // Cron expression for 1 am every day
    @org.springframework.transaction.annotation.Transactional
    public void runSolrTask() {
    	try {
    		solr.CustomerDetailsDocuments();
    		System.out.println("Customer Completed");
    		solr.OrderDocuments();
    		System.out.println("Order Completed");
    		solr.PaymentInformationDocuments();
    		System.out.println("Payment Information is Updated");
    		solr.MakePaymentDocuments();
    		System.out.println("payment Account information is Updated");

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
    
    
    
    

