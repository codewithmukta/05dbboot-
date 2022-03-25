package com.anubhavtrainings.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.anubhavtrainings.service.AddressService;
import com.anubhavtrainings.entities.*;
@Service
public class AddressService {
	@Autowired
	IAddressPersistence address;
	
	@RequestMapping("/addresses")
	public List<Address> getAddress(){
		return address.findAll(); 
	}
	@PostMapping("/addresses")
	public Address createAddress(Address payload) {
		return address.save(payload);
	}

} 
