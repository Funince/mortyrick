package yobel.scm.biz.rickandmortyapi.model;

import java.util.List;

public class episodeResponse {
    private Info info;
    private List<Episode> results;

    // Getters and setters

    public List<Episode> getResults() {
        return results;
    }

    public void setResults(List<Episode> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
