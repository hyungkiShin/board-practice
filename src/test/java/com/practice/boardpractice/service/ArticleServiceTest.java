package com.practice.boardpractice.service;

import com.practice.boardpractice.domain.Article;
import com.practice.boardpractice.domain.type.SearchType;
import com.practice.boardpractice.dto.ArticleDto;
import com.practice.boardpractice.dto.ArticleUpdateDto;
import com.practice.boardpractice.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.doNothing;

@DisplayName("비즈니스 로직 테스트 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void test() {
        // given

        // when
//        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그
//        // then
//        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void 게시글을_조회하면_게시글을_반환한다() {
        // given

        // when
        ArticleDto article = sut.searchArticle(1L);
        // then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void 게시글을_조회하면_게시글을_반환한다2() {
        // given

        // when
        Page<ArticleDto> article = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그
        // then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void 게시글_정보를_입력하면_게시글을_생성한다() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        // when
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(), "Shin", "title", "content", "#hashTag");
        sut.saveArticle(dto);
        // then
        then(articleRepository).should().save(any(Article.class));
    }


    @DisplayName("게시글 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void 게시글_정보를_입력하면_게시글을_수정한다() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        // when
        ArticleUpdateDto dto = ArticleUpdateDto.of("title", "content", "#hashTag");
        sut.updateArticle(1L, dto);
        // then
        then(articleRepository).should().save(any(Article.class));
    }


    @DisplayName("게시글 ID 를 입력하면, 게시글을 삭제한다.")
    @Test
    void 게시글_정보를_입력하면_게시글을_삭제한() {
        // given
        willDoNothing().given(articleRepository).delete(any(Article.class));
        // when
        sut.deleteArticle(1L);
        // then
        then(articleRepository).should().delete(any(Article.class));
    }
}