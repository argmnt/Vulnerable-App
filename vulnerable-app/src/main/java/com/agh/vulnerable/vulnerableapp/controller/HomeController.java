package com.agh.vulnerable.vulnerableapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Controller
public class HomeController {

	@GetMapping(value = { "", "/"})
	public String showhome() {
		return 	"home";
	}



}
