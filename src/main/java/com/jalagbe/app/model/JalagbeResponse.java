package com.jalagbe.app.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;

public class JalagbeResponse {
    @JsonView(Views.Public.class)
    String body;

    @JsonView(Views.Public.class)
    HttpStatus status;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
