package com.example.secureblog.controller;

import com.example.secureblog.model.User;
import com.example.secureblog.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private User validUser;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

        validUser = new User();
        validUser.setUsername("testuser");
        validUser.setEmail("test@example.com");
        validUser.setPassword("password123");
    }

    @Test
    void whenRegisterWithValidData_thenReturns200() throws Exception {
        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validUser)))
                .andExpect(status().isOk());
    }

    @Test
    void whenLoginWithValidCredentials_thenReturns200() throws Exception {
        // First register a user
        validUser.setPassword(passwordEncoder.encode(validUser.getPassword()));
        userRepository.save(validUser);

        // Then try to login with Basic Auth
        String credentials = validUser.getUsername() + ":password123";
        String base64Credentials = Base64Utils.encodeToString(credentials.getBytes());

        mockMvc.perform(get("/auth/login")
                .header("Authorization", "Basic " + base64Credentials))
                .andExpect(status().isOk());
    }
}
