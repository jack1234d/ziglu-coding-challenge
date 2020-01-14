package com.ziglu.newsfeed.models;

import java.util.Date;
import java.util.Set;

public final class ArticleBuilder {
    private String url;
    private String summary;
    private Set<String> categories;
    private Date publicationDate;
    private String provider;

    private ArticleBuilder() {
    }

    public static ArticleBuilder anArticle() {
        return new ArticleBuilder();
    }

    public ArticleBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public ArticleBuilder withCategories(Set<String> categories) {
        this.categories = categories;
        return this;
    }

    public ArticleBuilder withPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public ArticleBuilder withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public ArticleBuilder withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public Article build() {
        Article article = new Article();
        article.setUrl(url);
        article.setCategories(categories);
        article.setPublicationDate(publicationDate);
        article.setSummary(summary);
        article.setProvider(provider);
        return article;
    }
}
