package com.bml.service.rs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bml.common.ApplicationConstants;
import com.bml.model.Delivery;
import com.bml.model.Pickup;
import com.bml.service.PickupService;
import com.bml.service.DeliveryService;

@Service
public class RestServiceImpl implements RestService {
	private static Logger log = LoggerFactory.getLogger(RestServiceImpl.class);

	@Autowired
	private DeliveryService deliverDervice;
	@Autowired
	private PickupService pickService;
	
	@Autowired
	private PickupService createUserAccountService;

	public RestServiceImpl() {
		// needed for autowiring
	}
	@Override
	public Delivery getDelivery(String conID) {
		 log.debug(ApplicationConstants.LOG_ENTRY_MESSAGE);
		return deliverDervice.getDelivery(conID);
	}
	@Override
	public Pickup getPickup(String conID) {
		 log.debug(ApplicationConstants.LOG_ENTRY_MESSAGE);
		return pickService.getPickup(conID);
	}
	
	
	

}
