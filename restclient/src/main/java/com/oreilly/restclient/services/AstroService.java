package com.oreilly.restclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oreilly.restclient.json.AstroResponse;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@Service
public class AstroService {

    //attribute
    private WebClient client;

    //constructor
    @Autowired
    public AstroService(WebClient.Builder builder){
        builder.baseUrl("http://api.open-notify.org");
        client=builder.build();
    }

    //method
    public AstroResponse getAstroResponse(){
        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/astros.json").build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResponse.class)
                .block(Duration.ofSeconds(2));
    }
}
