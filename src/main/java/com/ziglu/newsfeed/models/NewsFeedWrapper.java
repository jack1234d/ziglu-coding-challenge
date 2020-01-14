package com.ziglu.newsfeed.models;

public class NewsFeedWrapper  implements PaginationProvidable {

    private NewsFeed newsFeed;
    private Integer numberOfElements;
    private Integer numberOfPages;

    public NewsFeed getNewsFeed() {
        return newsFeed;
    }

    public void setNewsFeed(final NewsFeed newsFeed) {
        this.newsFeed = newsFeed;
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
