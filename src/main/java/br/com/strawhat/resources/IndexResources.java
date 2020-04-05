package br.com.strawhat.resources;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexResources {

	@GetMapping("/")
	public String index(){
		return "index";
	}
}
