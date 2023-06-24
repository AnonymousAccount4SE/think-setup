package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.IssueGeneration;
import com.mps.think.setup.model.IssueSettings;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.repo.IssueGenerationRepo;
import com.mps.think.setup.repo.IssueSettingsRepo;
import com.mps.think.setup.service.IssueGenerationService;
import com.mps.think.setup.utils.IntegerToRoman;
import com.mps.think.setup.utils.IssueGenerationUtils;
import com.mps.think.setup.vo.IssueGenerationVo;

@Service

public class IssueGenerationServiceImpl implements IssueGenerationService {

	@Autowired
	IssueGenerationRepo issueGenerationRepo;

	@Autowired
	IssueSettingsRepo issueSettingsRepo;

	@Override
	public List<IssueGeneration> findAllIssueGenerationVo() {
		return issueGenerationRepo.findAll();
	}

	@Override
	public IssueGenerationVo saveIssueGenerationVo(IssueGenerationVo issueGeneration) {
		int nub = issueGeneration.getNumberOfIssue();
		for (int i = 0; i < nub; i++) {

			IssueGeneration issue = new IssueGeneration();
			issue.setActive(issueGeneration.getActive());
			issue.setDiscountCard(issueGeneration.getDiscountCard());
			issue.setFrequencyOfGeneration(issueGeneration.getFrequencyOfGeneration());
			issue.setIssue_volume(issueGeneration.getIssue_volume());
			if (issueGeneration.getVolumeFormat().equals("Arebic")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + i + 1);
			}
			if (issueGeneration.getVolumeFormat().equals("Small Roman")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + IntegerToRoman.intToSmallRoman(i + 1));
			}
			if (issueGeneration.getVolumeFormat().equals("Large Roman")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + IntegerToRoman.intToRoman(i + 1));
			}
			if (issueGeneration.getVolumeFormat().equals("Lower Case Letter")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + IntegerToRoman.intToabcd(i + 1));
			}
			if (issueGeneration.getVolumeFormat().equals("Upper Case Letter")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + IntegerToRoman.intToABCD(i + 1));
			}
			// issueGeneration.getIssueFormat()

			issue.setIssueFormat(issueGeneration.getIssueFormat());
			// issue.setIssuesAppearonEvery(issueGeneration.getIssuesAppearonEvery());
			// , sepreated value
			// String monthDate= issueGeneration.getIssuesAppearonEvery();

			issue.setNumberOfIssue(issueGeneration.getNumberOfIssue());
			issue.setIssueDate(issueGeneration.getIssueDate());
			issue.setDateoftheMonthYear(issueGeneration.getDateoftheMonthYear());
			issue.setChangeDate(issueGeneration.getChangeDate());
			issue.setSeqOfIssue(issueGeneration.getSeqOfIssue());
			if (issueGeneration.getIssueFormat().equals("Arebic")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + i + 1);
			}
			if (issueGeneration.getIssueFormat().equals("Small Roman")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + IntegerToRoman.intToSmallRoman(i + 1));
			}
			if (issueGeneration.getIssueFormat().equals("Large Roman")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + IntegerToRoman.intToRoman(i + 1));
			}
			if (issueGeneration.getIssueFormat().equals("Lower Case Letter")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + IntegerToRoman.intToabcd(i + 1));
			}
			if (issueGeneration.getIssueFormat().equals("Upper Case Letter")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + IntegerToRoman.intToABCD(i + 1));
			}
			// OrderCodes id added
//			OrderCodes ocode = new OrderCodes();
//			ocode.setId(issueGeneration.getOderCodeVo().getId());
//			issue.setOderCode(ocode);
			/// oderclass id
			OrderClass oc = new OrderClass();
			oc.setOcId(issueGeneration.getOrderClassId().getOcId());
			issue.setOrderClassId(oc);
			issue.setOrderType(issueGeneration.getOrderType());
//			issue.setPeriodicity(issueGeneration.getPeriodicity());
			issue.setRateCard(issueGeneration.getRateCard());
			issue.setVolumeCaption(issueGeneration.getVolumeCaption());
			issue.setVolumeFormat(issueGeneration.getVolumeFormat());
			issue = issueGenerationRepo.save(issue);
			// issueGeneration.setId(issue.getId());

		}
		return issueGeneration;
	}

	@Override
	public IssueGenerationVo updateIssueGenerationVo(IssueGenerationVo issueGeneration) {
		IssueGeneration issue = new IssueGeneration();
		issue.setId(issueGeneration.getId());
		issue.setActive(issueGeneration.getActive());
		issue.setDiscountCard(issueGeneration.getDiscountCard());
		issue.setFrequencyOfGeneration(issueGeneration.getFrequencyOfGeneration());
		issue.setIssue_volume(issueGeneration.getIssue_volume());
		issue.setIssueCaption(issueGeneration.getIssueCaption());
		issue.setIssueFormat(issueGeneration.getIssueFormat());
//		issue.setIssuesAppearonEvery(issueGeneration.getIssuesAppearonEvery());
		issue.setNumberOfIssue(issueGeneration.getNumberOfIssue());
		issue.setIssueDate(issueGeneration.getIssueDate());
		issue.setDateoftheMonthYear(issueGeneration.getDateoftheMonthYear());
		issue.setChangeDate(issueGeneration.getChangeDate());
		issue.setSeqOfIssue(issueGeneration.getSeqOfIssue());
		// OrderCodes id added
//		OrderCodes ocode = new OrderCodes();
//		ocode.setId(issueGeneration.getOderCodeVo().getId());
//		issue.setOderCode(ocode);
		/// oderclass id
		OrderClass oc = new OrderClass();
		oc.setOcId(issueGeneration.getOrderClassId().getOcId());
		issue.setOrderClassId(oc);
		issue.setOrderType(issueGeneration.getOrderType());
//		issue.setPeriodicity(issueGeneration.getPeriodicity());
		issue.setRateCard(issueGeneration.getRateCard());
		issue.setVolumeCaption(issueGeneration.getVolumeCaption());
		issue.setVolumeFormat(issueGeneration.getVolumeFormat());
		issue.setIssueURL(issueGeneration.getIssueURL());
		issue.setAnalysed(issueGeneration.getAnalysed());
		issue.setFrozen(issueGeneration.getFrozen());
		issue.setInventoryID(issueGeneration.getInventoryID());
		issue.setClosed(issueGeneration.getClosed());
		issue.setRevenueGenerating(issueGeneration.getRevenueGenerating());
		issue = issueGenerationRepo.save(issue);
		return issueGeneration;
	}

	@Override
	public IssueGenerationVo insertIssueGenerationVo(IssueGenerationVo issueGeneration) {
		IssueGeneration issue = new IssueGeneration();
		issue.setId(issueGeneration.getId());
		issue.setActive(issueGeneration.getActive());
		issue.setDiscountCard(issueGeneration.getDiscountCard());
		issue.setFrequencyOfGeneration(issueGeneration.getFrequencyOfGeneration());
		issue.setIssue_volume(issueGeneration.getIssue_volume());
		issue.setIssueCaption(issueGeneration.getIssueCaption());
		issue.setIssueFormat(issueGeneration.getIssueFormat());
//		issue.setIssuesAppearonEvery(issueGeneration.getIssuesAppearonEvery());
		issue.setNumberOfIssue(issueGeneration.getNumberOfIssue());
		issue.setIssueDate(issueGeneration.getIssueDate());
		issue.setDateoftheMonthYear(issueGeneration.getDateoftheMonthYear());
		issue.setChangeDate(issueGeneration.getChangeDate());
		issue.setSeqOfIssue(findMaxSeqIssue(issueGeneration.getOrderClassId().getOcId())+1);
		// OrderCodes id added
//		OrderCodes ocode = new OrderCodes();
//		ocode.setId(issueGeneration.getOderCodeVo().getId());
//		issue.setOderCode(ocode);
		/// oderclass id
		OrderClass oc = new OrderClass();
		oc.setOcId(issueGeneration.getOrderClassId().getOcId());
		issue.setOrderClassId(oc);
		issue.setOrderType(issueGeneration.getOrderType());
//		issue.setPeriodicity(issueGeneration.getPeriodicity());
		issue.setRateCard(issueGeneration.getRateCard());
		issue.setVolumeCaption(issueGeneration.getVolumeCaption());
		issue.setVolumeFormat(issueGeneration.getVolumeFormat());
		issue.setIssueURL(issueGeneration.getIssueURL());
		issue.setAnalysed(issueGeneration.getAnalysed());
		issue.setFrozen(issueGeneration.getFrozen());
		issue.setInventoryID(issueGeneration.getInventoryID());
		issue.setClosed(issueGeneration.getClosed());
		issue.setRevenueGenerating(issueGeneration.getRevenueGenerating());
		issue = issueGenerationRepo.save(issue);
		return issueGeneration;
	}

	@Override
	public IssueGeneration findbyIssueId(Integer issueId) {
		return issueGenerationRepo.findById(issueId).get();
	}

	@Override
	public IssueGenerationVo generateIssueGenerationVo(IssueGenerationVo issueGeneration) {
		IssueSettings issueSettingData = issueSettingsRepo.findByOcId(issueGeneration.getOrderClassId().getOcId());
		int seq;
		if (findMaxSeqIssue(issueGeneration.getOrderClassId().getOcId() )== 0) {
			seq = 0;
		} else {
			seq = findMaxSeqIssue(issueGeneration.getOrderClassId().getOcId());
		}
		ArrayList<Date> generateDate = null;
		if (issueGeneration.getFrequencyOfGeneration().equals("Day")) {
		 generateDate = IssueGenerationUtils.everyday(issueGeneration.getNumberOfIssue(),
				issueGeneration.getChangeDate());
		}
		if (issueGeneration.getFrequencyOfGeneration().equals("Week")) {
		 generateDate = IssueGenerationUtils.everyweek(issueGeneration.getNumberOfIssue(),issueGeneration.getIssuesAppearonEvery(),
				issueGeneration.getChangeDate());
		}
		if (issueGeneration.getFrequencyOfGeneration().equals("Month")) {
		 generateDate = IssueGenerationUtils.everyMonth(issueGeneration.getNumberOfIssue(),issueGeneration.getIssuesAppearonEvery(),
				issueGeneration.getChangeDate());
		}
		if (issueGeneration.getFrequencyOfGeneration().equals("Year")) {
		generateDate = IssueGenerationUtils.everyYear(issueGeneration.getNumberOfIssue(),issueGeneration.getIssuesAppearonEvery(),
				issueGeneration.getChangeDate());
		}
		for (int i = 0; i < generateDate.size(); i++) {
			seq = seq + 1;
			IssueGeneration issue = new IssueGeneration();
			issue.setActive(issueGeneration.getActive());
			issue.setDiscountCard(issueGeneration.getDiscountCard());
			issue.setFrequencyOfGeneration(issueGeneration.getFrequencyOfGeneration());
			issue.setIssue_volume(issueGeneration.getIssue_volume());
			if (issueSettingData.getVolumeFormat().equals("Arebic")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + i + 1);
			}
			if (issueSettingData.getVolumeFormat().equals("Small Roman")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + IntegerToRoman.intToSmallRoman(i + 1));
			}
			if (issueSettingData.getVolumeFormat().equals("Large Roman")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + IntegerToRoman.intToRoman(i + 1));
			}
			if (issueSettingData.getVolumeFormat().equals("Lower Case Letter")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + IntegerToRoman.intToabcd(i + 1));
			}
			if (issueSettingData.getVolumeFormat().equals("Upper Case Letter")) {
				issue.setVolumeCaption(issueGeneration.getVolumeCaption() + "" + IntegerToRoman.intToABCD(i + 1));
			}
			// issueGeneration.getIssueFormat()

			issue.setIssueFormat(issueGeneration.getIssueFormat());
			// issue.setIssuesAppearonEvery(issueGeneration.getIssuesAppearonEvery());
			// , sepreated value
			// String monthDate= issueGeneration.getIssuesAppearonEvery();
			// issue.setNumberOfIssue(issueGeneration.getNumberOfIssue());
			issue.setIssueDate(generateDate.get(i));
			issue.setDateoftheMonthYear(issueGeneration.getDateoftheMonthYear());
			issue.setChangeDate(issueGeneration.getChangeDate());
			issue.setSeqOfIssue(seq);
			if (issueSettingData.getIssueFormat().equals("Arebic")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + i + 1);
			}
			if (issueSettingData.getIssueFormat().equals("Small Roman")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + IntegerToRoman.intToSmallRoman(i + 1));
			}
			if (issueSettingData.getIssueFormat().equals("Large Roman")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + IntegerToRoman.intToRoman(i + 1));
			}
			if (issueSettingData.getIssueFormat().equals("Lower Case Letter")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + IntegerToRoman.intToabcd(i + 1));
			}
			if (issueSettingData.getIssueFormat().equals("Upper Case Letter")) {
				issue.setIssueCaption(issueGeneration.getIssueCaption() + "" + IntegerToRoman.intToABCD(i + 1));
			}
			// OrderCodes id added
//			OrderCodes ocode = new OrderCodes();
//			ocode.setId(issueGeneration.getOderCodeVo().getId());
//			issue.setOderCode(ocode);
			/// oderclass id
			OrderClass oc = new OrderClass();
			oc.setOcId(issueGeneration.getOrderClassId().getOcId());
			issue.setOrderClassId(oc);
			issue.setOrderType(issueGeneration.getOrderType());
//			issue.setPeriodicity(issueGeneration.getPeriodicity());
			issue.setRateCard(issueGeneration.getRateCard());
			issue.setVolumeCaption(issueGeneration.getVolumeCaption());
			issue.setVolumeFormat(issueGeneration.getVolumeFormat());
			issue.setIssueURL(issueGeneration.getIssueURL());
			issue.setAnalysed(issueGeneration.getAnalysed());
			issue.setFrozen(issueGeneration.getFrozen());
			issue.setInventoryID(issueGeneration.getInventoryID());
			issue.setClosed(issueGeneration.getClosed());
			issue.setRevenueGenerating(issueGeneration.getRevenueGenerating());
			issue = issueGenerationRepo.save(issue);
			// issueGeneration.setId(issue.getId());

		}

		return issueGeneration;
	}

	@Override
	public Integer findMaxSeqIssue(Integer ocId) {
		Integer data;
		  try  
	        {  
			   data = issueGenerationRepo.findMaxSeqOfIssue(ocId); 
	        }  
	        catch(AopInvocationException e)  
	        {  data=0;
	            System.out.println(0);  
	        }  
		
		return data;
	}

	@Override
	public List<IssueGeneration> deleteIssueById(Integer[] issueId) {
		List<IssueGeneration> list=new ArrayList<>();
		for(Integer issue:issueId){
		IssueGeneration delete = findbyIssueId(issue);
		list.add(delete);
		issueGenerationRepo.delete(delete);
		}
		return list;
	}

	@Override
	public List<IssueGeneration> getAllIssueGenerationForPublisher(Integer pubId) {
		return issueGenerationRepo.findByOrderClassIdPubIdId(pubId);
	}

	@Override
	public List<IssueGeneration> getAllIssueGeneration() {
		return issueGenerationRepo.findAll();
	}

	@Override
	public IssueGeneration getCurrentIssue(Integer pubId, Integer ocId, Integer orderId , Date closeDate) {

		IssueGeneration currentIssue = issueGenerationRepo.getcurrentissue(pubId, ocId);
		IssueGeneration issueObj= new IssueGeneration();
		issueObj.setClosed(closeDate);
		issueGenerationRepo.saveAndFlush(issueObj);
		return null;
	}

	@Override
	public List<IssueGeneration> getCurrentIssue(Integer pubId, List<Integer> ocId) {
		List<IssueGeneration> response=new ArrayList<>();
		for(Integer orderClassId:ocId) {
			IssueGeneration temp = issueGenerationRepo.getcurrentissue(pubId, orderClassId);
			response.add(temp);
		}
		return response;
	}

	@Override
	public List<String> getAllIssueGenerationColumn() {
		return issueGenerationRepo.findAllIssueColumn();
	}

}
