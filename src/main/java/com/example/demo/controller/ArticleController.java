package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/article")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    ResponseEntity<Article> create() {
        Article article = articleService.create();
        return ResponseEntity.ok(article);
    }

    @GetMapping("/author/{authorName}")
    ResponseEntity<List<Article>> getByAuthor(@PathVariable String authorName) {
        List<Article> articles = articleService.getArticleByAuthor(authorName);
        return ResponseEntity.ok(articles);
    }
}
