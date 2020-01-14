package com.ziglu.newsfeed.controller;

import com.ziglu.newsfeed.models.Article;
import com.ziglu.newsfeed.models.ArticleWrapper;
import com.ziglu.newsfeed.models.NewsFeed;
import com.ziglu.newsfeed.models.NewsFeedWrapper;
import com.ziglu.newsfeed.service.RetrieveFeedService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class NewsFeedController {

    private RetrieveFeedService service;

    public NewsFeedController(RetrieveFeedService service) {
        this.service = service;
    }

    private HttpHeaders getPaginationHeaders(Integer numberOfRecords, Integer numberOfPages) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-NumberOfRecords", Integer.toString(numberOfRecords));
        responseHeaders.set("X-NumberOfPages", Integer.toString(numberOfPages));
        return responseHeaders;
    }

    @RequestMapping(
            value = "/newsfeed",
            method = GET,
            produces = "application/json")
    public ResponseEntity<NewsFeed> getNewsFeed(
            @RequestParam(value="category", required = false) String filterCategory,
            @RequestParam(value="provider", required = false) String[] filterProviders,
            @RequestParam(value="page", required = false) Integer page,
            @RequestParam(value="limit", required = false) Integer limit) {
        NewsFeedWrapper newsFeed = service.getNewsFeed(filterCategory, filterProviders, page, limit);
        return ResponseEntity.ok()
                .headers(getPaginationHeaders(
                        newsFeed.getNumberOfElements(),
                        newsFeed.getNumberOfPages())
                )
                .body(newsFeed.getNewsFeed());
    }

    @RequestMapping(
            value = "/articles",
            method = GET,
            produces = "application/json")
    public ResponseEntity<List<Article>> getFilteredArticles(
            @RequestParam(value="category", required = false) String filterCategory,
            @RequestParam(value="provider", required = false) String[] filterProviders,
            @RequestParam(value="page", required = false) Integer page,
            @RequestParam(value="limit", required = false) Integer limit) {
        ArticleWrapper wrapper = service.getFilteredArticles(filterCategory, filterProviders, page, limit);
        return ResponseEntity.ok()
                .headers(getPaginationHeaders(wrapper.getNumberOfElements(), wrapper.getNumberOfPages()))
                .body(wrapper.getArticles());
    }

    @RequestMapping(
            value = "/categories",
            method = GET,
            produces = "application/json")
    public Set<String> getCategories(@RequestParam(value="category", required = false) String filterCategory,
                                     @RequestParam(value="provider", required = false) String[] filterProviders) {
        return service.getCategories(filterCategory, filterProviders);
    }

    @RequestMapping(
            value = "/providers",
            method = GET,
            produces = "application/json")
    public List<String> getProviders(@RequestParam(value="category", required = false) String filterCategory,
                                     @RequestParam(value="provider", required = false) String[] filterProviders) {
        return service.getProviders(filterCategory, filterProviders);
    }
}
