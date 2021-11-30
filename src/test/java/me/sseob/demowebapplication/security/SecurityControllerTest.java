package me.sseob.demowebapplication.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(SecurityController.class)
public class SecurityControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void helloSecurity() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/security/hello"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("helloSecurity"))
		;
	}
}