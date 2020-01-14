package com.ziglu.newsfeed.service;

import com.ziglu.newsfeed.models.Article;
import com.ziglu.newsfeed.models.ArticleWrapper;
import com.ziglu.newsfeed.models.ArticleWrapperBuilder;
import com.ziglu.newsfeed.models.NewsFeed;
import com.ziglu.newsfeed.models.NewsFeedBuilder;
import com.ziglu.newsfeed.models.NewsFeedWrapper;
import com.ziglu.newsfeed.models.NewsFeedWrapperBuilder;
import com.ziglu.newsfeed.persistence.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RetrieveFeedService {

    private Integer DEFAULT_PAGE = 0;
    // Make configuration
    private Integer DEFAULT_LIMIT = 10;
    private ArticleRepository articleRepository;


    @Autowired
    public RetrieveFeedService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public NewsFeedWrapper getNewsFeed(String filterCategory, String[] filterProviders, Integer page,
                                       Integer limit) {
        Integer pageNumber = (null == page) ? DEFAULT_PAGE : page;
        Integer limitNumber = (null == limit) ? DEFAULT_LIMIT : limit;
        ArticleWrapper articleWrapper = getFilteredArticles(
                filterCategory,
                filterProviders,
                pageNumber,
                limitNumber
        );
        NewsFeed feed = NewsFeedBuilder.aNewsFeed()
                .withArticles(articleWrapper.getArticles())
                .withCategories(getCategories(filterCategory, filterProviders))
                .withProviders(getProviders(filterCategory, filterProviders))
                .build();
        return NewsFeedWrapperBuilder.aNewsFeedWrapper()
                .withNewsFeed(feed)
                .withNumberOfElements(articleWrapper.getNumberOfElements())
                .withNumberOfPages(articleWrapper.getNumberOfPages())
                .build();
    }



    public ArticleWrapper getFilteredArticles(String filterCategory,
                                              String[] filterProviders,
                                              Integer page,
                                              Integer limit) {
        Pageable pagination = PageRequest.of(page, limit, Sort.by("publicationDate"));

        Page<Article> articles = articleRepository.findByCategoriesAndProvider(
                filterCategory,
                filterProviders,
                pagination
        );
        return ArticleWrapperBuilder.aPaginationWrapper()
                .withArticles(articles.getContent())
                .withNumberOfElements(articles.getNumberOfElements())
                .withNumberOfPages(articles.getTotalPages())
                .build();
    }

    public Set<String> getCategories(String filterCategory,
                                     String[] filterProviders) {
        List<Article> categoryArrays = articleRepository.findCategoriesWithFilters(
            filterCategory,
            filterProviders
        );
        Set<String> categorySet = new HashSet();
        categoryArrays.forEach(categories -> {
            categorySet.addAll(categories.getCategories());
        });
        return categorySet;
    }

    public List<String> getProviders(String filterCategory,
                                     String[] filterProviders) {
        return articleRepository.findProvidersWithFilters(
            filterCategory,
            filterProviders
        );
    }



}
