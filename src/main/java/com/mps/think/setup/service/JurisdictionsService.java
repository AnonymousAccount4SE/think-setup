package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.Jurisdictions;
import com.mps.think.setup.vo.JurisdictionsVO;

public interface JurisdictionsService {
	
	public List<Jurisdictions> findAllJurisdictions();

	public Jurisdictions saveJurisdictions(JurisdictionsVO jurisdictions);

	public Jurisdictions updateJurisdictions(JurisdictionsVO jurisdictions);

	public Jurisdictions findbyId(Integer id);
	
	public Jurisdictions findbyJurisdictionStateTaxContry(JurisdictionsVO jurisdictions);
	
	public Jurisdictions deleteJurisdictionsById(Integer id);
	
	List<Jurisdictions> findAllJurisdictionsForPublisher(Integer pubId);

	public List<Jurisdictions> getAllJurisdictions();
	
	public List<Jurisdictions> getTodayAndYesterdayRecords();

	public List<String> getAllcountrybyJurisdiction();

	public List<Jurisdictions> getAllStateByJurisdiction(String country);
}
