package com.ziglu.newsfeed.models;

import java.util.List;
import java.util.Set;

public class NewsFeed {

    private List<String> providers;
    private List<Article> articles;
    private Set<String> categories;

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setCategories(Set<String> categories) { this.categories = categories; };

    public Set<String> getCategories() { return categories; }
}
