package com.bml.service.rs;

import java.sql.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bml.model.Delivery;
import com.bml.model.Pickup;

@CrossOrigin(maxAge = 3600)
@RestController
public interface RestService {

//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/delivery")
	@ResponseBody
	public Delivery getDelivery(@RequestParam(name = "conID") String conID);
/*	public LoginResponse login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password,
			@RequestParam(name = "username") String usertype,
			@RequestParam(name = "password") String usercode);*/

/*	public Status login(@RequestParam(name = "conID") String conID,
			@RequestParam(name = "deliveryDate") Date deliveryDate,
			@RequestParam(name = "pickupDate") Date pickupDate);*/
	
	@GetMapping("/pickup")
	@ResponseBody
	public Pickup getPickup(@RequestParam(name = "conID") String conID);

}
