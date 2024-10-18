package com.example.jokesapi.controller;

import com.example.jokesapi.model.Joke;
import com.example.jokesapi.service.JokeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest(JokeController.class)
public class JokeControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private JokeService jokeService;

    @Test
    public void shouldReturnListOfJokes() {
        when(jokeService.getJokes(3)).thenReturn(Flux.just(
                new Joke("1", "Question 1", "Answer 1"),
                new Joke("2", "Question 2", "Answer 2"),
                new Joke("3", "Question 3", "Answer 3")
        ));

        webTestClient.get().uri("/jokes?count=3")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].id").isEqualTo("1")
                .jsonPath("$[1].id").isEqualTo("2")
                .jsonPath("$[2].id").isEqualTo("3");
    }
}
