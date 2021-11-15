package me.sseob.demowebapplication.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@GetMapping("/helloUser")
	public String hello() {
		return "helloUser";
	}

	@PostMapping("/users/create")
	public User create(@RequestBody User user) {
		return user;
	}
}
