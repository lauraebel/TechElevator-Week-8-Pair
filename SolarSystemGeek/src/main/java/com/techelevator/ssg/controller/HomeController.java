package com.techelevator.ssg.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;

@Controller
public class HomeController {
	
	private Map<String, Double> ageMap = new HashMap<String, Double>();
	private Map<String, Double> weightMap = new HashMap<String, Double>();
	private Map<String, Double> travelMap = new HashMap<String, Double>();
	private Map<String, Integer> methodMap = new HashMap<String, Integer>();
	
	
	@Autowired
	private ForumDao forumdao;
	@Autowired
	private ProductDao productdao;
	
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
		ageMap.put("Mercury", 365.26/87.96);
		ageMap.put("Venus", 365.26/224.68);
		ageMap.put("Mars", 365.26/686.9);
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
	
	@RequestMapping("/alienweightsubmission")
	public String calculateAlienWeight(HttpServletRequest request) {
		weightMap.put("Mercury", 0.37);
		weightMap.put("Venus", 0.9);
		weightMap.put("Mars", 0.38);
		weightMap.put("Jupiter", 2.65);
		weightMap.put("Saturn", 1.13);
		weightMap.put("Uranus", 1.09);
		weightMap.put("Neptune", 1.43);
		String planetName= request.getParameter("planet");
		int earthWeight= Integer.parseInt(request.getParameter("weight"));
		double planetWeight = weightMap.get(planetName)*earthWeight;
		request.setAttribute("planetWeight", planetWeight);
	
	return "alienweightoutput";
	}
	
	@RequestMapping("/drivetimesubmission")
	public String calculateAlienTravel(HttpServletRequest request) {
		double oneMillion = 1000000;
		travelMap.put("Mercury", 56974146/oneMillion);
		travelMap.put("Venus", 25724767/oneMillion);
		travelMap.put("Mars", 48678219/oneMillion);
		travelMap.put("Jupiter", 390674710/oneMillion);
		travelMap.put("Saturn", 792248270/oneMillion);
		travelMap.put("Uranus", 1692662530/oneMillion);
		travelMap.put("Neptune", 2703959960L/oneMillion);
		
		methodMap.put("Walking", 3);
		methodMap.put("Car", 100);
		methodMap.put("Train", 200);
		methodMap.put("Boeing", 570);
		methodMap.put("Concorde", 1350);
		
		String planetName= request.getParameter("planet");
		String methodName = request.getParameter("method");
		Double age = Double.parseDouble(request.getParameter("age"));
		Double travelTimeInMillionMilesPerHour = travelMap.get(planetName)/methodMap.get(methodName);	
		Double hoursPerYear = 8760d;
		Double travelTime = (travelTimeInMillionMilesPerHour/hoursPerYear)*oneMillion;
		request.setAttribute("travelTime", travelTime);
		Double travelAge = travelTime + age;
		request.setAttribute("travelAge", travelAge);
	
	return "drivetimeoutput";
	}
	
	@RequestMapping("/spaceforum")
	public String showForumPost(ModelMap map) {
		List<ForumPost> post = forumdao.getAllPosts();
		map.put("posts", post);
		
		return "spaceforum";
	}
	
	@RequestMapping("/submitforumpage")
	public String submitPost() {	
		return "submitforumpage";
	}
	
	@RequestMapping(path="/submitforumpost", method=RequestMethod.POST)
	public String addNewPost(@RequestParam String Username, @RequestParam String Subject, @RequestParam String Message ) {
		ForumPost forumpost = new ForumPost();
		forumpost.setUsername(Username);
		forumpost.setDatePosted(LocalDateTime.now());
		forumpost.setMessage(Message);
		forumpost.setSubject(Subject);
		
		forumdao.save(forumpost);
		
		return "redirect:/spaceforum";
	}
	
	@RequestMapping("/spacestore")
	public String showInventory(ModelMap map) {
		List<Product> productList = productdao.getAllProducts();
		map.put("products", productList);
		return "spacestore";
	}
	
	@RequestMapping("/productdetail")
	public String showProductDetail(HttpServletRequest request, ModelMap map) {
		System.out.println(map.get("id"));
		Product product = productdao.getProductById(Long.parseLong(request.getParameter("id")));
		map.put("product", product);
		return "productdetail";
	}
	
	
}
