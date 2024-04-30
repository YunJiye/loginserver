package com.example.loginserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
class LoginserverApplicationTests {

	/*@Test
	void contextLoads() {
	}*/

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {
        String id = "testId";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/")
                .param("id", id))
                .andExpect(status().isOk())
                .andExpect(content().string("id is " + id))
                .andReturn();
	}

}
