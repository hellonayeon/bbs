package me.hellonayeon.backend.bbs.dto.param;

import me.hellonayeon.backend.bbs.dto.request.BbsListRequest;

public class BbsListParam extends PageParam {

    private String choice;
    private String search;
    private Integer page;

    public BbsListParam(BbsListRequest req) {
        this.choice = req.getChoice();
        this.search = req.getSearch();
        this.page = req.getPage();
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
