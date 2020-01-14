package com.ziglu.newsfeed.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class InputFeed {

    private Article[] articles;

    public InputFeed(Article[] articles) {
        this.articles = articles;
    }

    public Article[] getArticles() {
        return articles;
    }

}
