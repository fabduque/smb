package br.com.smb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class menuController {
	
	@RequestMapping("abertura")
	public String abertura() {
		return "abertura";
	}
	
}
