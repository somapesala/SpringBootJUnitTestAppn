package com.springboot.test.SpringBootJUnitTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.common.Employee;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringBootJUnitTestApplicationTests {

	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
/*	@Test
	public void getAllEmployeesTest() throws Exception{
		mockMvc.perform(get("/getEmployees").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
        .andExpect(status().isOk());
	}
	
	@Test
	public void getEmployeeTest() throws Exception{
		
		mockMvc.perform(get("/employee/details/10").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.empNo", Is.is(10)))
        .andExpect(jsonPath("$.name", Is.is("soma")))
        .andExpect(jsonPath("$.salary", Is.is(3454525.0)));
	} */
	
	@Test
	public void saveEmployeeTest() throws Exception{
		
		String employeeJson = "{\"empNo\":\"1\",\"name\":\"soma\",\"salary\":\"76577\"}";
	    
	    ResultActions result = mockMvc.perform(post("/saveEmployee/somasekharareddy")
                .content(employeeJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
	    
	    //get the data from response body
	     MockHttpServletResponse response = result.andReturn().getResponse();
	       String contentAsString = response.getContentAsString();
	       System.out.println(contentAsString);
	      
	       
	//    Assert.assertEquals("1", contentAsString);
	   
	    
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
