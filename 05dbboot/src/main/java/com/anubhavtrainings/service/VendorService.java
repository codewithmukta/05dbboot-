package com.anubhavtrainings.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.anubhavtrainings.entities.Vendor;

@Component
@Service
public class VendorService {
	// public class VendorController {
	@Autowired
	private IVendorPersistence vendor;

	public List<Vendor> readAllVendors() {
		return vendor.findAll();
	}
	// public Vendor getsingleVendorById(String vendorCode) {

	// return(Vendor)vendors.get(vendorCode);
	// }
	// public Vendor changeVendor(Vendor vendor) {
	// return vendor;
	// }
	public Vendor createVendor(Vendor vendorobj) {
		return vendor.save(vendorobj);

	}

	public List<Vendor> searchByCompanyName(String companyName) {
		return vendor.findByCompanyName(companyName);
	}

	public List<Vendor> lookupVendorByGST(String GSTNo) {
		return vendor.lookupVendorByGSTNo(GSTNo);
	}

	public Optional<Vendor> getSingleVendor(Long id) {
		return vendor.findById(id);
	}

	public Vendor changeVendor(Vendor payload) {
		Optional<Vendor> myVendor = vendor.findById(payload.getId());
		if (!myVendor.isPresent()) {
			return new Vendor((long) 0, "", "", "", "", null, null, null);

		  }
		return vendor.save(payload);

	}
	public String deleteVendor(Long Id) {
		vendor.deleteById(Id);
		return "Deleted Successfully";
	}

}
