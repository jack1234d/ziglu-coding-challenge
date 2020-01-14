package com.ziglu.newsfeed.models;

public final class InputFeedBuilder {
    private Article[] articles;

    private InputFeedBuilder() {
    }

    public static InputFeedBuilder anInputFeed() {
        return new InputFeedBuilder();
    }

    public InputFeedBuilder withArticles(Article[] articles) {
        this.articles = articles;
        return this;
    }

    public InputFeed build() {
        return new InputFeed(articles);
    }
}
