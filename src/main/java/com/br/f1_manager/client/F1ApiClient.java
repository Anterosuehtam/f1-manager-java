package com.br.f1_manager.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class F1ApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String urlBase = "https://api.jolpi.ca/ergast/f1/";

    public <T> T obterDados(String endpoint, Class<T> classe) {

        String urlCompleta = urlBase + endpoint;

        return restTemplate.getForObject(urlCompleta, classe);
    }
}
