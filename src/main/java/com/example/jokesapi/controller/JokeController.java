package com.example.jokesapi.controller;

import com.example.jokesapi.model.Joke;
import com.example.jokesapi.service.JokeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping
    public Flux<Joke> getJokes(@RequestParam int count) {
        return jokeService.getJokes(count);
    }
}
