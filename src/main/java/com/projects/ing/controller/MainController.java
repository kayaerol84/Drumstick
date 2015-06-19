package com.projects.ing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projects.ing.database.ConnectedAccountDao;
import com.projects.ing.database.UserDao;
import com.projects.ing.db.domain.ConnectedAccount;
import com.projects.ing.domain.Transaction;
import com.projects.ing.domain.Transactions;
import com.projects.ing.domain.User;
import com.projects.ing.service.FacebookService;
import com.projects.ing.service.IngService;
import com.projects.ing.service.PersonalTransactionsService;

@Controller
public class MainController {
	
	private final FacebookService facebookService;
	private final PersonalTransactionsService personalTransactionsService;
	private final IngService ingService;
	private final UserDao userDao;
	private final ConnectedAccountDao connectedAccountDao;
	

	@Autowired
	public MainController(FacebookService facebookService, UserDao userDao, IngService ingService, PersonalTransactionsService personalTransactionsService, ConnectedAccountDao connectedAccountDao) {
		this.facebookService = facebookService;
		this.userDao = userDao;
		this.ingService = ingService;
		this.personalTransactionsService = personalTransactionsService;
		this.connectedAccountDao = connectedAccountDao;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String printWelcome(Model model) {
		model.addAttribute("message", "Drumstick Kolambu!!!");
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loadLoginPage(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String loadMainPage(Model model) {
		model.addAttribute("message", "Drumstick Kolambu!!!");
		return "main";
	}
	
	@RequestMapping(value = "/facebookUser", method = RequestMethod.GET)
	public String printFacebookUser(Model model) {
		/*User user = facebookService.fetchUser();
		model.addAttribute(user);
		return "facebook";*/
		String user = ingService.fetchMe();
		model.addAttribute("message", user);
		return "home";
	}
	
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public String printUserDetails(Model model) {
		User user = userDao.fetchUser(16101);
		model.addAttribute(user);
		return "user";
	}
	
	
	
	
	@RequestMapping(value = "/loadPersonal", method = RequestMethod.GET)
	public String loadPersonalScreen(Model model) {
		Transactions transactions = personalTransactionsService.fetchTransactions(16101);
		model.addAttribute(transactions);
		return "personal";
	}
	
	
	///////////////////
	
	
	
	@RequestMapping(value = "/loginFinal", method = RequestMethod.GET)
	public String loadFinalLoginPage(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/loadPersonalFinal", method = RequestMethod.GET)
	public String loadPersonalScreenFinal(Model model) {
		
		int loggedUserId = 16101;
		int category = 1;
		fetchAndAdd(model, loggedUserId, category);
		
		return "personal";  
	}

	@RequestMapping(value = "/loadFamilyFinal", method = RequestMethod.GET)
	public String loadFamilyScreenFinal(Model model) {
		
		int loggedUserId = 16101;
		int category = 2;
		fetchAndAdd(model, loggedUserId, category);
		
		return "family";  
	}
	
	@RequestMapping(value = "/loadFriendsFinal", method = RequestMethod.GET)
	public String loadFriendsScreenFinal(Model model) {
		
		int loggedUserId = 16101;
		int category = 3;
		fetchAndAdd(model, loggedUserId, category);
		
		return "friends";  
	}
	
	@RequestMapping(value = "/loadPublicFinal", method = RequestMethod.GET)
	public String loadPublicScreenFinal(Model model) {
		
		int loggedUserId = 16101;
		int category = 4;
		fetchAndAdd(model, loggedUserId, category);
		
		return "public";  
	}
	
	private void fetchAndAdd(Model model, int loggedUserId, int category) {
		List<ConnectedAccount> connectedAccountList = connectedAccountDao.fetchConnectedAccountsByUserIdAndCategory(loggedUserId, category);
		model.addAttribute(connectedAccountList);
		
		List<Transaction> allTransactions = new ArrayList<Transaction>();
		for(ConnectedAccount connectedAccount : connectedAccountList){
			Transactions specTransactions = personalTransactionsService.fetchTransactions(connectedAccount.getConnectedUserId());
			allTransactions.addAll(specTransactions.getList());
		}
		
		Transactions transactions = new Transactions();
		transactions.setList(allTransactions);
		model.addAttribute(transactions);
	}
	
	@RequestMapping(value = "/loadSearchAndConnect", method = RequestMethod.GET)
	public String loadPublicScreenFinal(Model model, @RequestParam(value="accountName", required=false) String page) {
		
		connectedAccountDao.insertConnectedAccount(16101, 1002, 4, "NL", "ING Bank NV", "RaghuEbolarelieffund", 16105);
		
		int loggedUserId = 16101;
		int category = 4;
		fetchAndAdd(model, loggedUserId, category);
		
		return "public";  
	}
	

}
