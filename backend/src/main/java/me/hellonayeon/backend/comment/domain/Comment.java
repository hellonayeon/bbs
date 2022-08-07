package me.hellonayeon.backend.comment.domain;

public class Comment {

    private Integer seq; // 댓글 고유 번호
    private String id; // 댓글 작성자
    private String content; // 댓글 내용
    private Integer bbsSeq; // 게시글 번호
    private String createdAt; // 댓글 생성 일자
    private Integer del; // 삭제 여부

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

    public Integer getBbsSeq() {
        return bbsSeq;
    }

    public void setBbsSeq(Integer bbsSeq) {
        this.bbsSeq = bbsSeq;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
