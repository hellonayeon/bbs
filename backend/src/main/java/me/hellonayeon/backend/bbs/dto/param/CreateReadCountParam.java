package me.hellonayeon.backend.bbs.dto.param;

public class CreateReadCountParam {

    private Integer bbsSeq; // 게시글 번호
    private String readerId; // 게시글 조회자 아이디

    public CreateReadCountParam(Integer bbsSeq, String readerId) {
        this.bbsSeq = bbsSeq;
        this.readerId = readerId;
    }

    public Integer getBbsSeq() {
        return bbsSeq;
    }

    public void setBbsSeq(Integer bbsSeq) {
        this.bbsSeq = bbsSeq;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }
}
