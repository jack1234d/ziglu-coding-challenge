package com.ziglu.newsfeed.models;

import java.util.List;

public class ArticleWrapper implements PaginationProvidable {

    private List<Article> articles;
    private Integer numberOfElements;
    private Integer numberOfPages;


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(final List<Article> articles) {
        this.articles = articles;
    }

    public Integer getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(final Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(final Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
