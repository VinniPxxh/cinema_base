package com.kata.cinema.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("IT")
public abstract class AbstractIT {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    public static final String NEWS_REST_CONTROLLER_INIT_SQL = "classpath:data/controller.publicist.sql/publicistNewsRestControllerInit.sql";
    public static final String NEWS_REST_CONTROLLER_CLEAR_SQL = "classpath:data/controller.publicist.sql/publicistNewsRestControllerClear.sql";
    public static final String MOVIE_REST_CONTROLLER_INIT_SQL = "classpath:data/sql/controller/MovieRestControllerInit.sql";
    public static final String MOVIE_REST_CONTROLLER_CLEAR_SQL = "classpath:data/sql/controller/MovieRestControllerClear.sql";

}
