package com.ziglu.newsfeed.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ziglu.newsfeed.config.NewsProviderConfig;
import com.ziglu.newsfeed.models.NewsProvider;
import com.ziglu.newsfeed.persistence.ArticleRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CacheNewsFeedTest {

    @InjectMocks
    private CacheNewsFeed sut;

    @Mock
    private NewsProviderConfig config;

    @Mock
    private ArticleRepository articleRepository;

    public void setUp(){
        config = mock(NewsProviderConfig.class);
        articleRepository = mock(ArticleRepository.class);
        sut = new CacheNewsFeed(config, articleRepository);
    }

    void loadForAllNewsProviders() throws JsonProcessingException {
        setUp();
        NewsProvider[] providers = generateNewsProvider();
        when(config.getProviders()).thenReturn(providers);
        sut = new CacheNewsFeed(config, articleRepository);
        sut.loadForAllNewsProviders();

        ObjectMapper mapper = new ObjectMapper();

        // System.out.println(mapper.writeValueAsString(feed));
    }

    private NewsProvider[] generateNewsProvider() {
        ArrayList<NewsProvider> list = new ArrayList<>();
        list.add(new NewsProvider("BBC", "http://feeds.bbci.co.uk/news/uk/rss.xml"));
        list.add(new NewsProvider("BBC News Technology", "http://feeds.bbci.co.uk/news/technology/rss.xml"));
        list.add(new NewsProvider("Reuters UK", "http://feeds.reuters.com/reuters/UKdomesticNews?format=xml"));
        list.add(new NewsProvider("Reuters Technology", "http://feeds.reuters.com/reuters/technologyNews?format=xml"));
        return list.toArray(new NewsProvider[list.size()]);
    }
}