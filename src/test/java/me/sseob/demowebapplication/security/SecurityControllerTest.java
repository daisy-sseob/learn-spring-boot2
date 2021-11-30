package me.sseob.demowebapplication.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
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
	@WithMockUser // user를 mock up 해줌
	public void helloSecurity() throws Exception {
		mockMvc.perform(
					MockMvcRequestBuilders.get("/security/hello")
							.accept(MediaType.TEXT_HTML)
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("helloSecurity"))
		;
	}
	
	@Test
	@WithMockUser
	public void my() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/security/my"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("my"))
		;
	}
}