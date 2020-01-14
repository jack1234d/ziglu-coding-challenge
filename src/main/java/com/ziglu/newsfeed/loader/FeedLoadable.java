package com.ziglu.newsfeed.loader;

import com.ziglu.newsfeed.models.InputFeed;
import com.ziglu.newsfeed.models.NewsProvider;

public interface FeedLoadable {
    InputFeed loadFeed(NewsProvider provider);
}
