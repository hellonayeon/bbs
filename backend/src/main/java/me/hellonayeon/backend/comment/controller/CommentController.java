package me.hellonayeon.backend.comment.controller;

import java.util.Date;
import me.hellonayeon.backend.bbs.dto.request.CreateCommentRequest;
import me.hellonayeon.backend.bbs.dto.response.CreateCommentResponse;
import me.hellonayeon.backend.comment.dto.request.CommentRequest;
import me.hellonayeon.backend.comment.dto.request.UpdateCommentRequest;
import me.hellonayeon.backend.comment.dto.response.CommentResponse;
import me.hellonayeon.backend.comment.dto.response.DeleteCommentResponse;
import me.hellonayeon.backend.comment.dto.response.UpdateCommentResponse;
import me.hellonayeon.backend.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    /* [GET] /comment?bbsSeq={seq}&page={page} 댓글 조회 */
    @GetMapping
    public ResponseEntity<CommentResponse> getBbsCommentList(@ModelAttribute CommentRequest req) {
        System.out.println("CommentController getBbsCommentList " + new Date());

        return ResponseEntity.ok(service.getBbsCommentList(req));
    }

    /* [POST] /comment?bbsSeq={seq} 댓글 작성 */
    @PostMapping
    public ResponseEntity<CreateCommentResponse> createComment(@RequestParam Integer bbsSeq,
        @RequestBody CreateCommentRequest req) {
        System.out.println("CommentController createComment " + new Date());

        return ResponseEntity.ok(service.createComment(bbsSeq, req));
    }

    /* [DELETE] /comment/{seq} 댓글 삭제 */
    @DeleteMapping("/{seq}")
    public ResponseEntity<DeleteCommentResponse> deleteComment(@PathVariable Integer seq) {
        System.out.println("CommentController deleteComment " + new Date());

        return ResponseEntity.ok(service.deleteComment(seq));
    }

    /* [PATCH] /comment/{seq} 댓글 수정 */
    @PatchMapping("/{seq}")
    public ResponseEntity<UpdateCommentResponse> updateComment(@AuthenticationPrincipal UserDetails userDetails,
                                                                @PathVariable Integer seq,
                                                                @RequestBody UpdateCommentRequest req) {

        return ResponseEntity.ok(service.updateComment(userDetails.getUsername(), seq, req));
    }
}
