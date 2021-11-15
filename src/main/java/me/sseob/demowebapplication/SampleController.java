package me.sseob.demowebapplication;

import me.sseob.demowebapplication.util.AppError;
import me.sseob.demowebapplication.util.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name", "sseob");
		return "hello";
	}

	@GetMapping("/exception")
	public String exception() {
		throw new CustomException();
	}

	@ExceptionHandler(CustomException.class)
	@ResponseBody
	public AppError sampleError(CustomException e) {
		AppError appError = new AppError();
		appError.setMessage("error.app.customexception");
		appError.setReason("custom exception kkk");
		return appError;
	}
}
