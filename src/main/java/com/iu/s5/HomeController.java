package com.iu.s5;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.s5.transfer.Card;
import com.iu.s5.transfer.Transfer;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	

//	private String user;
	
	private Transfer transfer;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		System.out.println(user);
		
		
		
		
		Card card = new Card();
		
		card.cardCheck();
		transfer.bus();
		card.cardCheck();
		
		
		card.cardCheck();
		transfer.subway();
		card.cardCheck();
		
		 
		
		
		
		
		
		
		return "index";
	}
	
}

























