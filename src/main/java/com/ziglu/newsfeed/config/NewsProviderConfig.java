package com.ziglu.newsfeed.config;

import com.ziglu.newsfeed.models.NewsProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ziglu.rss-feed")
public class NewsProviderConfig {

    private NewsProvider[] providers;

    public NewsProvider[] getProviders() {
        return providers;
    }

    public void setProviders(HashMap<String, String> providers) {
        List<NewsProvider> newsProviderList = new ArrayList<>();
        providers.forEach((providerName, url) -> {
            String readableProvider = providerName.replace("_", " ");
            NewsProvider provider = new NewsProvider(readableProvider, url);
            newsProviderList.add(provider);
        });
        this.providers = newsProviderList.toArray(new NewsProvider[newsProviderList.size()]);
    }

}
