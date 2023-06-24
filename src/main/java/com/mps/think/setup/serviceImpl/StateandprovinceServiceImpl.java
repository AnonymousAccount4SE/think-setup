package com.mps.think.setup.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Stateandprovince;
import com.mps.think.setup.repo.StateandprovinceRepo;
import com.mps.think.setup.service.StateandprovinceService;
import com.mps.think.setup.vo.StateandprovinceVO;

@Service
public class StateandprovinceServiceImpl  implements StateandprovinceService {
	
	@Autowired
	private StateandprovinceRepo stateandprovinceRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Stateandprovince> getAllStateandprovince() {
		return stateandprovinceRepo.findAll();
	}

	@Override
	public Stateandprovince saveStateandprovince(StateandprovinceVO stateandprovince) {
		return stateandprovinceRepo.saveAndFlush(mapper.convertValue(stateandprovince, Stateandprovince.class));
	}

	@Override
	public Stateandprovince updateStateandprovince(StateandprovinceVO stateandprovince) {
		return stateandprovinceRepo.saveAndFlush(mapper.convertValue(stateandprovince, Stateandprovince.class));
	}

	@Override
	public Stateandprovince findbyStateandprovinceId(Integer id) {
		return stateandprovinceRepo.findById(id).get();
	}

	@Override
	public Stateandprovince deleteByStateandprovinceId(Integer id) {
		Stateandprovince delete = findbyStateandprovinceId(id);
		stateandprovinceRepo.delete(delete);
		return delete;
	}

	@Override
	public List<Stateandprovince> findAllStateandprovinceForPublisher(Integer pubId) {
		return stateandprovinceRepo.findByPubIdId(pubId);
	}

//	@Override
//	public List<Stateandprovince> findAllStateandprovinceForCountry(Integer id) {
//		return stateandprovinceRepo.findByCountryidId(id);
//	}

}
