package me.hellonayeon.backend.comment.dto.response;

public class UpdateCommentResponse {
    private Integer updatedRecordCount;

    public UpdateCommentResponse(Integer updatedRecordCount) {
        this.updatedRecordCount = updatedRecordCount;
    }

    public Integer getUpdatedRecordCount() {
        return updatedRecordCount;
    }

    public void setUpdatedRecordCount(Integer updatedRecordCount) {
        this.updatedRecordCount = updatedRecordCount;
    }
}
