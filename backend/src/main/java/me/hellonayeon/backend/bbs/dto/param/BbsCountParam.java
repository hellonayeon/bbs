package me.hellonayeon.backend.bbs.dto.param;

import me.hellonayeon.backend.bbs.dto.request.BbsListRequest;

public class BbsCountParam {

    private String choice;
    private String search;

    public BbsCountParam(BbsListRequest req) {
        this.choice = req.getChoice();
        this.search = req.getChoice();
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
}
