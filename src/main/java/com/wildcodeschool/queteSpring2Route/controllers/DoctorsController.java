/**
 * 
 *
 */
package com.wildcodeschool.queteSpring2Route.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author franck Desmedt github/bigmoletos
 *
 */
@Controller
public class DoctorsController {
	@RequestMapping("/doctors/{id}")
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
