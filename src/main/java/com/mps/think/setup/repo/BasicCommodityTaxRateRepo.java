package com.mps.think.setup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.BasicCommodityTaxRate;

@Repository
public interface BasicCommodityTaxRateRepo extends JpaRepository<BasicCommodityTaxRate, Integer> {

}
