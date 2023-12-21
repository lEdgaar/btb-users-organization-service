package com.btb.usersorganizationservice.client;

import com.btb.usersorganizationservice.dto.request.GetTokenDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@Component
public class SecurityServiceClient {

    private static final String API_URL = "http://localhost:9000/auth";
    private static final String TOKEN_ENDPOINT = API_URL + "/token";
    private static final String API_KEY = "A7243431-AD97-4392-A244-A16702429927";

    public String getToken(GetTokenDTO getTokenDTO) {
        String requestBody = convertObjectToJson(getTokenDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("BTB-API-KEY", API_KEY);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(entity, String.class);
        ResponseExtractor<ResponseEntity<String>> responseExtractor = restTemplate.responseEntityExtractor(String.class);
        ResponseEntity<String> response;

        try {
            response = restTemplate.execute(new URI(TOKEN_ENDPOINT), HttpMethod.POST, requestCallback, responseExtractor);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return response.getBody();
    }

    private static String convertObjectToJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir el objeto a JSON", e);
        }
    }


}
