package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
class SpringBootJUnitWithMokitoApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	/*@Test
	void testSaveAccount() throws Exception {
		MockHttpServletRequestBuilder requestBuilder=
		MockMvcRequestBuilders.post("/save").header("Content-Type", "application/json")
		.content("{\"name\" : \"Balaraju\",\"village\" : \"Gollapalem\",\"mandal\" : \"Machilipatnam\",\"branch\" : \"Chinnapuram\"}");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse res = result.getResponse();
		
		assertEquals(200, res.getStatus());
		assertNotNull(res.getContentAsString());
		
	}*/
	
	/*@Test
	void testGetOneAccount() throws Exception {
		MockHttpServletRequestBuilder reqBuilder=
				MockMvcRequestBuilders.get("/one/1").header("Accept", "application/json");
		MvcResult result = mockMvc.perform(reqBuilder).andReturn();
		MockHttpServletResponse res = result.getResponse();
		assertEquals(200, res.getStatus());
		assertEquals("application/json", res.getContentType());
		assertNotNull(res.getContentAsString());
	}*/
	/*@Test
	void testGetAllAccounts() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/all")
		.header("Accept", "application/json");
		MvcResult result = mockMvc.perform(builder).andReturn();
		MockHttpServletResponse resp = result.getResponse();
		assertEquals(200, resp.getStatus());
		assertEquals("application/json", resp.getContentType());
		assertNotNull(resp.getContentAsString());
	}*/
	/*@Test
	void testDeleteOneAccount() throws Exception {
		MockHttpServletRequestBuilder bulid = MockMvcRequestBuilders.delete("/delete/1");
		 MvcResult result = mockMvc.perform(bulid).andReturn();
		 MockHttpServletResponse re = result.getResponse();
		 assertEquals(200, re.getStatus());
		 assertNotNull(re.getContentAsString());
		
	}*/
	@Test
	void testUpdateAccount() throws Exception {
		
		MockHttpServletRequestBuilder content = MockMvcRequestBuilders.put("/update").header("Content-Type", "application/json").content("{\"id\": 1,\"name\": \"Vasu\",\"village\": \"Parachivara\",\"mandal\": \"Nagayalanka\",\"branch\": \"Sangamaswaram\"}");
	     MvcResult result = mockMvc.perform(content).andReturn();
	     MockHttpServletResponse res = result.getResponse();
	     assertEquals(200, res.getStatus());
	   
	     assertNotNull(res.getContentAsString());
	}

}
