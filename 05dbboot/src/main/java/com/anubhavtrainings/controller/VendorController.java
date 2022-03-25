 package com.anubhavtrainings.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.entities.Vendor;
import com.anubhavtrainings.service.VendorService;

@RestController

public class VendorController {
	 

@Autowired

private    VendorService vendorService;

@RequestMapping("/vendor")
	public List<Vendor> getVendors(){
	return vendorService.readAllVendors();
	
	}
	//ES_GET_ENTITY
//@RequestMapping("/vendor/{vendorCode}")
 //public Vendor getVendorById(@PathVariable("vendorCode") String code) {
	//return vendorService.getsingleVendorById(code);
//}
//ES_CREATE_ENTITY
@PostMapping("/vendor")
public Vendor createVendor(@RequestBody Vendor myPostBody) {
	return vendorService.createVendor(myPostBody);
}
//test using   
@RequestMapping("/vendor/search")
public List<Vendor> searchByCompanyName(@RequestParam String company){
	return vendorService.searchByCompanyName(company);
}
//Test using localhost:8082/vendor/77
@RequestMapping("/vendor/lookup")
public List<Vendor> searchByGST(@RequestParam String GSTNo){
	return vendorService.lookupVendorByGST(GSTNo);
}
//ES_GET_ENTITY
@RequestMapping("/vendor/{vendorCode}")
public Vendor getVendorById(@PathVariable("vendorcode")Long code){
Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
if(!searchResult.isPresent()) {
	return new Vendor((long)0,"","","","","", null, null);
}
	return searchResult.get();
}
//test yourself-http://localhost:8082/vendor
//payload:"id": 9,
//"companyName": "SAP",
//"firstName": "soham",
//"lastName": "shobhan",
//"website": "www.abc.com",
//"email": "contact@sap.com",
//"status": "c",
//"gstNo": "gst123446"
//}
@RequestMapping(method=RequestMethod.PUT,value="/vendor")
public Vendor updateVendor(@RequestBody Vendor vendor) { 
return vendorService.changeVendor(vendor);

}
//test yourself  http://localhost:8082/vendor/id
@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{id}")
public String removeVendor(@PathVariable("id") Long Id) {
	return vendorService.deleteVendor(Id);
}

}
	 

