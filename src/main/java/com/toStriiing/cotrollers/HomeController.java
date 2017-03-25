package com.toStriiing.cotrollers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="customer.do", method=RequestMethod.GET)
	public ModelAndView customerPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerdashboard");
		
		return mv;
	}
	
	@RequestMapping(value="vendor.do", method=RequestMethod.GET)
	public ModelAndView vendorPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("vendordashboard");
		
		return mv;
	}
	
	@RequestMapping(value="developer.do", method=RequestMethod.GET)
	public ModelAndView developerPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("developerdashboard");
		
		return mv;
	}
	
	
	
}
