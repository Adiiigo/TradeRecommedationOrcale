package com.cummins.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cummins.PredictionModel.Prediction;
import com.cummins.PredictionPython.PredictionFactory;
import com.cummins.StockDownloader.StockFactory;
import com.cummins.Stocks.Security;
import com.cummins.UserDetails.AccountDetail;
import com.cummins.UserDetails.UserFactory;
import com.cummins.UserDetails.Userdetail;
import com.cummins.demoDAO.AccountDetaillDB;
import com.cummins.demoDAO.DataBaseConn;
import com.cummins.demoDAO.SaveDetailDB;
import com.cummins.demoDAO.SectorDB;
import com.cummins.demoDAO.SecurityDB;
import com.cummins.demoDAO.SignUp;
import com.cummins.demoDAO.UserDetailsDB;
import com.cummins.demoDAO.UserValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
//@EnableWebMvc

public class DemoService {

	static DataBaseConn conn = new DataBaseConn();

	@RequestMapping(value = "/sectorDisplay", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getSector() {

		SectorDB sectors = new SectorDB();

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in String
		String jsonInString = new String();
		try {
			jsonInString = mapper.writeValueAsString(sectors.getSectors(conn));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service called");
		return jsonInString;
	}

	
	@RequestMapping(value = "/securityDisplay", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String getSecurity(@RequestBody Security security) {

		System.out.println(security.getSymbol());
		SecurityDB securitydb = new SecurityDB(conn, security.getSymbol());
		StockFactory stockfactory = new StockFactory();
		stockfactory.stockFactory(securitydb.returnStocks());
		Prediction predictStocks=new Prediction(securitydb.returnStocks());
	//	PredictionFactory predictStocks = new PredictionFactory(securitydb.returnStocks());

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in String
		String jsonInString = new String();
		try {
			jsonInString = mapper.writeValueAsString(predictStocks);
			// jsonInSell= mapper.writeValueAsString(predictStocks.)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("service return  called");
		return jsonInString;
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String loginDetails(@RequestBody Userdetail login) {
		System.out.println(login.getEmail_id());
		int status;
		UserValidation user = new UserValidation();
		status = user.getUser(conn, login);
		String invalid = new String();
		ObjectMapper mapper = new ObjectMapper();


		if (status == 1) {
			// ArrayList<SavedDetails> savedetail = new
			// ArrayList<SavedDetails>();
			UserFactory userfactory = new UserFactory(conn, login);
			
			// Object to JSON in String
			String jsonInString = new String();
			try {
				jsonInString = mapper.writeValueAsString(userfactory);
				// jsonInSell= mapper.writeValueAsString(predictStocks.)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("service return  called");
			return jsonInString;
		} else {
			try {
				invalid = mapper.writeValueAsString("invalid username or password");
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null
					;
		}

	}

	@RequestMapping(value = "/SignUp", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String SignUpDetails(@RequestBody Userdetail signup) {
		System.out.println(signup.getEmail_id());
		int status;
		UserValidation user = new UserValidation();
		status = user.getUser(conn, signup);
		String invalid = new String();
		ObjectMapper mapper = new ObjectMapper();


		if (status == 1) {
			
			try {
				invalid = mapper.writeValueAsString("User Already exists Cannot signup!!");
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return invalid;
			
		} else {
			SignUp signIn=new SignUp(conn,signup);
			try {
				invalid = mapper.writeValueAsString("1");
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return invalid;
			
		}
	}
	
	@RequestMapping(value = "/Savenew", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody String SaveDetails(@RequestBody UserFactory savedetails) {
		//System.out.println(signup.getUserName());
	SaveDetailDB save=new	SaveDetailDB();
	save.getSaveDetailDB(conn, savedetails.getSavedetail().get(0),savedetails.getLogin());
	String details=new String();
	ObjectMapper mapper = new ObjectMapper();
	try {
		
		UserFactory user=new UserFactory(conn, savedetails.getLogin());
		details = mapper.writeValueAsString(user);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return details;
		

	}

}
 