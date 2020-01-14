package com.ziglu.newsfeed.converters;

import TestModels.TestSyndCategory;
import TestModels.TestSyndContent;
import TestModels.TestSyndEntry;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.ziglu.newsfeed.models.Article;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class RomeSyndToArticleTransformerTest {

    private Date TEST_DATE = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");

    RomeSyndToArticleTransformerTest() throws ParseException {
    }

    private List<SyndCategory> getCategoriesList() {
        SyndCategory category = new TestSyndCategory();
        category.setName("Category");
        return Arrays.asList(category);
    }

    private List<SyndCategory> getMultipleCategories() {
        SyndCategory category = new TestSyndCategory();
        category.setName("Category");
        SyndCategory category2 = new TestSyndCategory();
        category2.setName("Category2");
        return Arrays.asList(category, category2);
    }

    private SyndContent getContent() {
        SyndContent content = new TestSyndContent();
        content.setValue("Content");
        return content;
    }

    private SyndEntry createRomeSyndEntryWithCategory() throws ParseException {
        SyndEntry entry = new TestSyndEntry();
        entry.setCategories(getCategoriesList());
        entry.setDescription(getContent());
        entry.setLink("URL");
        Date date = TEST_DATE;
        entry.setPublishedDate(date);
        return entry;
    }

    private SyndEntry createRomeSyndEntryWithCategories() {
        SyndEntry entry = new TestSyndEntry();
        entry.setCategories(getMultipleCategories());
        entry.setDescription(getContent());
        entry.setLink("URL");
        entry.setPublishedDate(TEST_DATE);
        return entry;
    }

    private SyndEntry createRomeSyndEntryWithNoCategories() {
        SyndEntry entry = new TestSyndEntry();
        entry.setDescription(getContent());
        entry.setLink("URL");
        entry.setPublishedDate(TEST_DATE);
        System.out.println(entry.getPublishedDate());
        return entry;
    }

    @Test
    public void checkTransformerWithCategory() throws ParseException {
        Article article = RomeSyndToArticleTransformer.convertToArticle.apply(createRomeSyndEntryWithCategory());
        assertThat(article.getCategories().size(), is(equalTo(1)));
        assertThat(article.getCategories().toArray()[0], is(equalTo("Category")));
        assertThat(article.getUrl(), is(equalTo("URL")));
        assertThat(article.getPublicationDate(), is(equalTo(TEST_DATE)));
        assertThat(article.getSummary(), is(equalTo("Content")));
    }

    @Test
    public void checkTransformerWithMultipleCategories() {
        Article article = RomeSyndToArticleTransformer.convertToArticle.apply(createRomeSyndEntryWithCategories());
        assertThat(article.getCategories().size(), is(equalTo(2)));
        assertThat(article.getCategories().toArray()[1], is(equalTo("Category2")));
        assertThat(article.getCategories().toArray()[0], is(equalTo("Category")));
        assertThat(article.getUrl(), is(equalTo("URL")));
        assertThat(article.getPublicationDate(), is(equalTo(TEST_DATE)));
        assertThat(article.getSummary(), is(equalTo("Content")));
    }

    @Test
    public void checkTransformerWithNoCategories() {
        Article article = RomeSyndToArticleTransformer.convertToArticle.apply(createRomeSyndEntryWithNoCategories());
        assertThat(article.getCategories(), is(IsNull.nullValue()));
        assertThat(article.getUrl(), is(equalTo("URL")));
        assertThat(article.getPublicationDate(), is(equalTo(TEST_DATE)));
        assertThat(article.getSummary(), is(equalTo("Content")));
    }

}