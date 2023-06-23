package com.mps.think.setup.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Jurisdictions;
import com.mps.think.setup.repo.JurisdictionsRepo;
import com.mps.think.setup.service.JurisdictionsService;
import com.mps.think.setup.vo.JurisdictionsVO;

@Service
public class JurisdictionsServiceImpl implements JurisdictionsService {

	@Autowired
	JurisdictionsRepo jurisdictionsRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Jurisdictions> findAllJurisdictions() {
		List<Jurisdictions> jList = jurisdictionsRepo.findAll();
		if (jList.isEmpty()) {
			throw new NotFoundException("No Jurisdictions present, please add Jurisdictions!");
		}
		return jList;
	}

	@Override
	public Jurisdictions saveJurisdictions(JurisdictionsVO jurisdictions) {
		return jurisdictionsRepo.saveAndFlush(mapper.convertValue(jurisdictions, Jurisdictions.class));
	}

	@Override
	public Jurisdictions updateJurisdictions(JurisdictionsVO jurisdictions) {
		return jurisdictionsRepo.saveAndFlush(mapper.convertValue(jurisdictions, Jurisdictions.class));
	}

	@Override
	public Jurisdictions findbyId(Integer id) {
		Optional<Jurisdictions> jl = jurisdictionsRepo.findById(id);
		if (!jl.isPresent()) {
			throw new NotFoundException("Jurisdictions Id : " + id + " does not exist!");
		}
		return jl.get();
	}

	@Override
	public Jurisdictions deleteJurisdictionsById(Integer id) {
		Jurisdictions todelete = jurisdictionsRepo.findJurisdictionsById(id);
		jurisdictionsRepo.delete(todelete);
		return todelete;
	}

	@Override
	public List<Jurisdictions> findAllJurisdictionsForPublisher(Integer pubId) {
		return jurisdictionsRepo.findByPubIdId(pubId);
	}

	@Override
	public List<Jurisdictions> getAllJurisdictions() {
		return jurisdictionsRepo.findAll();
	}

	@Override
	public List<Jurisdictions> getTodayAndYesterdayRecords() {
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		return jurisdictionsRepo.findTodayAndYesterdayRecords(today, yesterday);
	}

	@Override
	public Jurisdictions findbyJurisdictionStateTaxContry(JurisdictionsVO jurisdictionsVo) {

		Jurisdictions jurisdictions = jurisdictionsRepo.findbyJurisdictionStateTaxContry(jurisdictionsVo.getCountry(),
				jurisdictionsVo.getStateCode(), jurisdictionsVo.getZipCode());
		return jurisdictions;
	}

	@Override
	public List<String> getAllcountrybyJurisdiction() {
		return jurisdictionsRepo.getAllcountrybyJurisdiction();
	}

	@Override
	public List<Jurisdictions> getAllStateByJurisdiction(String country) {
		return jurisdictionsRepo.getAllStateByJurisdiction(country);
	}

}
