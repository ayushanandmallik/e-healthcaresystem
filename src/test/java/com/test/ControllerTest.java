package com.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.controllerpackage.AdminControl;
import com.controllerpackage.AppController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class ControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private AppController appControl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc= MockMvcBuilders.standaloneSetup(appControl).build();
		
	}
	
	@Test
	public void testHome() throws Exception {
		mockMvc.perform(get("/home")).andExpect(status().isOk())
		.andExpect(forwardedUrl("index"));
	}
	
	
	
}
