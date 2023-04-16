package com.oreilly.restclient.services;

import com.oreilly.restclient.entities.Site;
import com.oreilly.restclient.json.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeocoderService {

    //attribute
    private WebClient client;
    private static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";


    //constructor
    GeocoderService(WebClient.Builder builder){
        builder.baseUrl("https://maps.googleapis.com");
        client=builder.build();
    }

    //method
    public Site getLatLng(String... address) {
        String encoded = Stream.of(address)
                .map(component -> URLEncoder.encode(component, StandardCharsets.UTF_8))
                .collect(Collectors.joining(","));
        String path = "/maps/api/geocode/json";
        Response response = client.get()
                .uri(uriBuilder ->
                        uriBuilder.path(path)
                                .queryParam("address", encoded)
                                .queryParam("key", KEY)
                                .build())
                .retrieve()
                .bodyToMono(Response.class)
                .block(Duration.ofSeconds(2));
        return new Site(response.getFormattedAddress(),
                response.getLocation().getLat(),
                response.getLocation().getLng());
    }
}
