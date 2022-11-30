package com.practice.boardpractice.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleCommentDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String content
) {

    public static ArticleCommentDto of(final LocalDateTime createdAt,
                                       final String createdBy,
                                       final LocalDateTime modifiedAt,
                                       final String modifiedBy,
                                       final String content) {

        return new ArticleCommentDto(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }
}
