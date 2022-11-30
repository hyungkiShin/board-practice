package com.practice.boardpractice.service;

import com.practice.boardpractice.domain.type.SearchType;
import com.practice.boardpractice.dto.ArticleDto;
import com.practice.boardpractice.dto.ArticleUpdateDto;
import com.practice.boardpractice.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(final SearchType title, final String search_keyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(final long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {

    }

    public void updateArticle(final long articleId, final ArticleUpdateDto dto) {
    }

    public void deleteArticle(final long articleId) {
    }
}
