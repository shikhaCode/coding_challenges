package com.mindtree.activity.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.activity.entity.Patient;
import com.mindtree.activity.entity.QuarantineCenter;
import com.mindtree.activity.exception.ServiceException;
import com.mindtree.activity.service.serviceImpl.QuarantineServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private QuarantineServiceImpl service;
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value="/storeactivity",method=RequestMethod.GET)
	public ResponseEntity<?> activityAdd(@Validated @RequestParam String name) throws ServiceException {
		QuarantineCenter newactivity=new QuarantineCenter();
		newactivity.setPlaceName(name);
		try {
			service.save(newactivity);
			return ResponseEntity.status(HttpStatus.OK).body("details saved");
		}catch(DataAccessException e) {
			e.printStackTrace();
		 return 	ResponseEntity.status(HttpStatus.NOT_FOUND).body("place name is already present");
		}
		
				
	}
	@RequestMapping("/goto")
	public String addpatient() {
		return "patient";
	}
	@RequestMapping(value="/addparticipant",method=RequestMethod.GET)
	public ResponseEntity<String> participantAdd(@RequestParam (value="name") String name, @RequestParam int age , @RequestParam String placeName)
	
	{    
		QuarantineCenter act=null;
		int id3=Integer.valueOf(placeName);
		act=service.display2(id3);
		Patient parti =new Patient(name,age,act);
		service.save(parti);
		return ResponseEntity.status(HttpStatus.OK).body("details saved into db");}
	
		
	
		//return "welcome";

	@GetMapping("/details")
	public ModelAndView display( ModelAndView model) {
		List<Patient> parti=service.displayParticipant();
		model.addObject("parti",parti);
		System.out.println(parti);
		model.setViewName("allRecord");
		return model;
		
	}
	
	@RequestMapping("/update")
	public String update(Model m) {
		List<QuarantineCenter> list = service.getAllQuarantineCenter();
		m.addAttribute("list", list);
		return "update";
		
	}
	@RequestMapping("/updateCenter")
	public String updateCenter(@RequestParam("id") String id,@RequestParam("place") String age,@RequestParam("strength") String strength) {
		int qId=Integer.valueOf(id);
		QuarantineCenter qc = new QuarantineCenter(qId, age, strength);
		service.updateCenter(qc);
		return "update";
		
	}
	@RequestMapping("/delete")
	public String delete(Model m) {
		List<QuarantineCenter> list = service.getAllQuarantineCenter();
	
		m.addAttribute("list", list);
		return "delete";
		
	}
	
	@RequestMapping(value = "/deleteQuarantine", method = RequestMethod.GET)
	public String deleteParticipant(@RequestParam("id") String id) {
		int pId = Integer.valueOf(id);
		System.out.println("id"+id);
		service.deleteCenter(pId);
		return "welcome";
		
	}
	@RequestMapping("/updatePatient")
	public String updatePatient(Model m) {
		List<Patient> list = service.getAllPatient();
		m.addAttribute("list", list);
		return "updateNew";	
	}
	@RequestMapping("/updateD")
	public String updatePatient2(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("age") String age) {
		int qId=Integer.valueOf(id);
		int age1=Integer.valueOf(age);
		Patient pc=new Patient(qId,name,age1);
		service.updateCenter2(pc);
		System.out.println(pc);
		return "updateNew";
		
	}
	@RequestMapping("/deletePatient")
	public String deleteP(Model m) {
		List<Patient> list = service.getAllPatient();
	
		m.addAttribute("list", list);
		return "deletePage";
		
	}
	@RequestMapping(value = "/deleteP", method = RequestMethod.GET)
	public String deleteParti(@RequestParam("id") String id) {
		int pId = Integer.valueOf(id);
		System.out.println("id"+id);
		service.deletePatient(pId);
		return "welcome";
		
	}
	public ResponseEntity<String> updating(@RequestParam String id, @RequestParam String name,
			@RequestParam String strength) {
		int age1=Integer.valueOf(strength);

		Patient c = new Patient(name,age1);
		service.updateCenterDetails(c, age1);
		return ResponseEntity.status(HttpStatus.OK).body("Details updated");

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}