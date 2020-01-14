package com.ziglu.newsfeed.models;

import java.util.List;

public final class ArticleWrapperBuilder {
    private List<Article> articles;
    private Integer numberOfElements;
    private Integer numberOfPages;

    private ArticleWrapperBuilder() {
    }

    public static ArticleWrapperBuilder aPaginationWrapper() {
        return new ArticleWrapperBuilder();
    }

    public ArticleWrapperBuilder withArticles(List<Article> articles) {
        this.articles = articles;
        return this;
    }

    public ArticleWrapperBuilder withNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
        return this;
    }

    public ArticleWrapperBuilder withNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public ArticleWrapper build() {
        ArticleWrapper articleWrapper = new ArticleWrapper();
        articleWrapper.setArticles(articles);
        articleWrapper.setNumberOfElements(numberOfElements);
        articleWrapper.setNumberOfPages(numberOfPages);
        return articleWrapper;
    }
}
