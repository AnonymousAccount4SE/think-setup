package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.IssueGeneration;
import com.mps.think.setup.model.JobPubOc;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderItemDetails;
import com.mps.think.setup.model.OrderItems;
import com.mps.think.setup.model.PaymentBreakdown;
import com.mps.think.setup.model.SubmitJob;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.repo.IssueGenerationRepo;
import com.mps.think.setup.repo.SubmitJobRepo;
import com.mps.think.setup.service.SubmitJobService;
import com.mps.think.setup.vo.SubmitJobVO;

@Service
public class SubmitJobServiceImpl implements SubmitJobService {
	
	@Autowired
	private SubmitJobRepo submitJobRepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private IssueGenerationRepo issueGenerationRepo;
	
	@Autowired
	private AddOrderRepo addOrderRepo;
	
	@Autowired
	private CustomerDetailsRepo customerDetailsRepo;

	@Override
	public List<SubmitJob> getAllSubmitJob() {
		return submitJobRepo.findAll();
	}

	@Override
	public SubmitJob saveSubmitJob(SubmitJobVO submitJob) {
		List<JobPubOc> list =new ArrayList<>();
		Integer nOfOrder=0;
		SubmitJob temp = submitJobRepo.saveAndFlush(mapper.convertValue(submitJob, SubmitJob.class));
		List<JobPubOc> listOfIssue = temp.getJobPubOc();
		for(JobPubOc jpo:listOfIssue) {
			jpo.setJobId(temp.getId());
			list.add(jpo);
		}
		temp.setJobPubOc(listOfIssue);
		for(JobPubOc jobPub:temp.getJobPubOc()) {
		List<Order> tempOrderList=addOrderRepo.getOrderList(temp.getPubId().getId(),jobPub.getIssueDate());
		nOfOrder=nOfOrder+tempOrderList.size();
		}
		temp.setNselectedrecords(nOfOrder);
		temp.setNcandidaterecords(customerDetailsRepo.nOfCustomer(temp.getPubId().getId()));
		submitJobRepo.saveAndFlush(temp);
		return temp;
	}

	@Override
	public SubmitJob updateSubmitJob(SubmitJobVO submitJob) {
		return submitJobRepo.saveAndFlush(mapper.convertValue(submitJob, SubmitJob.class));
	}

	@Override
	public SubmitJob findbySubmitJobId(Integer submitJobId) {
		Optional<SubmitJob> cr = submitJobRepo.findById(submitJobId);
		return cr.get();
	}

	@Override
	public SubmitJob deleteBySubmitJobId(Integer submitJobId) {
		SubmitJob delete = findbySubmitJobId(submitJobId);
		submitJobRepo.delete(delete);
		return delete;
	}

	@Override
	public List<SubmitJob> findAllSubmitJobByPubId(Integer publisherId) {
		return submitJobRepo.findByPubIdId(publisherId);
	}

	@Override
	public List<List<String>> updateProcessJobInDb(String jobStatus ,Integer jobId) {
		
		if(jobStatus.equals("Hold Job")) {
			labelProcess(jobId);
		}else if(jobStatus.equals("Hold Output")) {
			labelProcess(jobId);
		}else if (jobStatus.equals("Hold Update")) {
			labelProcess(jobId);
		}else if(jobStatus.equals("Hold for Manual Select")) {
			labelProcess(jobId);
		}else {
			System.out.println("please select any one status for proceed futher");
			labelProcess(jobId);
		}
		return null;
	}

	public List<List<String>> labelProcess(Integer jobId) {
		Integer issueLeft,liabilityIssue,nIssue,count=0,totalCount=0;
		SubmitJob sjob = submitJobRepo.findById(jobId).get();
		for(Integer issue:submitJobRepo.getListOfIssue(sjob.getId())) {
		IssueGeneration tempIssue = issueGenerationRepo.findById(issue).get();
		tempIssue.setClosed(sjob.getCreatedAt());
		issueGenerationRepo.saveAndFlush(tempIssue);
		}
		Integer pubId=sjob.getPubId().getId();
		for(JobPubOc jobPub:sjob.getJobPubOc()) {
		List<Order> tempOrderList=addOrderRepo.getOrderList(pubId,jobPub.getIssueDate());
		for(Order tempOrder:tempOrderList) {
			if(tempOrder.getOrderStatus().equals("order placed")) {
				tempOrder.setOrderStatus("active/shipping");
			}
			issueLeft= tempOrder.getOrderItemsAndTerms().getnIssuesLeft();
			liabilityIssue=tempOrder.getOrderItemsAndTerms().getLiabilityIssue();
//			nIssue=tempOrder.getOrderItemsAndTerms().getNumOfIssues()+tempOrder.getOrderItemsAndTerms().getExtendedIssue();
			OrderItems oItem=tempOrder.getOrderItemsAndTerms();
			oItem.setnIssuesLeft(issueLeft+1);
			oItem.setLiabilityIssue(liabilityIssue-1);
			tempOrder.setOrderItemsAndTerms(oItem);
			addOrderRepo.saveAndFlush(tempOrder);
			count++;
		}
		totalCount=totalCount+count;
		}
		sjob.setNupdatedrecords(totalCount);
		submitJobRepo.saveAndFlush(sjob);
		return null;
		
	}

	@Override
	public SubmitJob updateSubmitJobStatus(Integer jodId, String status) {
		SubmitJob sj=submitJobRepo.findById(jodId).get();
		sj.setStatus(status);
		return submitJobRepo.saveAndFlush(sj);
	}
	
	@Override
	public List<List<CustomerDetails>> listOfCustomer(Integer jobId){
		List<List<CustomerDetails>> listofCustomer=new ArrayList<>();
		SubmitJob sjob = submitJobRepo.findById(jobId).get();
		for(JobPubOc jobPub:sjob.getJobPubOc()) {
			List<CustomerDetails> temp = customerDetailsRepo.customerShipingAddress(sjob.getPubId().getId(), jobPub.getIssueDate());
			listofCustomer.add(temp);
		}
		return listofCustomer;
	}
}
