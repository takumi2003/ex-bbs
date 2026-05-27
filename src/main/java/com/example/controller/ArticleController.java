package com.example.controller;

import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.repository.ArticleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 記事に関するコントローラ.
 *
 * @author takumi kitamura
 */
@Controller
@RequestMapping("/bbs")
public class ArticleController {
    @Autowired
    private ArticleRepository repository;

    @GetMapping("")
    public String index(ArticleForm articleForm, Model model) {
        List<Article> articles = repository.findAll();
        System.out.println("記事一覧:" + articles);
        model.addAttribute("articles", articles);
        return "/index";
    }

    @PostMapping("/article_post")
    public String articlePost(ArticleForm articleForm) {
        Article article = new Article();
        BeanUtils.copyProperties(articleForm, article);

        repository.insert(article);
        return "redirect:/bbs";
    }
}
