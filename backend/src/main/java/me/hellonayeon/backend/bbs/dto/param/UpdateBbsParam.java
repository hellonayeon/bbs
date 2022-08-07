package me.hellonayeon.backend.bbs.dto.param;

import me.hellonayeon.backend.bbs.dto.request.UpdateBbsRequest;

public class UpdateBbsParam {

    private Integer seq;

    private String title;

    private String content;


    public UpdateBbsParam(Integer seq, UpdateBbsRequest req) {
        this.seq = seq;
        this.title = req.getTitle();
        this.content = req.getContent();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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
