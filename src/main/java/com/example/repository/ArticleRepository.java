package com.example.repository;

import com.example.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 記事に関するリポジトリ.
 *
 * @author takumi kitamura
 */
@Repository
public class ArticleRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private static final RowMapper<Article> ROW_MAPPER = new BeanPropertyRowMapper<>(Article.class);

    /**
     * 記事の全件取得を行う.
     *
     * @return 全ての記事
     */
    public List<Article> findAll() {
        String sql = """
                SELECT id, name, content
                FROM articles
                ORDER BY id DESC
                ;
                """;

        return template.query(sql, ROW_MAPPER);
    }

    /**
     * DBに記事を挿入する.
     *
     * @param article 記事
     */
    public void insert(Article article) {
        String sql = """
                INSERT INTO articles(name, content)
                VALUES(:name, :content)
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", article.getName())
                .addValue("content", article.getContent());

        template.update(sql, param);
    }

    /**
     * 指定されたidのデータを削除する.
     *
     * @param id id
     */
    public void deleteById(int id) {
        String sql = """
                DELETE FROM articles
                WHERE id = :id
                ;
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);

        template.update(sql, param);
    }
}
