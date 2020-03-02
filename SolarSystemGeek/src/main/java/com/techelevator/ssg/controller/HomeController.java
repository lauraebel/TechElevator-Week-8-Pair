package com.techelevator.ssg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	
	

	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping("/alienage")
		public String displayAlienAgePage() {
		return "alienage";
	}
	
	@RequestMapping("/alienweight")
	public String displayAlienWeightPage() {
	return "alienweight";
}
	@RequestMapping("/drivetime")
	public String displaydriveTimePage() {
	return "drivetime";
}
	
	@RequestMapping("/alienagesubmission")
	public String calculateAlienAge(HttpServletRequest request) {
		Map<String, Double> ageMap = new HashMap<String, Double>();
		ageMap.put("Mercury", 87.96 * 365.26);
		ageMap.put("Venus", 224.68 * 365.26);
		ageMap.put("Mars", 686.9 * 365.26);
		ageMap.put("Jupiter", 11.86);
		ageMap.put("Saturn", 29.456);
		ageMap.put("Uranus", 84.07);
		ageMap.put("Neptune", 164.81);
		String planetName= request.getParameter("planet");
		int earthAge= Integer.parseInt(request.getParameter("age"));
		double planetAge = ageMap.get(planetName)*earthAge;
		request.setAttribute("planetAge", planetAge);
	
	return "alienageoutput";
}
	
}
