package com.example.form;

import lombok.*;

/**
 * 記事を表すフォーム.
 *
 * @author takumi kitamura
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleForm {
    /**
     * 投稿者の名前
     */
    private String name;
    /**
     * 投稿内容
     */
    private String content;
}
