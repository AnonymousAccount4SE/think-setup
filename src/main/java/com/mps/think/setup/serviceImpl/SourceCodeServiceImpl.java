package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.SourceCode;
import com.mps.think.setup.model.SourceCodeAndValuesMapping;
import com.mps.think.setup.repo.SourceCodeRepo;
import com.mps.think.setup.service.SourceCodeService;
import com.mps.think.setup.vo.SourceCodeVO;

@Service
public class SourceCodeServiceImpl implements SourceCodeService {
	
	@Autowired
	SourceCodeRepo sourceCodeRepo;

	@Override
	public List<SourceCode> findAllSourceCode() {
		List<SourceCode> scList = sourceCodeRepo.findAll();
		if (scList.isEmpty()) {
			throw new NotFoundException("No Source Code present, please add Source Code!");
		}
		return scList;
	}

	@Override
	public SourceCodeVO saveSourceCode(SourceCodeVO sourceCode) {
		
		ObjectMapper mapper = new ObjectMapper();
		SourceCode newSourceCode = mapper.convertValue(sourceCode, SourceCode.class);
		
		if(sourceCode.getDiscountCardKeyInfo()==null || sourceCode.getDiscountCardKeyInfo().getId()==0){
			newSourceCode.setDiscountCardKeyInfo(null);
			}
		if(sourceCode.getRateCards()==null || sourceCode.getRateCards().getRcId()==0){
			newSourceCode.setRateCards(null);
		}
		if(sourceCode.getRenewalCard()==null || sourceCode.getRenewalCard().getId()==0){
			newSourceCode.setRenewalCard(null);
		}
		if (sourceCode.getShippingPriceList()==null || sourceCode.getShippingPriceList().getId()==0) {
			newSourceCode.setShippingPriceList(null);
		}
		if(sourceCode.getSourceCodeFormat()==null || sourceCode.getSourceCodeFormat().getId()==0) {
			newSourceCode.setSourceCodeFormat(null);
		}
		sourceCodeRepo.saveAndFlush(newSourceCode);
		
		return sourceCode;
	}

	@Override
	public SourceCode findbySourceCodeId(Integer sourceCodeId) {
		 Optional<SourceCode> cc = sourceCodeRepo.findById(sourceCodeId);
			if(!cc.isPresent()) {
				throw new NotFoundException("Source Code Id : "+ sourceCodeId +" does not exist!");
			}
			return cc.get();
	}

	@Override
	public SourceCodeVO updateSourceCode(SourceCodeVO sourceCode) {
		ObjectMapper mapper = new ObjectMapper();
		SourceCode sourceCodeToUpdate = mapper.convertValue(sourceCode, SourceCode.class);
		
		if(sourceCode.getDiscountCardKeyInfo()==null || sourceCode.getDiscountCardKeyInfo().getId()==0){
			sourceCodeToUpdate.setDiscountCardKeyInfo(null);
			}
		if(sourceCode.getRateCards()==null || sourceCode.getRateCards().getRcId()==0){
			sourceCodeToUpdate.setRateCards(null);
		}
		if(sourceCode.getRenewalCard()==null || sourceCode.getRenewalCard().getId()==0){
			sourceCodeToUpdate.setRenewalCard(null);
		}
		if (sourceCode.getShippingPriceList()==null || sourceCode.getShippingPriceList().getId()==0) {
			sourceCodeToUpdate.setShippingPriceList(null);
		}
		if(sourceCode.getSourceCodeFormat()==null || sourceCode.getSourceCodeFormat().getId()==0) {
			sourceCodeToUpdate.setSourceCodeFormat(null);
		}
		sourceCodeRepo.saveAndFlush(sourceCodeToUpdate);
		return sourceCode;
	}

	@Override
	public SourceCode deleteSourceCodeById(Integer sourceCodeId) {
		SourceCode delete = findbySourceCodeId(sourceCodeId);
		sourceCodeRepo.delete(delete);
		return delete;
	}

	@Override
	public List<SourceCode> findAllSourceCodeByPublisherId(Integer pubId) {
		// TODO Auto-generated method stub
		return sourceCodeRepo.findByOcIdPubIdId(pubId);
	}

	@Override
	public List<SourceCode> getAllSourceCode() {
		return sourceCodeRepo.findAll();
	}

	@Override
	public List<SourceCodeAndValuesMapping> getAllSourceCodeAndValuesMapping() {
		// TODO Auto-generated method stub
		return null;
	}

}
