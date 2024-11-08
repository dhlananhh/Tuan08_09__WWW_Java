package iuh.fit.se.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import iuh.fit.se.entities.Address;
import iuh.fit.se.repositories.AddressRepository;
import iuh.fit.se.services.AddressService;

public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	
	@Override
	public Address save (Address address) {
		return this.addressRepository.save(address);
	}

}
