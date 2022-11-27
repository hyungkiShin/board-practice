package com.practice.boardpractice.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class) // @WebMvcTest 는 @Controller, @ControllerAdvice, @JsonComponent, Filter, WebMvcConfigurer 를 스캔한다.
class ArticleControllerTest {

    private final MockMvc mvc;

    // TEST package 에 있는 친구들은 @Autowired 를 직접 명시 해줘야 한다.
    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }
    
    @Test
    @DisplayName("[view] [GET] 게시글 리스트 (게시판) 페이지 -  정상 호출")
    void 게시글_리스트_페이지_정상_호출() throws Exception {
        // given

        // when then
        mvc.perform(get("/articles")) // GET 요청
                .andExpect(status().isOk()) // 200
                .andExpect(content().contentType(MediaType.TEXT_HTML)) // 응답 타입이 HTML 이다.
                .andExpect(model().attributeExists("articles")); // model 에 articles 가 있는지 확인
    }

    @Test
    @DisplayName("[view] [GET] 게시글 리스트 (상세) 페이지 -  정상 호출")
    void 게시글_리스트_상세_페이지_정상_호출() throws Exception {
        // given

        // when then
        mvc.perform(get("/articles/1")) // GET 요청
                .andExpect(status().isOk()) // 200
                .andExpect(content().contentType(MediaType.TEXT_HTML)) // 응답 타입이 HTML 이다.
                .andExpect(model().attributeExists("articles")); // model 에 articles 가 있는지 확인
    }

    @Test
    @DisplayName("[view] [GET] 게시글 리스트 (검색) 페이지 -  정상 호출")
    void 게시글_리스트_검색_페이지_정상_호출() throws Exception {
        // given

        // when then
        mvc.perform(get("/articles/search")) // GET 요청
                .andExpect(status().isOk()) // 200
                .andExpect(content().contentType(MediaType.TEXT_HTML)); // 응답 타입이 HTML 이다.
    }

    @Test
    @DisplayName("[view] [GET] 게시글 해시태그 (검색) 페이지 -  정상 호출")
    void 게시글_해시태그_검색_페이지_정상_호출() throws Exception {
        // given

        // when then
        mvc.perform(get("/articles/search-hashtag")) // GET 요청
                .andExpect(status().isOk()) // 200
                .andExpect(content().contentType(MediaType.TEXT_HTML)); // 응답 타입이 HTML 이다.
    }
}