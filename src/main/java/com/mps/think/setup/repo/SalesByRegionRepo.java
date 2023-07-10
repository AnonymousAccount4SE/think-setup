package com.mps.think.setup.repo;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.vo.SalesByRegionVO;
@Repository
public interface SalesByRegionRepo extends JpaRepository<SalesByRegionVO, Integer>{

	  
	 @Query(value="SELECT op.order_id,ocat.order_category, pb.base_amount, pb.currency, sdf.category AS subscription_category, oc.order_class, rl.rlist AS r_list,c.id as cust_id,c.fname AS first_name,c.lname AS last_name,ad.address_line1 AS first_address,ad.address_line2 AS second_address,c.department,ad.city,ad.country,ad.zip_code, " + 
	 		"	 oi.valid_from AS start_date,oi.valid_to AS end_date,oi.effective_date AS order_date,pb.net_amount, oi.quantity_ordered,pt.payment_type  " + 
	 		"	 FROM order_parent op LEFT JOIN customer c ON op.customer_id = c.id LEFT JOIN oc ON oc.oc_id=op.order_class_id" + 
 	 		"   LEFT JOIN order_address_mapping oam ON oam.order_id=op.order_id" +
 	 		"	LEFT JOIN addresses ad ON ad.address_id=oam.address " + 
 	 		"	LEFT JOIN payment_breakdown pb ON pb.id = op.payment_breakdown_id " + 
 	 		"   LEFT JOIN payment_type pt ON pt.publisher_id = c.pub_id " +
 	 		"	LEFT JOIN order_items oi ON oi.id = op.order_items_id " + 
	 		"	LEFT JOIN subscription_def_tbl sdf ON sdf.id = oi.subscription_id " + 
	 		"	LEFT JOIN order_categories ocat ON ocat.pub_id = c.pub_id " + 
	 		"	LEFT JOIN volume_group vg ON vg.pub_id = c.pub_id " + 
	 		"	LEFT JOIN region_list rl ON rl.pub_id=c.pub_Id where  (:pubId IS NULL OR c.pub_id = :pubId) AND oam.shipping_address=TRUE AND "+
	 		"    (:paymentStartDate IS NULL OR DATE(op.created_at) >= :paymentStartDate) AND " + 
	 		 " (:paymentEndDate IS NULL OR DATE(op.created_at) <= :paymentEndDate) AND (:volYear IS NULL OR vg.volume=:volYear) AND (:orderClass IS NULL OR oc.order_class) "
	 		 + "AND (:region IS NULL OR rl.rlist=:region) GROUP BY op.order_id",countQuery="SELECT op.order_id,ocat.order_category, pb.base_amount, pb.currency, sdf.category AS subscription_category, oc.order_class, rl.rlist AS r_list,c.id as cust_id,c.fname AS first_name,c.lname AS last_name,ad.address_line1 AS first_address,ad.address_line2 AS second_address,c.department,ad.city,ad.country,ad.zip_code, " + 
	 		 		"	 			 oi.valid_from AS start_date,oi.valid_to AS end_date,oi.effective_date AS order_date,pb.net_amount,oi.quantity_ordered,pt.payment_type   " + 
	 		 		"	 			 FROM order_parent op LEFT JOIN customer c ON op.customer_id = c.id LEFT JOIN oc ON oc.oc_id=op.order_class_id " + 
 	 		 		"   LEFT JOIN order_address_mapping oam ON oam.order_id=op.order_id" +
 	 		 		"	 			LEFT JOIN addresses ad ON ad.address_id=oam.address " + 
	 		 		" 	 			LEFT JOIN payment_breakdown pb ON pb.id = op.payment_breakdown_id " + 
	 		 		"   LEFT JOIN payment_type pt ON pt.publisher_id = c.pub_id " +
 	 		 		"	 			LEFT JOIN order_items oi ON oi.id = op.order_items_id " + 
	 		 		"	 			LEFT JOIN subscription_def_tbl sdf ON sdf.id = oi.subscription_id " + 
	 		 		"	 			LEFT JOIN order_categories ocat ON ocat.pub_id = c.pub_id " + 
	 		 		"	 			LEFT JOIN volume_group vg ON vg.pub_id = c.pub_id " + 
	 		 		"	 			LEFT JOIN region_list rl ON rl.pub_id=c.pub_Id where  (:pubId IS NULL OR c.pub_id = :pubId) AND  oam.shipping_address=TRUE AND " + 
	 		 		"	 		    (:paymentStartDate IS NULL OR DATE(op.created_at) >= :paymentStartDate) AND  " + 
	 		 		"	 		  (:paymentEndDate IS NULL OR DATE(op.created_at) <= :paymentEndDate) AND (:volYear IS NULL OR vg.volume=:volYear) AND (:orderClass IS NULL OR oc.order_class) " + 
	 		 		"	 		 AND (:region IS NULL OR rl.rlist=:region) GROUP BY op.order_id", nativeQuery=true)
	Page<SalesByRegionVO> getAllSalesByRegionReport(Integer pubId, Integer volYear, String orderClass, String region,
			Date paymentStartDate, Date paymentEndDate,Pageable page);

	 
	/* @Query(value="SELECT  c.id,pb.currency AS baseCurrency,cc.cust_category,c.fname AS first_name,c.lname AS last_name,c.company,c.department,ad.address_line1 AS first_address, " + 
	 		"	 ad.address_line2 AS second_address,ad.state,ad.city,ad.zip_code " + 
	 		"	     FROM customer c  LEFT JOIN order_parent op  ON op.customer_id = c.id  " + 
	 		"	     LEFT JOIN customer_addresses_mapping cam ON cam.customer_id=c.id LEFT JOIN addresses ad ON ad.address_id=cam.address_id  " + 
	 		"	      LEFT JOIN payment_breakdown pb ON pb.id = op.payment_breakdown_id 	 " + 
	 		"	      LEFT JOIN volume_group vg ON vg.pub_id = c.pub_id 	 " + 
	 		"	            LEFT JOIN customer_category cc ON cc.pub_id = c.pub_id 	" + 
	 		"	     LEFT JOIN region_list rl ON rl.pub_id=c.pub_Id  where  (:pubId IS NULL OR c.pub_id = :pubId) AND AND (:customerType IS NULL OR cc.cust_category = :customerType) AND (:country IS NULL OR ad.country = :country) " + 
	 		"	 	 (:paymentStartDate IS NULL OR DATE(op.created_at) >= :paymentStartDate) AND   " + 
	 		"	 	 (:paymentEndDate IS NULL OR DATE(op.created_at) <= :paymentEndDate) AND (:volYear IS NULL OR vg.volume=:volYear) GROUP BY c.id", countQuery="SELECT  *  " + 
 	 				"	 		 	     FROM customer c  LEFT JOIN order_parent op  ON op.customer_id = c.id "   + 
	 				"	 		 	     LEFT JOIN customer_addresses_mapping cam ON cam.customer_id=c.id LEFT JOIN addresses ad ON ad.address_id=cam.address_id  "  + 
	 				"	 		       LEFT JOIN payment_breakdown pb ON pb.id = op.payment_breakdown_id "	   + 
	 				"	 	       LEFT JOIN volume_group vg ON vg.pub_id = c.pub_id 	"   +
	 		 		"	            LEFT JOIN customer_category cc ON cc.pub_id = c.pub_id 	" + 
 	 				"	 		 	     LEFT JOIN region_list rl ON rl.pub_id=c.pub_Id  where  (:pubId IS NULL OR c.pub_id = :pubId) AND (:customerType IS NULL OR cc.cust_category = :customerType) AND (:country IS NULL OR ad.country = :country)  AND "  + 
	 				"	 		  	 (:paymentStartDate IS NULL OR DATE(op.created_at) >= :paymentStartDate) AND   "  + 
	 				"	 		 	 	 (:paymentEndDate IS NULL OR DATE(op.created_at) <= :paymentEndDate) AND (:volYear IS NULL OR vg.volume=:volYear) GROUP BY c.id", nativeQuery=true)
	Page<Object[]> getAllTopNCustomersReport(Integer pubId, Integer volYear, String customerType, String country,String region, Date paymentStartDate, Date paymentEndDate,
			PageRequest of);
*/
	
	
	
}
