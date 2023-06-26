package com.mps.think.setup.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.model.CommodityCodes;
import com.mps.think.setup.model.Jurisdictions;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.TaxRateCategory;
import com.mps.think.setup.model.TaxType;
import com.mps.think.setup.repo.CommodityCodesRepo;
import com.mps.think.setup.repo.JurisdictionsRepo;
import com.mps.think.setup.repo.TaxRateCategoryRepo;
import com.mps.think.setup.repo.TaxTypeRepo;
import com.mps.think.setup.service.BasicCommodityTaxRateService;
import com.mps.think.setup.service.BasicJurisdictionTaxRateService;
import com.mps.think.setup.service.CommodityCodesService;
import com.mps.think.setup.service.JurisdictionsService;
import com.mps.think.setup.service.PublisherSerivce;
import com.mps.think.setup.service.TaxRateCategoryService;
import com.mps.think.setup.service.TaxService;
import com.mps.think.setup.utils.ReadCSVDataAvalara;
import com.mps.think.setup.vo.BasicCommodityTaxRateVO;
import com.mps.think.setup.vo.BasicJurisdictionTaxRateVO;
import com.mps.think.setup.vo.CommodityCodesVO;
import com.mps.think.setup.vo.JurisdictionsVO;
import com.mps.think.setup.vo.PublisherVO;
import com.mps.think.setup.vo.TaxRateCSV;
import com.mps.think.setup.vo.TaxRateCategoryVO;
import com.mps.think.setup.vo.TaxTypeVO;

//import com.mps.think.setup.utils.StorageService;

@RestController
@CrossOrigin
public class FileUploadController {
	 @Value("${csv.movelocation}")
	    String movelocation;
	@Autowired
	ReadCSVDataAvalara ReadCSVDataAvalara;
	
	@Autowired
	CommodityCodesService ccService;
	
	@Autowired
	TaxService ttService;
	
	@Autowired
	JurisdictionsService jService;
	
	@Autowired
	TaxRateCategoryService trService;
	
	@Autowired
	PublisherSerivce publisherSerivce;
	
	@Autowired
	BasicJurisdictionTaxRateService basicJurisdictionTaxRateService;
	
	@Autowired
	CommodityCodesService commodityCodesService;
	
	@Autowired
	BasicCommodityTaxRateService basicCommodityTaxRateService;
	
	@PostMapping("/avalara/fileupload")
	public List<TaxRateCSV> handleFileUpload(@Valid @RequestParam("file") MultipartFile file, @RequestParam(required = false) Integer pubId) throws ParseException {

//		storageService.store(file);	
		List<TaxRateCSV> taxRateCSV = new ArrayList<TaxRateCSV>();
		System.out.println("message You successfully uploaded " + file.getOriginalFilename() + "!");
		File file1 = new File(movelocation+file.getOriginalFilename());
		try {
			file.transferTo(file1);
			taxRateCSV =ReadCSVDataAvalara.readDataLineByLine(file1.getAbsolutePath());
			Publisher publisher = publisherSerivce.findbyPublisherId(pubId);
			PublisherVO publisherVO = new PublisherVO();
			publisherVO.setId(pubId);
			BasicTaxRate basicTaxRate = new BasicTaxRate();
			for(TaxRateCSV taxCsv :taxRateCSV) {
				CommodityCodesVO cc = new CommodityCodesVO();
				cc.setPubId(publisher);
				cc.setCommodityCode(taxCsv.getCommodityCode());
				cc.setDescription(taxCsv.getCommodityDescription());
				ccService.saveCommodityCodes(cc);
				Date comEffectiveDate=new SimpleDateFormat("dd/MM/yyyy").parse(taxCsv.getEffectiveDateForCommodityRate());
				BasicCommodityTaxRateVO basicCommodityTaxRateVO = new BasicCommodityTaxRateVO();
				basicCommodityTaxRateVO.setCommodityCodes(cc);
				basicCommodityTaxRateVO.setBasicCommodityTaxRateId(basicTaxRate);
				basicCommodityTaxRateVO.setEffectiveDate(comEffectiveDate);
				basicCommodityTaxRateVO.setRateValue(taxCsv.getJurisdictionRate());
				basicCommodityTaxRateService.saveBasicCommodityTaxRateDetails(basicCommodityTaxRateVO);
				TaxTypeVO tt = new TaxTypeVO();
				tt.setTaxType(taxCsv.getTaxType());
				tt.setDescription(taxCsv.getTaxTypeDescription());
				tt.setPubId(publisherVO);
				ttService.saveTaxType(tt);
				
				JurisdictionsVO jj = new JurisdictionsVO();
				jj.setCountrycode(taxCsv.getCountryCode());
				jj.setStateCode(taxCsv.getStateCode());
				jj.setCity(taxCsv.getCity());
				jj.setCountry(taxCsv.getCountry());
				jj.setZipCode(taxCsv.getPostalCode());
				if(!taxCsv.getTaxComputeApi().contains("none")) {
					jj.setTaxCoumputation(false);
				}
				jj.setAddressValidation(taxCsv.getAddressValidationApi());
				Jurisdictions jurisdictions = jService.saveJurisdictions(jj);
				jj.setId(jurisdictions.getId());
				Date JudEffectiveDate=new SimpleDateFormat("dd/MM/yyyy").parse(taxCsv.getEffectiveDateForJurisdictionRate());  
				BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO = new BasicJurisdictionTaxRateVO();
				basicJurisdictionTaxRateVO.setBasicJurisdictionTaxRatedId(pubId);
				basicJurisdictionTaxRateVO.setJurisdictionsId(jj);
				basicJurisdictionTaxRateVO.setEffectiveDate(JudEffectiveDate);
				basicJurisdictionTaxRateVO.setRateValue(taxCsv.getJurisdictionRate());
				basicJurisdictionTaxRateService.savebasicJurisdictionTaxRate(basicJurisdictionTaxRateVO);
				
				TaxRateCategoryVO trc = new TaxRateCategoryVO();
				trc.setPubId(publisher);
				trc.setTaxRateCategory(taxCsv.getTaxRateCategory());
				trc.setDescription(taxCsv.getTaxTypeDescription());
				trService.saveTaxRateCategory(trc);	
			}
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return taxRateCSV;
	}

}
