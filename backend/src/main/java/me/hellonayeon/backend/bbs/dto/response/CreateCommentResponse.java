package me.hellonayeon.backend.bbs.dto.response;

public class CreateCommentResponse {

    private Integer seq;

    public CreateCommentResponse(Integer seq) {
        this.seq = seq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
