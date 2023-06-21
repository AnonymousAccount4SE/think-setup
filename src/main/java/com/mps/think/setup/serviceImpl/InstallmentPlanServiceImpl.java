package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AddEffort;
import com.mps.think.setup.model.InstallmentPlan;
import com.mps.think.setup.model.PaymentThreshold;
import com.mps.think.setup.model.SetupInstallments;
import com.mps.think.setup.repo.InstallmentPlanRepo;
import com.mps.think.setup.repo.SetupInstallmentsRepo;
import com.mps.think.setup.service.InstallmentPlanService;
import com.mps.think.setup.vo.InstallmentPlanVO;
import com.mps.think.setup.vo.SetupInstallmentsVO;
 
@Service
public class InstallmentPlanServiceImpl implements InstallmentPlanService{

	@Autowired
	private InstallmentPlanRepo installmentPlanRepo;

	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private SetupInstallmentsRepo setupInstallmentsRepo;
	
  
@Override
public InstallmentPlan saveInstallmentPlanService(InstallmentPlanVO installmentPlanVO) {
	return 	installmentPlanRepo.saveAndFlush(mapper.convertValue(installmentPlanVO, InstallmentPlan.class));
	
}

@Override
public InstallmentPlan updateInstallmentPlan(InstallmentPlanVO installmentPlanVO) {
	ObjectMapper obj = new ObjectMapper();
	InstallmentPlan instPlan = obj.convertValue(installmentPlanVO, InstallmentPlan.class);
	InstallmentPlan installPlan = installmentPlanRepo.saveAndFlush(instPlan);
	return installPlan;
}

@Override
public InstallmentPlan findByInstallmentPlanId(Integer id) {
	return installmentPlanRepo.findById(id).get();
}

@Override
public InstallmentPlan DeleteInstallmentPlan(Integer id) {
	InstallmentPlan remove = installmentPlanRepo.findById(id).get();
	if (remove != null) {
		installmentPlanRepo.delete(remove);
	}
	return remove;
}

@Override
public List<InstallmentPlan> getAllInstallmentPlan() {
	return installmentPlanRepo.findAll();
}

@Override
public SetupInstallments saveSetUpInstallmentsService(SetupInstallmentsVO setupInstallmentPlanVO) {
	return 	setupInstallmentsRepo.saveAndFlush(mapper.convertValue(setupInstallmentPlanVO, SetupInstallments.class));

}

@Override
public SetupInstallments updateSetUpInstallments(SetupInstallmentsVO setupInstallmentPlanVO) {
	ObjectMapper obj = new ObjectMapper();
	SetupInstallments setupInstPlan = obj.convertValue(setupInstallmentPlanVO, SetupInstallments.class);
	SetupInstallments installPlan = setupInstallmentsRepo.saveAndFlush(setupInstPlan);
	return installPlan;
}

@Override
public List<SetupInstallments> getSetUpInstallments() {
	return setupInstallmentsRepo.findAll();
}

@Override
public SetupInstallments findBySetUpInstallmentsId(Integer id) {
	return setupInstallmentsRepo.findById(id).get();
}
}