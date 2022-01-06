package com.safetynetalert.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynetalert.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

}

