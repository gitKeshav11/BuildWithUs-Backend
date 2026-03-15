package com.buildwithus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AIService {

    @Value("${ai.api.key:${groq.api.key:}}")
    private String apiKey;

    @Value("${ai.api.url:https://api.groq.com/openai/v1/chat/completions}")
    private String apiUrl;

    @Value("${ai.model:${groq.model:llama-3.3-70b-versatile}}")
    private String model;

    private final RestTemplate restTemplate = new RestTemplate();

    public String askAI(String message){

        if (apiKey == null || apiKey.isBlank()) {
            throw new RuntimeException("AI API key is missing. Set ai.api.key or groq.api.key in application properties.");
        }

        Map<String,Object> body = new HashMap<>();

        body.put("model", model);

        List<Map<String,String>> messages = List.of(
                Map.of("role","user","content",message)
        );

        body.put("messages", messages);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String,Object>> entity =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(apiUrl, entity, Map.class);

        Map result = response.getBody();

        List choices = (List) result.get("choices");
        Map choice = (Map) choices.get(0);
        Map messageObj = (Map) choice.get("message");

        return (String) messageObj.get("content");

    }
}
