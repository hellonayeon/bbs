package me.hellonayeon.backend.member.exception;

import org.springframework.http.HttpStatus;

public class MemberException extends RuntimeException {

    private HttpStatus status;

    public MemberException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
