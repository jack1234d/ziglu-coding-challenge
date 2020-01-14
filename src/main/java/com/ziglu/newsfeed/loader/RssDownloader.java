package com.ziglu.newsfeed.loader;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.ziglu.newsfeed.converters.RomeSyndToArticleTransformer;
import com.ziglu.newsfeed.models.Article;
import com.ziglu.newsfeed.models.InputFeed;
import com.ziglu.newsfeed.models.InputFeedBuilder;
import com.ziglu.newsfeed.models.NewsProvider;

import java.net.URL;

public class RssDownloader implements FeedLoadable {
    private RssDownloader() {
    }

    public static RssDownloader createRssLoader() {
        return new RssDownloader();
    }

    @Override
    public InputFeed loadFeed(NewsProvider provider) {
        try {
            SyndFeed rssFeed = new SyndFeedInput().build(new XmlReader(new URL(provider.getUrl())));
            return transformFeed(rssFeed, provider);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load RSS for provider" + provider);
        }
    }

    private InputFeed transformFeed(SyndFeed rssFeed, NewsProvider provider) {
        Article[] articles = rssFeed.getEntries()
                .stream()
                .map(RomeSyndToArticleTransformer.convertToArticle)
                .map(article -> article.withProvider(provider.getName()))
                .toArray(Article[]::new);
        return InputFeedBuilder.anInputFeed()
                .withArticles(articles)
                .build();
    }
}
