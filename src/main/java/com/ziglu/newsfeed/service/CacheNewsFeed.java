package com.ziglu.newsfeed.service;

import com.ziglu.newsfeed.config.NewsProviderConfig;
import com.ziglu.newsfeed.loader.FeedLoadable;
import com.ziglu.newsfeed.loader.RssDownloader;
import com.ziglu.newsfeed.models.InputFeed;
import com.ziglu.newsfeed.models.NewsProvider;
import com.ziglu.newsfeed.persistence.ArticleRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class CacheNewsFeed {

    private final Logger logger = LogManager.getLogger(CacheNewsFeed.class);

    private NewsProviderConfig config;
    private ArticleRepository articleRepository;

    @Autowired
    public CacheNewsFeed(NewsProviderConfig config, ArticleRepository articleRepository) {
        this.config = config;
        this.articleRepository = articleRepository;
    }

    @Scheduled(fixedDelay = 60000)
    public void reloadCache() {
        try {
            logger.info("Reload cache");
            loadForAllNewsProviders();
        } catch (Exception e) {
            logger.error("Reload cache failed");
        }
    }


    @PostConstruct
    public void loadForAllNewsProviders() {
        FeedLoadable importer = RssDownloader.createRssLoader();
        NewsProvider[] providerArray = config.getProviders();
        Arrays.stream(providerArray).forEach((provider) -> {
            InputFeed feed = importer.loadFeed(provider);
            Arrays.stream(feed.getArticles())
                .forEach(article -> {
                    article.setProvider(provider.getName());
                    try {
                        articleRepository.save(article);
                    } catch (Exception e) {
                        logger.error("Article save failed");
                    }
                });
        });
        articleRepository.flush();
    }

}
