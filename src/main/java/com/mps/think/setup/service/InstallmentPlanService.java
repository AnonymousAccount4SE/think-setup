package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.InstallmentPlan;
import com.mps.think.setup.model.PaymentThreshold;
import com.mps.think.setup.model.SetupInstallments;
import com.mps.think.setup.vo.InstallmentPlanVO;
import com.mps.think.setup.vo.PaymentThresholdVO;
import com.mps.think.setup.vo.SetupInstallmentsVO;

 
@Service
public interface InstallmentPlanService {

 
	public InstallmentPlan saveInstallmentPlanService(InstallmentPlanVO installmentPlanVO);

	public InstallmentPlan updateInstallmentPlan(InstallmentPlanVO installmentPlanVO);

	public InstallmentPlan findByInstallmentPlanId(Integer id);

	public InstallmentPlan DeleteInstallmentPlan(Integer id);

	public List<InstallmentPlan> getAllInstallmentPlan();

	public SetupInstallments saveSetUpInstallmentsService(SetupInstallmentsVO setupInstallmentPlanVO);

	public SetupInstallments updateSetUpInstallments(SetupInstallmentsVO setupInstallmentPlanVO);

	public List<SetupInstallments> getSetUpInstallments();

	public SetupInstallments findBySetUpInstallmentsId(Integer id);

	public List<InstallmentPlan> getAllInstallmentPlanForPublisher(Integer pubId);

	public List<SetupInstallments> getAllInstallmentForPublisher(Integer pubId);

	public SetupInstallments DeleteSetupInstallment(Integer id);
}
