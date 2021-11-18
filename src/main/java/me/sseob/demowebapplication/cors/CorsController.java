package me.sseob.demowebapplication.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cors")
@RestController
public class CorsController {
	
	@CrossOrigin(origins = "http://localhost:18080") // http://localhost:18080 origin을 허용한다.
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
}
