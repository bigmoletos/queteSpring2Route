/**
 * 
 *
 */
package com.wildcodeschool.queteSpring2Route.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QueteSpring2RouteController {

//lien vers la page accueil.html
	@GetMapping("/hello3/")
	public String hello3(@RequestParam(required = false, defaultValue = "parDefaut") String title, ModelMap modelMap) {
		modelMap.put("title", title);
		return "pages/accueil";
	}

	@RequestMapping("/hello/{name}")
	@ResponseBody
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}

//renvoie ce qui est dans la méthode http://localhost:8085/hello2/franck?title=monTitre
	@RequestMapping("/hello2/{name}")
	@ResponseBody
	public String hello(@PathVariable String name, @RequestParam(required = false, defaultValue = "") String title) {
		if (title.length() > 0) {
			return "Hello " + name + " , " + title;
		} else {
			return "Hello " + name;
		}
	}

//	@RequestMapping("/doctor/{id}")
//	Question getQuestion(@PathVariable int id) {
//		if (id == 0) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question Not Found");
//		}
//		return Question.getById(id);
//	}

}