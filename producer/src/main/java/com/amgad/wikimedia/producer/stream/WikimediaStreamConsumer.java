package com.amgad.wikimedia.producer.stream;

import com.amgad.wikimedia.producer.config.WebClientConfig;
import com.amgad.wikimedia.producer.producer.WikimediaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {
    private final WebClient webClient;
    private final WikimediaProducer wikimediaProducer;
    public WikimediaStreamConsumer(WebClient.Builder webClientBuilder,WikimediaProducer wikimediaProducer)
    {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.wikimediaProducer = wikimediaProducer;
    }
    public void consumeStreamAndPublish()
    {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikimediaProducer::sendMessage);
    }

}
