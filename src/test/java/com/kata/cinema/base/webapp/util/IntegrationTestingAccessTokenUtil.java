package com.kata.cinema.base.webapp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.kata.cinema.base.models.dto.request.AuthDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IntegrationTestingAccessTokenUtil {


    public static String obtainNewAccessToken(final String username, final String password, MockMvc mockMvc) throws Exception {
        AuthDto user = new AuthDto();
        user.setUsername(username);
        user.setPassword(password);

        ObjectMapper objectMapper = new ObjectMapper();
        return JsonPath.read(mockMvc.perform(
                        post("/token")
                                .content(objectMapper.writeValueAsString(user))
                                .contentType(MediaType.APPLICATION_JSON)
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString(), "$.token");
    }

}
