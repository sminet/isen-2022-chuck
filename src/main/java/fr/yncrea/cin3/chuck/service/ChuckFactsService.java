package fr.yncrea.cin3.chuck.service;

import fr.yncrea.cin3.chuck.model.dto.ChuckFactsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChuckFactsService {
    private final RestTemplate restTemplate;

    public ChuckFactsService(RestTemplateBuilder builder) {
        restTemplate = builder.rootUri("https://api.chucknorris.io")
                .build();
    }

    public ChuckFactsResponse getJokeById(String id) {
        return restTemplate
                .getForObject("/jokes/" + id, ChuckFactsResponse.class);
    }

    public ChuckFactsResponse getRandomJoke() {
        return restTemplate
                .getForObject("/jokes/random", ChuckFactsResponse.class);
    }
}
