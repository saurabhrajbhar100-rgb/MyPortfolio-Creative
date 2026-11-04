package com.sheat.myportfolio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
class MyPortfolioApplicationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void bothRoutesRenderDynamicData() throws Exception {
        for (String path : new String[] {"/", "/portfolio/creative"}) {
            String html = mockMvc.perform(get(path))
                    .andExpect(status().isOk())
                    .andExpect(view().name("creative"))
                    .andExpect(model().attributeExists("skills", "projects", "name"))
                    .andReturn().getResponse().getContentAsString();

            assertTrue(html.contains("Roshan Gupta"), path + ": name");
            assertTrue(html.contains("Spring Boot"), path + ": skill");
            assertTrue(html.contains("Student Management System"), path + ": project 1");
            assertTrue(html.contains("Smart Irrigation System"), path + ": project 3");
            assertTrue(html.contains("Home Automation System"), path + ": project 4");
            assertTrue(html.contains("https://github.com/roshangupta7755"), path + ": github");
            assertTrue(html.contains("/css/creative.css"), path + ": own css file");
        }
    }
}
