package com.anubhavtrainings.controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.entities.Address;
import com.anubhavtrainings.service.AddressService;
import com.anubhavtrainings.service.AddressService;
@RestController
public class AddressController {
	@Autowired
	AddressService addSrv;

	@RequestMapping("/addresses")
   public List<Address> getAddress() {
		return addSrv.getAddress();
	}
 
	@PostMapping("/addresses")
	public Address createAddress(@RequestBody Address payload) {
		return addSrv.createAddress(payload);
	}
}
