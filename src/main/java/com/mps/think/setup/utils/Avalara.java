package com.mps.think.setup.utils;
import java.math.BigDecimal;
    import net.avalara.avatax.rest.client.AvaTaxClient;
    import net.avalara.avatax.rest.client.TransactionBuilder;
    import net.avalara.avatax.rest.client.enums.AvaTaxEnvironment;
    import net.avalara.avatax.rest.client.enums.DocumentType;
    import net.avalara.avatax.rest.client.enums.TransactionAddressType;
    import net.avalara.avatax.rest.client.models.PingResultModel;
    import net.avalara.avatax.rest.client.models.TransactionModel;
    
    public class Avalara {
    	
    	public TransactionModel AvalaraTaxClient(String appName, String appVersion, String machineName, AvaTaxEnvironment environment) {
           
        //creates our AvaTaxClient
        AvaTaxClient client = new AvaTaxClient("Test", "1.0", "localhost", AvaTaxEnvironment.Production)
            .withSecurity("2000160678", "E7B6CB9A2FF870A3"); //replace with your username and password 
        
        try {
          //verify that we can ping successfully
          PingResultModel ping = client.ping();
          if(ping.getAuthenticated()) {
            System.out.print("Successfully created a client!");
          }
        } catch (Exception e) {}     
        //builds the Transaction and creates the TransactionModel
        TransactionModel transaction = null;
        try {
           transaction = new TransactionBuilder(client, "UAT", DocumentType.SalesInvoice, "922")
          .withAddress(TransactionAddressType.SingleLocation, "123 Main Street", null, null, "Irvine", "CA", "92615", "US")
          .withLine( new BigDecimal(100.0), new BigDecimal(1), "P0000000")
                .Create();
          System.out.print("transaction :	 "+ transaction);
        } catch (Exception e) {}
		return transaction;
		
        
      }
    
    }