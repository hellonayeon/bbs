package me.hellonayeon.backend.bbs.dto.response;

public class CreateBbsResponse {

    private Integer seq;

    public CreateBbsResponse(Integer seq) {
        this.seq = seq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
