package com.jwojciak.fetchdata.service;

import com.jwojciak.fetchdata.model.Post;
import com.jwojciak.fetchdata.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class PostService {
    @Value("${post.api.url}")
    private String JSON_POST_URL;
    private final RestTemplate restTemplate;
    private final JsonUtils jsonUtils;

    public PostService(RestTemplate restTemplate, JsonUtils jsonUtils) {
        this.restTemplate = restTemplate;
        this.jsonUtils = jsonUtils;
    }

    public void downloadAndSavePosts() {
        Post[] posts = restTemplate.getForObject(JSON_POST_URL, Post[].class);
        if (posts != null) {
            for (Post post : posts) {
                if (post.getId() != null && post.getTitle() != null) {
                    try {
                        jsonUtils.saveJsonToFile(post, post.getId() + ".json");
                        System.out.println("Post " + post.getId() + " saved");
                    } catch (IOException e) {
                        System.err.println("Error saving post " + post.getId() + ": " + e.getMessage());
                    }
                }
            }
        }
    }
}
