package com.bml.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bml.common.ApplicationConstants;
import com.bml.user.NewUserVO;
import com.bml.vo.LoginDetailsVO;
import com.mongodb.MongoServerException;

@Repository
public class PickupDAO {

	private static Logger logger = LoggerFactory.getLogger(PickupDAO.class);
	@Autowired
	MongoOperations mongoOperation;

	@Autowired
	MongoTemplate mongoTemplate;

	public String validateLogin(String conID) {

		logger.debug(ApplicationConstants.LOG_ENTRY_MESSAGE);
		String recCnt=null;
		try {
			List<LoginDetailsVO> conDetails = mongoTemplate.find(Query.query(new Criteria()
                    .andOperator(Criteria.where("conID").is(conID),
                                Criteria.where("conID").is(conID))
                                /*Criteria.where("pickupDate").is(usertype),
                               Criteria.where("swusercode").is(usercode))*/
                    ), LoginDetailsVO.class);
			
			for (LoginDetailsVO foo : conDetails) {
			    recCnt=foo.getPickupDate();
			    System.out.println(foo.getPickupDate());
			}
			
			//recCnt=conDetails.size();

		} catch (Exception e) {
			logger.error("Exception while validating login details...",e);

		} finally {

			logger.debug(ApplicationConstants.LOG_EXIT_MESSAGE);
		}
		return recCnt;

	}
}
