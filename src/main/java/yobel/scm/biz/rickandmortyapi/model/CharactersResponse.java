package yobel.scm.biz.rickandmortyapi.model;

import java.util.List;

public class CharactersResponse {
    private Info info;
    private List<Character> results;

    // Getters and setters

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}

