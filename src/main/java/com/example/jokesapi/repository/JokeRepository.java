package com.example.jokesapi.repository;

import com.example.jokesapi.model.Joke;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface JokeRepository extends ReactiveCrudRepository<Joke, String> {
}
