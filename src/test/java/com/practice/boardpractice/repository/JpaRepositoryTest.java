package com.practice.boardpractice.repository;

import com.practice.boardpractice.config.JpaConfig;
import com.practice.boardpractice.domain.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



@ActiveProfiles("testdb")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("Jpa 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;

    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired final ArticleRepository articleRepository,
                             @Autowired final ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }
    
    @Test
    @DisplayName("select 테스트")
    void givenTestData_whenSelecting_thenWorksFine() {
        // given
        // when
        List<Article> articles = articleRepository.findAll();
        // then
        assertThat(articles).isNotNull().hasSize(123);
    }

    @Test
    @DisplayName("insert 테스트")
    void givenTestData_whenInserting_thenWorkFine() {
        // given
        long previousCount = articleRepository.count();
        final Article article = Article.of("new article", "new content", "#spring");
        // when
        final Article savedArticle = articleRepository.save(article);
        // then
        assertThat(articleRepository.count()).isEqualTo(previousCount  + 1);
    }

    @Test
    @DisplayName("update 테스트")
    void update_테스트() {
        // given
        final Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashTag = "#springboot";
        article.setHashtag(updatedHashTag);

        // when
        Article savedArticle = articleRepository.saveAndFlush(article);
//        articleRepository.flush();

        // then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashTag);
    }

    @Test
    @DisplayName("delete 테스트")
    void delete_테스트() {
        // given
        final Article article = articleRepository.findById(1L).orElseThrow();

        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentsSize = article.getArticleComments().size();

        // when
        articleRepository.delete(article);

        // then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentsSize);

    }
}