package com.ziglu.newsfeed.persistence;

import com.ziglu.newsfeed.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Page<Article> findByCategoriesAndProvider(String category, String[] providers, Pageable pageable);

    @Query(value = "Select a " +
            "From article a " +
            "LEFT JOIN article_categories ca " +
            "ON :category = ca.categories" +
            "AND :providers in a.provider", nativeQuery = true)
    List<Article> findCategoriesWithFilters(
        @Param("category") String category,
        @Param("providers") String[] providers
    );

    @Query(value = "Select DISTINCT a.provider " +
            "From article a " +
            "LEFT JOIN article_categories ca " +
            "ON :category = ca.categories" +
            "AND :providers in a.provider", nativeQuery = true)
    List<String> findProvidersWithFilters(
        @Param("category") String category,
        @Param("providers") String[] providers
    );
}