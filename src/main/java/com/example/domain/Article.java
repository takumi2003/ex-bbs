package com.example.domain;

import lombok.*;

import java.util.List;

/**
 * 記事を表すドメイン.
 *
 * @author takumi kitamura
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
    /**
     * id
     */
    private Integer id;
    /**
     * 投稿者名
     */
    private String name;
    /**
     * 投稿内容
     */
    private String content;

    /**
     * 記事についたコメント
     */
    private List<Comment> commentList;
}
