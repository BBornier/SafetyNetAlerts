package com.safetynetalert.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safetynetalert.model.Address;
import com.safetynetalert.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository; 
	
	public Optional<Address> getAddress(final Long id) {
		return addressRepository.findById(id);
	}
	
	public Iterable<Address> getAddress() {
		return addressRepository.findAll();
	}
	
	public void deletePerson(final Long id) {
		addressRepository.deleteById(id);
	}
	
	public Address saveAddress(Address address) {
		Address savedAddress = addressRepository.save(address);
		return savedAddress;
	}
	
}

