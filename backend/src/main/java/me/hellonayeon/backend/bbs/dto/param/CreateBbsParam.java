package me.hellonayeon.backend.bbs.dto.param;

import me.hellonayeon.backend.bbs.dto.request.CreateBbsRequest;

public class CreateBbsParam {

    private Integer seq;
    private String id;
    private String title;
    private String content;

    public CreateBbsParam(CreateBbsRequest req) {
        this.id = req.getId();
        this.title = req.getTitle();
        this.content = req.getContent();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
