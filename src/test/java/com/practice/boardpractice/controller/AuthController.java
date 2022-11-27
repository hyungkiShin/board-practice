package com.practice.boardpractice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@DisplayName("View 컨트롤러 - 인증")
@WebMvcTest
 class AuthController {

    private final MockMvc mvc;

    public AuthController(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    @DisplayName("[view] [GET] 로그인 페이지 -  정상 호출")
    void 로그인_페이지_테스트() throws Exception {
        // given

        // when then
        mvc.perform(get("/login")) // GET 요청
                .andExpect(status().isOk()) // 200
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)); // 응답 타입이 HTML 이다.
    }
}
