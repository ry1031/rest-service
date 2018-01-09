package org.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RegisterController.class, secure = false)
public class RegisterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RegisterService registerService;
	
	RegisterResult mockResult = new RegisterResult("text", "success");

	@Test
	public void retrieveDetailsForCourse() throws Exception {
		Mockito.when(
				registerService.register(Mockito.anyString(),
						Mockito.anyString())).thenReturn(mockResult);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/register?userId=test&location=room").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{type:text,content:success}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
