package com.kata.cinema.base.webapp.controllers.publicist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.cinema.base.dao.abstracts.dto.NewsDao;
import com.kata.cinema.base.models.dto.NewsRequestDto;
import com.kata.cinema.base.models.enums.Rubric;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = "classpath:data/controller.publicist.sql/publicistNewsRestControllerInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "classpath:data/controller.publicist.sql/publicistNewsRestControllerClear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class PublicistNewsRestControllerIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    NewsDao newsDao;


    @Test
    void getNews() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNewsWithAllParameters() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&endDate=2022-08-05&rubric=NEWS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyDate() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&endDate=2022-08-05"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[1].date").value("2022-08-05"))
                .andExpect(jsonPath("$.[1].title").value("db test title 03"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyStartDate() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[1].date").value("2022-08-05"))
                .andExpect(jsonPath("$.[1].title").value("db test title 03"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyEndDate() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?endDate=2022-08-04"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-03"))
                .andExpect(jsonPath("$.[0].title").value("db test title 01"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyRubric() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?rubric=TESTS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].rubric").value("TESTS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-05"))
                .andExpect(jsonPath("$.[0].title").value("db test title 03"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyStartDateAndRubric() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?startDate=2022-08-04&rubric=NEWS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[0].title").value("db test title 02"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"));
    }

    @Test
    public void getNewsWithOnlyEndDateAndRubric() throws Exception {
        this.mockMvc.perform(get("/api/publicist/news?endDate=2022-08-05&rubric=NEWS"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[0].date").value("2022-08-03"))
                .andExpect(jsonPath("$.[0].title").value("db test title 01"))
                .andExpect(jsonPath("$.[0].description").value("nytipobody"))
                .andExpect(jsonPath("$.[1].rubric").value("NEWS"))
                .andExpect(jsonPath("$.[1].date").value("2022-08-04"))
                .andExpect(jsonPath("$.[1].title").value("db test title 02"))
                .andExpect(jsonPath("$.[1].description").value("nytipobody"));
    }

    @Test
    void createNews() throws Exception {
        NewsRequestDto newsRequestDto = new NewsRequestDto(Rubric.NEWS, "TipoTitleTest", "TipoHtmlTest");
        this.mockMvc.perform(post("/api/publicist/news")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(newsRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}