package me.hellonayeon.backend.comment.dto.request;

public class CommentRequest {

    private Integer bbsSeq;
    private Integer page;

    public Integer getBbsSeq() {
        return bbsSeq;
    }

    public void setBbsSeq(Integer bbsSeq) {
        this.bbsSeq = bbsSeq;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
