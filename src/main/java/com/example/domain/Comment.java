package com.example.domain;

import lombok.*;

/**
 * コメントを表すドメイン.
 *
 * @author takumi kitamura
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    /**
     * id
     */
    private Integer id;
    /**
     * コメントした人の名前
     */
    private String name;
    /**
     * コメントの内容
     */
    private String content;
    /**
     * 記事id
     */
    private Integer articleId;
}
