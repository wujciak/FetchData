package com.jwojciak.fetchdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwojciak.fetchdata.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FetchDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(FetchDataApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    CommandLineRunner run(PostService postService) {
        return args -> postService.downloadAndSavePosts();
    }
}
