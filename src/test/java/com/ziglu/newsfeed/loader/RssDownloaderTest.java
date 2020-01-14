package com.ziglu.newsfeed.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rometools.rome.io.FeedException;
import com.ziglu.newsfeed.models.InputFeed;
import com.ziglu.newsfeed.models.NewsProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class RssDownloaderTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void loadRssFeed() throws IOException, FeedException {
        RssDownloader loader = RssDownloader.createRssLoader();
        NewsProvider provider = new NewsProvider(
            "Stack Overflow",
            "https://stackexchange.com/feeds/tagsets/21857/meta-rss?sort=active"
        );
        InputFeed feed = loader.loadFeed(provider);
        System.out.println(mapper.writeValueAsString(feed));
        Arrays.stream(feed.getArticles())
            .forEach(article ->
                    System.out.println(article.getCategories().toString()));
    }
}
