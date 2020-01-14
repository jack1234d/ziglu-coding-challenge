package com.ziglu.newsfeed.models;

public final class NewsFeedWrapperBuilder {
    private NewsFeed newsFeed;
    private Integer numberOfElements;
    private Integer numberOfPages;

    private NewsFeedWrapperBuilder() {
    }

    public static NewsFeedWrapperBuilder aNewsFeedWrapper() {
        return new NewsFeedWrapperBuilder();
    }

    public NewsFeedWrapperBuilder withNewsFeed(NewsFeed newsFeed) {
        this.newsFeed = newsFeed;
        return this;
    }

    public NewsFeedWrapperBuilder withNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
        return this;
    }

    public NewsFeedWrapperBuilder withNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public NewsFeedWrapper build() {
        NewsFeedWrapper newsFeedWrapper = new NewsFeedWrapper();
        newsFeedWrapper.setNewsFeed(newsFeed);
        newsFeedWrapper.setNumberOfElements(numberOfElements);
        newsFeedWrapper.setNumberOfPages(numberOfPages);
        return newsFeedWrapper;
    }
}
