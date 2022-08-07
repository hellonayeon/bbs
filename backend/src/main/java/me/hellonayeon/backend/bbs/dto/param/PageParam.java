package me.hellonayeon.backend.bbs.dto.param;

public abstract class PageParam {

    private Integer pageStart;
    private Integer pageEnd;

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
    }

    public void setPageParam(Integer page, Integer itemCount) {
        page -= 1;

        pageStart = page * itemCount + 1;
        pageEnd = (page + 1) * itemCount;
    }
}
