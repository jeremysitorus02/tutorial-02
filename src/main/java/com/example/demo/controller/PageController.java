package com.example.demo.controller;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class PageController {
	@RequestMapping ("/hello")
	public String hello() {
		return "aloha";
	}
	@RequestMapping ("/hello2")
	public String hello2( @RequestParam (value = "name", 
	required = false, defaultValue = "Thanos")
	String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}
	@RequestMapping (value = {"/hello2", "/hello2/{name}"})
	public String helloPath( @PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}
	@RequestMapping ("/calcuconvert")
	public String calcuconvert( 
	@RequestParam (value = "nomor1", required = false) String nomor1,
	@RequestParam (value = "nomor2", required = false) String nomor2,
	Model model){
		int hasil = Integer.parseInt(nomor1) + Integer.parseInt(nomor2);
		model.addAttribute("nomor1", nomor1);
		model.addAttribute("nomor2", nomor2);
		model.addAttribute("hasil", hasil);
		return "calcuconvert";
	}
}