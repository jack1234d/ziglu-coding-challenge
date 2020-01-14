package com.ziglu.newsfeed.models;

import java.util.List;
import java.util.Set;

public final class NewsFeedBuilder {
    private List<String> providers;
    private Set<String> categories;
    private List<Article> articles;

    private NewsFeedBuilder() {
    }

    public static NewsFeedBuilder aNewsFeed() {
        return new NewsFeedBuilder();
    }

    public NewsFeedBuilder withProviders(List<String> providers) {
        this.providers = providers;
        return this;
    }

    public NewsFeedBuilder withArticles(List<Article> articles) {
        this.articles = articles;
        return this;
    }

    public NewsFeedBuilder withCategories(Set<String> categories) {
        this.categories = categories;
        return this;
    }

    public NewsFeed build() {
        NewsFeed newsFeed = new NewsFeed();
        newsFeed.setProviders(providers);
        newsFeed.setArticles(articles);
        newsFeed.setCategories(categories);
        return newsFeed;
    }
}
