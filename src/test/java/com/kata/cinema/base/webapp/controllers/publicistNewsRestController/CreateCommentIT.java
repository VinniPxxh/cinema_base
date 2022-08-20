package com.kata.cinema.base.webapp.controllers.publicistNewsRestController;

import com.kata.cinema.base.AbstractIT;
import com.kata.cinema.base.models.dto.request.CommentsRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;

import static com.kata.cinema.base.AbstractIT.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("IT")
@Sql(value = NEWS_COMMENTS_REST_CONTROLLER_INIT_SQL, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = NEWS_COMMENTS_REST_CONTROLLER_CLEAR_SQL, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CreateCommentIT extends AbstractIT {
    @Test
    public void createComment() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        CommentsRequestDto commentsRequestDto = new CommentsRequestDto("creating test", dateTime);
        this.mockMvc.perform(post("/api/user/news/2/comments?userId=2")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(commentsRequestDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
