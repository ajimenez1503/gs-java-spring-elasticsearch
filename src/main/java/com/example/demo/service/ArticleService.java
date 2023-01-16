package com.example.demo.service;

import com.example.demo.model.Article;
import com.example.demo.model.Author;
import com.example.demo.repo.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.client.elc.QueryBuilders;
import org.springframework.data.elasticsearch.client.erhlc.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQuery;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.data.elasticsearch.client.elc.QueryBuilders.matchQuery;

@Service
@AllArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    private final ElasticsearchRestTemplate elasticsearchTemplate;

    public Article create() {
        Article article = new Article();
        article.setTitle("Spring Data Elasticsearch");
        article.setAuthors(asList(new Author("John Smith"), new Author("John Doe")));
        articleRepository.save(article);

        return article;
    }

    public List<Article> getArticleByAuthor(String author) {
        Page<Article> articleByAuthorName
                = articleRepository.findByAuthorsName(author, PageRequest.of(0, 10));
        return articleByAuthorName.get().toList();
    }

}
