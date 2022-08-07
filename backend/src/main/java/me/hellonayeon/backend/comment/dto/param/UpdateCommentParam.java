package me.hellonayeon.backend.comment.dto.param;

public class UpdateCommentParam {

    private Integer seq;
    private String content;

    public UpdateCommentParam(Integer seq, String content) {
        this.seq = seq;
        this.content = content;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
