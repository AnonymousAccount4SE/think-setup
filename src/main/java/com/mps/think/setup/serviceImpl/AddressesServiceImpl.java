package com.mps.think.setup.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.Address;
import com.mps.think.setup.model.Addresses;
import com.mps.think.setup.model.Countries;
import com.mps.think.setup.repo.AddressesRepo;
import com.mps.think.setup.service.AddressService;
import com.mps.think.setup.vo.AddressesVO;

@Service
public class AddressesServiceImpl implements AddressService  {
	
	@Autowired
	private AddressesRepo addressRepo;
	
	@Autowired
	CustomerDetailsServiceImpl customerDetailsServiceImpl;
	
	

	@Override
	public AddressesVO saveAddresses(AddressesVO addresses) {
		
		Addresses data = new Addresses();
		data.setAddressName(addresses.getAddressName());
		data.setAddressType(addresses.getAddressType());
		data.setAddressCategory(addresses.getAddressCategory());
		data.setStatus(addresses.getStatus());
		data.setPrimaryAddress(addresses.getPrimaryAddress());
		data.setName(addresses.getName());
		data.setAddressLine1(addresses.getAddressLine1());
		data.setAddressLine2(addresses.getAddressLine2());
		data.setZipCode(addresses.getZipCode());
		data.setCity(addresses.getCity());
		data.setState(addresses.getState());
		data.setCountry(addresses.getCountry());
		data.setCountryCode(addresses.getCountryCode());
		data.setPhone(addresses.getPhone());
		data.setValidFrom(addresses.getValidFrom());
		data.setValidTo(addresses.getValidTo());
		data.setFrequency(addresses.getFrequency());
		data.setAddressAuxJSON(addresses.getAddressAuxJSON());
		data.setSelectionFrom(addresses.getSelectionFrom());
		data.setSelectionTo(addresses.getSelectionTo());
		data.setAddressstatus(addresses.getAddressstatus());
		addresses.setAddressId(data.getAddressId());
		addressRepo.saveAndFlush(data);
		addresses.setAddressId(data.getAddressId());
		return addresses;
	}

	@Override
	public AddressesVO updateAddresses(AddressesVO addresses) {
		Addresses data = new Addresses();
		data.setAddressId(addresses.getAddressId());
		data.setAddressName(addresses.getAddressName());
		data.setAddressType(addresses.getAddressType());
		data.setAddressCategory(addresses.getAddressCategory());
		data.setStatus(addresses.getStatus());
		data.setPrimaryAddress(addresses.getPrimaryAddress());
		data.setName(addresses.getName());
		data.setAddressLine1(addresses.getAddressLine1());
		data.setAddressLine2(addresses.getAddressLine2());
		data.setZipCode(addresses.getZipCode());
		data.setCity(addresses.getCity());
		data.setState(addresses.getState());
		data.setCountry(addresses.getCountry());
		data.setCountryCode(addresses.getCountryCode());
		data.setPhone(addresses.getPhone());
		data.setValidFrom(addresses.getValidFrom());
		data.setValidTo(addresses.getValidTo());
		data.setFrequency(addresses.getFrequency());
		data.setSelectionFrom(addresses.getSelectionFrom());
		data.setSelectionTo(addresses.getSelectionTo());
		data.setAddressstatus(addresses.getAddressstatus());
		data.setAddressAuxJSON(addresses.getAddressAuxJSON());
		addressRepo.saveAndFlush(data);
		return addresses;
	}

	@Override
	public Addresses findbyAddressesId(Integer addressesId) {
		 Optional<Addresses> cr = addressRepo.findById(addressesId);
		return cr.get();
	}

	@Override
	public Addresses deleteByAddressesId(Integer addressesId) {
		Addresses delete = findbyAddressesId(addressesId);
		addressRepo.delete(delete);
		return delete;
	}

	@Override
	public void setGivenAddressesNonPrimary(List<Integer> addressesIds) {
		List<Addresses> addressesToCheck = addressRepo.findAllById(addressesIds);
		List<Addresses> updatedAddresses = addressesToCheck.stream().map(a -> {
			a.setPrimaryAddress(false);
			return a;
		}).collect(Collectors.toList());
		addressRepo.saveAllAndFlush(updatedAddresses);
	}

	@Override
	public void updateSelectedAddressAsPrimary(Integer addressId) {
		Addresses address = addressRepo.findById(addressId).get();
		address.setPrimaryAddress(true);
		addressRepo.saveAndFlush(address);
	}

	

	

	@Override
	public List<Addresses> getAllAddresses() {
		return addressRepo.findAll();
	}

	@Override
	public List<Addresses> getTodayAndYesterdayRecords() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);   
        return addressRepo.findTodayAndYesterdayRecords(today, yesterday);
        
	}

	@Override
	public List<String> findAllColumnforAddresses() {
		return addressRepo.findAllColumnforAddresses();
	}
	

	
	
//	@Override
//	public Addresses updatePrimaryAddressbyCustId(Integer customerId, Integer addressId) {
//		CustomerDetails customer= customerDetailsServiceImpl.findbyCustomerDetailsId(customerId);
//		for(CustomerAddresses custAddress:customer.getCustomerAddresses()) {
//			for(Addresses address:custAddress.getAddressess()) {
//				address.setPrimaryAddress(false);
//				addressRepo.save(address);
//			}
//		}
//		Addresses details= addressRepo.findByaddressId(addressId);
//		details.setPrimaryAddress(true);
//		addressRepo.save(details);
//		return details;
//	}

//	@Override
//	public List<Addresses> getAllAddressesByCustomerId(Integer cusId) {
//		List<Addresses> output = new ArrayList<>();
////		for (Addresses address : addressRepo.findAll()) {
////			if (address.getCusId().getCustomerId().equals(cusId)) {
////				output.add(address);
////			}
////		}
//		return output;
//	}

}
