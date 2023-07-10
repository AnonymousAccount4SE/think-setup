package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.repo.PublisherRepo;
import com.mps.think.setup.service.PublisherSerivce;
import com.mps.think.setup.vo.PublisherVO;
@Service
public class PublisherSerivceImpl implements PublisherSerivce {

	@Autowired 
	PublisherRepo publisherRepo;
	
	@Autowired
	ObjectMapper mapper;
	
	@Override
	public List<Publisher> findAllPublisher() {
		List<Publisher> pubList = publisherRepo.findAll();
		if (pubList.isEmpty()) {
			throw new NotFoundException("No Publisher present, please add Publisher!");
		}
		return pubList;
	}

	@Override
	public PublisherVO savePublisher(PublisherVO publiser) {
//		Publisher data = new Publisher();
//		data.setName(publiser.getName());
//		data.setAbbreviation(publiser.getAbbreviation());
//		data.setAddress1(publiser.getAddress1());
//		data.setAddress2(publiser.getAddress2());
//		data.setCity(publiser.getCity());
//		data.setState(publiser.getState());
//		data.setCountry(publiser.getCountry());
//		data.setIsdCode(publiser.getIsdCode());
//		data.setZipCode(publiser.getZipCode());
//		data.setPrimaryPhone(publiser.getPrimaryPhone());
//		data.setSecondary_Phone(publiser.getSecondary_Phone());
//		data.setLogoUrl(publiser.getLogoUrl());
//		data.setWebsite(publiser.getWebsite());
//		publisherRepo.saveAndFlush(data);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Publisher pub = mapper.convertValue(publiser, Publisher.class);
		publisherRepo.saveAndFlush(pub);
		return publiser;
	}

	@Override
	public PublisherVO updatePublisher(PublisherVO publiser) {
//		Publisher data = new Publisher();
//		data.setName(publiser.getName());
//		data.setAbbreviation(publiser.getAbbreviation());
//		data.setAddress1(publiser.getAddress1());
//		data.setAddress2(publiser.getAddress2());
//		data.setCity(publiser.getCity());
//		data.setState(publiser.getState());
//		data.setCountry(publiser.getCountry());
//		data.setIsdCode(publiser.getIsdCode());
//		data.setZipCode(publiser.getZipCode());
//		data.setPrimaryPhone(publiser.getPrimaryPhone());
//		data.setSecondary_Phone(publiser.getSecondary_Phone());
//		data.setLogoUrl(publiser.getLogoUrl());
//		data.setWebsite(publiser.getWebsite());
//		publisherRepo.saveAndFlush(data);
		mapper.configure(Feature.IGNORE_UNKNOWN, false);
		Publisher pub = mapper.convertValue(publiser, Publisher.class);
		publisherRepo.saveAndFlush(pub);
		return publiser;

	}

	@Override
	public Publisher findbyPublisherId(Integer id) {
		Optional<Publisher> cs =publisherRepo.findById(id);
		if(!cs.isPresent()) {
			throw new NotFoundException("Publisher Id : "+id+" does not exist!");
		}
		return cs.get();
	}

	@Override
	public List<Publisher> getAllPublisher() {
		return publisherRepo.findAll();
	}

}
