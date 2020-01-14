package com.ziglu.newsfeed.models;

public class NewsProvider {
    private String name;

    public NewsProvider(final String name, final String url) {
        this.name = name;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    private String url;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
