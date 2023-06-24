package com.mps.think.setup.service;

import java.util.Date;
import java.util.List;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.IssueGeneration;
import com.mps.think.setup.model.SourceCode;
import com.mps.think.setup.vo.IssueGenerationVo;

public interface IssueGenerationService {
	
	public List<String> getAllIssueGenerationColumn();

	public List<IssueGeneration> findAllIssueGenerationVo();

	public IssueGenerationVo saveIssueGenerationVo(IssueGenerationVo issueGeneration);

	public IssueGenerationVo updateIssueGenerationVo(IssueGenerationVo issueGeneration);

	public IssueGeneration findbyIssueId(Integer issueId);
	
	public Integer findMaxSeqIssue(Integer ocId);

	IssueGenerationVo generateIssueGenerationVo(IssueGenerationVo issueGeneration);

	IssueGenerationVo insertIssueGenerationVo(IssueGenerationVo issueGeneration);
	
	public List<IssueGeneration> deleteIssueById(Integer[] issueId);

	public List<IssueGeneration> getAllIssueGenerationForPublisher(Integer pubId);

	public List<IssueGeneration> getAllIssueGeneration();
	
	public IssueGeneration getCurrentIssue(Integer pubId,Integer ocId,Integer orderId, Date closeDate);
	
	public List<IssueGeneration> getCurrentIssue(Integer pubId,List<Integer> ocId);
}
