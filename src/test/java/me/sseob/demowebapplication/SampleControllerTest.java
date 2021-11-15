package me.sseob.demowebapplication;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	WebClient webClient;

	@Test
	public void hello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(view().name("hello"))
				.andExpect(model().attribute("name", is("sseob")))
				.andExpect(content().string(containsString("sseob")))
		;
	}
	
	@Test
	public void helloHtmlUnit() throws Exception {
		HtmlPage page = webClient.getPage("/hello");
		HtmlHeading1 htmlHeading1 = page.getFirstByXPath("//h1");
		assertThat(htmlHeading1.getTextContent()).isEqualToIgnoringCase("sseob");
	}
}