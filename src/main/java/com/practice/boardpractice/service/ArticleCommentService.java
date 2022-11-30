package com.practice.boardpractice.service;

import com.practice.boardpractice.dto.ArticleCommentDto;
import com.practice.boardpractice.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(long articleId) {
        return List.of();
    }

    public void saveArticleComment(final ArticleCommentDto dto) {
    }
}
