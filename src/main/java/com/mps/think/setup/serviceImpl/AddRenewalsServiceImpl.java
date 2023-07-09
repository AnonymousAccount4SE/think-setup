package com.mps.think.setup.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AddRenewals;
import com.mps.think.setup.model.EffortRange;
import com.mps.think.setup.repo.AddRenewalsRepo;
import com.mps.think.setup.repo.EffortRangeRepo;
import com.mps.think.setup.service.AddRenewalsService;
import com.mps.think.setup.vo.AddRenewalsVO;

@Service
public class AddRenewalsServiceImpl implements AddRenewalsService{
	
	@Autowired
	private AddRenewalsRepo addRenewalsRepo;
	
	@Autowired
	private EffortRangeRepo effortRangeRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<AddRenewals> findAllAddRenewals() {
		return addRenewalsRepo.findAll();
	}

	@Override
	public AddRenewals saveAddRenewals(AddRenewalsVO addRenewalsVO) {
		return addRenewalsRepo.saveAndFlush(mapper.convertValue(addRenewalsVO, AddRenewals.class));
	}

	@Override
	public AddRenewals updateAddRenewals(AddRenewalsVO addRenewalsVO) {
		return addRenewalsRepo.saveAndFlush(mapper.convertValue(addRenewalsVO, AddRenewals.class));
	}

	@Override
	public AddRenewals deleteAddRenewals(Integer id) {
		AddRenewals delete = findbyAddRenewalsId(id);
//		int totalRenewals = renewalOfferDetailsRepo.findByAddRenewalId(id);
		List<EffortRange> rod = effortRangeRepo.findByAddRenewalId(id);
		rod.forEach(r -> effortRangeRepo.delete(r));
		addRenewalsRepo.delete(delete);
		return delete;
	}

	@Override
	public AddRenewals findbyAddRenewalsId(Integer id) {
		return addRenewalsRepo.findById(id).get();
	}

//	@Override
//	public Page<AddRenewals> getAllAddRenewalsForPublisher(Integer pubId, Pageable page) {
//		// TODO Auto-generated method stub
//		return addRenewalsRepo.findByPubIdId(pubId, page);
//	}

	@Override
	public List<AddRenewals> getAllAddRenewalsForPublisher(Integer pubId) {
		return addRenewalsRepo.findByPubIdId(pubId);
	}
	
	

}
