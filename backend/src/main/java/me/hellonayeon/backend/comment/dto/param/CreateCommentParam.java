package me.hellonayeon.backend.comment.dto.param;

import me.hellonayeon.backend.bbs.dto.request.CreateCommentRequest;

public class CreateCommentParam {

    private Integer bbsSeq;
    private Integer seq;
    private String id;
    private String content;

    public CreateCommentParam(Integer bbsSeq, CreateCommentRequest req) {
        this.bbsSeq = bbsSeq;
        this.id = req.getId();
        this.content = req.getContent();
    }

    public Integer getBbsSeq() {
        return bbsSeq;
    }

    public void setBbsSeq(Integer bbsSeq) {
        this.bbsSeq = bbsSeq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
