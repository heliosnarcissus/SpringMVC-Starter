package com.swiftapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@ComponentScan("com.swiftapi.controller")

@EnableWebMvc
public class SwiftApiControlelr  {
	
	 	@RequestMapping("/")
	    public String get() {
	        //mapped to hostname:port/home/
	        return "This is Homepage";
	    }
	
//	@RequestMapping("/")
//	public ModelAndView helloWorld() {
// 
//		String message = "<br><div style='text-align:center;'>"
//				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
//		return new ModelAndView("welcome", "message", message);
//	}
	
	@GetMapping(value="/test")
	 public String testRun(@RequestParam String name) {
		System.out.println(" public String testRun()");
		 return "Hello "+name +" server is running!";
	 }
	
	@GetMapping("/showViewPage")
	public String passParametersWithModel(Model model) {
	    Map<String, String> map = new HashMap<>();
	    map.put("spring", "mvc");
	    model.addAttribute("message", "Baeldung");
	    model.mergeAttributes(map);
	    return "fuckyou";
	}
	
	@GetMapping("/printViewPage")
	public String passParametersWithModelMap(ModelMap map) {
	    map.addAttribute("welcomeMessage", "welcome");
	    map.addAttribute("message", "Baeldung");
	    return "viewPage";
	}
	
	@GetMapping("/goToViewPage")
	public ModelAndView passParametersWithModelAndView() {
	    ModelAndView modelAndView = new ModelAndView("viewPage");
	    modelAndView.addObject("message", "Baeldung");
	    return modelAndView;
	}
	
	@GetMapping("/welcomeHome")
    public ModelAndView getTestData() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.getModel().put("data", "Welcome home man");

        return mv;
    }
	
	@RequestMapping("/add")
    public ModelAndView getTestData(@RequestParam Integer num1, @RequestParam Integer num2) {
		
		Integer sum = num1 + num2 ;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("display.jsp");
        mv.addObject("result", sum);

        return mv;
    }
}
