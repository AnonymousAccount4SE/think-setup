package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.InstallmentPlan;
 import com.mps.think.setup.service.InstallmentPlanService;

 
@Repository
public interface InstallmentPlanRepo  extends JpaRepository<InstallmentPlan, Integer>{

 	 
}
