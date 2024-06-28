package yobel.scm.biz.rickandmortyapi.model;

import java.util.List;

public class locationResponse {
    private Info info;
    private List<Location> results;

    // Getters and setters

    public List<Location> getResults() {
        return results;
    }

    public void setResults(List<Location> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
