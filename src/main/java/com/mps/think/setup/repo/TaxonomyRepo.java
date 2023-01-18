package com.mps.think.setup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.Taxonomy;

@Repository
public interface TaxonomyRepo extends JpaRepository<Taxonomy,Integer> {
	
	public Taxonomy findTaxonomyById(Integer id);

}
