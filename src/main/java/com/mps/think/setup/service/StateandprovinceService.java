package com.mps.think.setup.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.Stateandprovince;
import com.mps.think.setup.vo.StateandprovinceVO;

@Service
public interface StateandprovinceService {
	
	public List<Stateandprovince> getAllStateandprovince();
	
	public Stateandprovince saveStateandprovince(StateandprovinceVO stateandprovince);

	public Stateandprovince updateStateandprovince(StateandprovinceVO stateandprovince);

	public Stateandprovince findbyStateandprovinceId(Integer id);
	
	public Stateandprovince deleteByStateandprovinceId(Integer id);
	
	List<Stateandprovince> findAllStateandprovinceForPublisher(Integer pubId);
	
//	List<Stateandprovince> findAllStateandprovinceForCountry(Integer id);

}
