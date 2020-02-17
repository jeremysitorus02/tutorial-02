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
	@RequestMapping("/calcuconvert")
	public String calcuconvert(
			@RequestParam(value ="nomor1") String nomor1, 
			@RequestParam(value ="nomor2") String nomor2,Model model) {
		
		int nomor11 = Integer.parseInt(nomor1);
		int nomor22 = Integer.parseInt(nomor2);
		String value = "";
		String[] angkaSatuan = {"nol","satu","dua","tiga","empat","lima","enam","tujuh","delapan","sembilan"};
		String[] angkaBelasan = {"sepuluh","sebelas","dua belas","tiga belas","empat belas","lima belas","enam belas",
				"tujuh belas","delapan belas","sembilan belas"};
		
		
		int result = nomor11 + nomor22;
		
		if (result < 10) {
			value = angkaSatuan[result];
		}
		else if (result < 20) {
			int temp = result;
			temp = temp - 10;
			value = angkaBelasan[temp];
			
		}
		else if (result < 100) {
			int temp = result / 10;
			int mod = result % 10;
			if (mod == 0) {
				value = angkaSatuan[temp] + " puluh";
			}else {
				value = angkaSatuan[temp] + " puluh " + angkaSatuan[mod];
			}
			
		}else {
			value = "Value out of Range";
		}
		
		model.addAttribute("nomor1", nomor11);
		model.addAttribute("nomor2", nomor22);
		model.addAttribute("result", result);
		model.addAttribute("word",value);
		
		return "calcuconvert";
		
	}
	
}