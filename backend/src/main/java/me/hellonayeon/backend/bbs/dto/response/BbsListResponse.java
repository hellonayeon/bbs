package me.hellonayeon.backend.bbs.dto.response;

import java.util.List;
import me.hellonayeon.backend.bbs.domain.Bbs;

public class BbsListResponse {

    private List<Bbs> bbsList;
    private Integer pageCnt;

    public BbsListResponse(List<Bbs> bbsList, Integer pageCnt) {
        this.bbsList = bbsList;
        this.pageCnt = pageCnt;
    }

    public List<Bbs> getBbsList() {
        return bbsList;
    }

    public void setBbsList(List<Bbs> bbsList) {
        this.bbsList = bbsList;
    }

    public Integer getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(Integer pageCnt) {
        this.pageCnt = pageCnt;
    }
}
