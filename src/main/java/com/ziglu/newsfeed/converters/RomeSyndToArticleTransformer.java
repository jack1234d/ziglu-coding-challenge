package com.ziglu.newsfeed.converters;

import com.rometools.rome.feed.synd.SyndEntry;
import com.ziglu.newsfeed.models.Article;
import com.ziglu.newsfeed.models.ArticleBuilder;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class RomeSyndToArticleTransformer {

    private static Set<String> getCategories(SyndEntry syndEntry) {
        if (null == syndEntry.getCategories()) {
            return null;
        } else {
            Set<String> categories = syndEntry.getCategories()
                    .stream()
                    .map(category -> category.getName())
                    .collect(Collectors.toSet());
            return categories;
        }

    }

    public static Function<SyndEntry, Article> convertToArticle = syndEntry -> ArticleBuilder.anArticle()
            .withCategories(getCategories(syndEntry))
            .withPublicationDate(syndEntry.getPublishedDate())
            .withUrl(syndEntry.getLink())
            .withSummary(syndEntry.getDescription().getValue())
            .build();
}
