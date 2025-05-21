package com.jwojciak.fetchdata.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonUtils {
    @Value("${post.save.dir}")
    private String saveDir;
    private final ObjectMapper mapper;

    public JsonUtils(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void saveJsonToFile(Object json, String fileName) throws IOException {
        File file = new File(saveDir + fileName);
        file.getParentFile().mkdirs();
        mapper.writeValue(file, json);
    }
}
