package me.sseob.demowebapplication.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {

	@GetMapping("/hello")
	public String hello() {
		return "helloSecurity";
	}

	@GetMapping("my")
	public String my() {
		return "my";
	}
}
