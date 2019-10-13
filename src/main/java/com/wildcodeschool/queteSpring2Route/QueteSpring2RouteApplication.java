package com.wildcodeschool.queteSpring2Route;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class QueteSpring2RouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueteSpring2RouteApplication.class, args);

	}

	@RequestMapping("/hello1/{name}")
	@ResponseBody
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}

//http://localhost:8085/listDoctors/
	@RequestMapping("/listDoctors/")
	@ResponseBody // signifie que l'on va renvoyer la reponse qui est dans le corps de la methode
	// et non vers une autre page
	public String listDoctors() {
		int numberOfDoctors = 13;
		String listeTOTO = "<FONT size='12pt' color='#5a98f7' face='Times New Roman'>" + "<ul>";
		for (int i = 1; i <= numberOfDoctors; i++) {
			listeTOTO += "<li><a href='/listDoctors/" + i + "'>Doctor " + i + " </a></li>";
		}
		listeTOTO += "</ul>" + "</FONT>";
		return listeTOTO;
	}

//	William Hartnell		
//	Patrick Troughton		
//	Jon Pertwee				
//	Tom Baker				
//	Peter Davison			
//	Colin Baker				
//	Sylvester McCoy			
//	Paul McGann				
//	Christopher Eccleston			
//	David Tennant			
//	Matt Smith				
//	Peter Capaldi			
//	Jodie Whittaker	
//	@RequestParam(required = false, defaultValue = "parDefaut")

	@RequestMapping("/nameDoctors/{id_doctor}")
	@ResponseBody
	public String doctor2(@PathVariable int id_doctor) {
		String doctor = "<ul>";
		String[] listeOfDoctors = { "William Hartnell", "Patrick Troughton", "Jon Pertwee", "Tom Baker",
				"Peter Davison", "Colin Baker", "Sylvester McCoy", "Paul McGann", "Christopher Eccleston",
				"David Tennant", "Matt Smith", "Peter Capaldi", "Jodie Whittaker" };
		for (int i = 0; i < listeOfDoctors.length; i++) {
//			doctor = "<FONT size='12pt' color='#5a98f7' face='Times New Roman'>";
			doctor += "<li><a href='/nameDoctors/" + listeOfDoctors[i] + "'>Doctor " + listeOfDoctors[i] + " </a></li>";

		}
		doctor += "</ul>";
		return doctor;
	}

	@PostMapping("/listDoctors/{id_doctor}")
	@ResponseBody
	public String updateListDoctor(@RequestParam Map<String, String> allParams) {
		return "Parameters are " + allParams.entrySet();
	}

	@GetMapping("/listDoctors/{id_doctor}")
	@ResponseBody
	public String getListDoctor(@RequestParam List<String> id_doctor) {
		return "IDs are " + id_doctor;
	}

	@GetMapping("/listDoctors/{id}")
	@ResponseBody
	public String getActorName(@PathVariable("id") int id) {
		if (id == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question Not Found");
		}
		return "l'ID est :" + id;
	}

	@RequestMapping("/doctor/{id}")
	@ResponseBody
	public ResponseEntity<String> choiceDoctor(@PathVariable int id) {
		String[] listeOfDoctors = { "William Hartnell", "Patrick Troughton", "Jon Pertwee", "Tom Baker",
				"Peter Davison", "Colin Baker", "Sylvester McCoy", "Paul McGann", "Christopher Eccleston",
				"David Tennant", "Matt Smith", "Peter Capaldi", "Jodie Whittaker" };
		String reponse = null;
		for (int i = 0; i < listeOfDoctors.length; i++) {
			if (id < 8) {

				return new ResponseEntity<>(listeOfDoctors[id - 1] + ",we found url so return: 303 See Other.",
						HttpStatus.SEE_OTHER);
			} else if (id >= 8 && id <= 13) {
				reponse = "{\"number\":" + id + ", \"name\": " + listeOfDoctors[id - 1] + "}";
				System.out.println(reponse);
				return new ResponseEntity<>(reponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Impossible de récupérer l'incarnation " + id, HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<>(reponse, HttpStatus.OK);
	}

	@RequestMapping("/doctor2/{id}")
	@ResponseBody
	public ResponseEntity<String> choiceDoctor2(@PathVariable int id) {
		String[] listeOfDoctors = { "William Hartnell", "Patrick Troughton", "Jon Pertwee", "Tom Baker",
				"Peter Davison", "Colin Baker", "Sylvester McCoy", "Paul McGann", "Christopher Eccleston",
				"David Tennant", "Matt Smith", "Peter Capaldi", "Jodie Whittaker" };
		String reponse = null;
		for (int i = 0; i < listeOfDoctors.length; i++) {
			if (id < 8) {
//				HttpHeaders responseHeaders = new HttpHeaders();
//				responseHeaders.set("MyResponseHeader", "MyValue");
//				return new ResponseEntity<String>("http 201 created", responseHeaders, HttpStatus.CREATED);
				return new ResponseEntity<String>(listeOfDoctors[id - 1] + ",we found url so return: 303 See Other.",
						HttpStatus.SEE_OTHER);
			} else if (id >= 8 && id <= 13) {
				reponse = "{\"number\":" + id + ", \"name\": " + listeOfDoctors[id - 1] + "}";
				System.out.println(reponse);
				return new ResponseEntity<String>(reponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Impossible de récupérer l'incarnation " + id, HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<String>(reponse, HttpStatus.OK);
	}
}
