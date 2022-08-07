package me.hellonayeon.backend.member.dto.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String pwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
