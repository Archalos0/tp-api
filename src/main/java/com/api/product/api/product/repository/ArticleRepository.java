package com.api.product.api.product.repository;

import com.api.product.api.product.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
