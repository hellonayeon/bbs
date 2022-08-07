package me.hellonayeon.backend.member.dto.param;

import me.hellonayeon.backend.member.dto.request.JoinRequest;

public class CreateMemberParam {

    private String id;
    private String name;
    private String pwd;
    private String email;

    public CreateMemberParam(JoinRequest req, String encodedPwd) {
        this.id = req.getId();
        this.name = req.getName();
        this.email = req.getEmail();
        this.pwd = encodedPwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
