package me.hellonayeon.backend.comment.dao;

import java.util.List;
import me.hellonayeon.backend.comment.domain.Comment;
import me.hellonayeon.backend.comment.dto.param.CommentListParam;
import me.hellonayeon.backend.comment.dto.param.CreateCommentParam;
import me.hellonayeon.backend.comment.dto.param.UpdateCommentParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentDao {

    List<Comment> getCommentPageList(CommentListParam param);
    Integer getCommentCount(Integer seq);

    void createComment(CreateCommentParam param);
    Integer deleteComment(Integer seq);

    Comment getCommentBySeq(Integer seq);
    Integer updateComment(UpdateCommentParam param);
}
