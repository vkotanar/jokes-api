package com.example.jokesapi.service;

import com.example.jokesapi.model.Joke;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

public class JokeServiceTest {

    @Test
    public void shouldReturnJokesWithCorrectCount() {
        JokeService jokeService = Mockito.mock(JokeService.class);
        when(jokeService.getJokes(3)).thenReturn(Flux.just(
                new Joke("1", "Question 1", "Answer 1"),
                new Joke("2", "Question 2", "Answer 2"),
                new Joke("3", "Question 3", "Answer 3")
        ));

        Flux<Joke> jokes = jokeService.getJokes(3);

        StepVerifier.create(jokes)
                .expectNextMatches(joke -> joke.getId().equals("1"))
                .expectNextMatches(joke -> joke.getId().equals("2"))
                .expectNextMatches(joke -> joke.getId().equals("3"))
                .verifyComplete();
    }
}
