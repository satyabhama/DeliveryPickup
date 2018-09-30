package com.bml.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bml.common.ApplicationConstants;
import com.bml.dao.PickupDAO;
import com.bml.dao.DeliveryDAO;
import com.bml.model.Delivery;
import com.bml.model.Pickup;
import com.bml.service.rs.RestServiceImpl;
import com.bml.user.NewUserVO;

@Service
public class PickupServiceImpl implements PickupService {
	private static Logger log = LoggerFactory.getLogger(RestServiceImpl.class);
	
	@Autowired
	PickupDAO pickupDao;

	public PickupServiceImpl() {
		// needed for instantiation
	}

	@Override
	public Pickup getPickup(String conID) {
		Pickup loginRes = new Pickup();

		log.debug(ApplicationConstants.LOG_ENTRY_MESSAGE);
		try {

			String pickupDate=pickupDao.validateLogin(conID);
			//int count = loginDao.validateLogin(conID);
			int count=1;
			if(pickupDate!=null)
			{
				loginRes.setPickupDate(pickupDate);
			}else
			{
				loginRes.setPickupDate("Incorrect Consignment");
			}
		} catch (Exception e) {
			log.error("Error while validating username password..." + e);
		} finally {

			log.debug(ApplicationConstants.LOG_EXIT_MESSAGE);
		}
		return loginRes;
	}
}