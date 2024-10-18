package com.example.jokesapi.model;

import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Joke {

    @Id
    private String id;
    @JsonProperty("setup")
    private String question;
    @JsonProperty("punchline")
    private String answer;

    public Joke(String id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
