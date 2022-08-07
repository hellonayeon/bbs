package me.hellonayeon.backend.comment.dto.response;

import java.util.List;
import me.hellonayeon.backend.comment.domain.Comment;

public class CommentResponse {

    private List<Comment> commentList;
    private Integer pageCnt;

    public CommentResponse(List<Comment> commentList, Integer pageCnt) {
        this.commentList = commentList;
        this.pageCnt = pageCnt;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(Integer pageCnt) {
        this.pageCnt = pageCnt;
    }
}
