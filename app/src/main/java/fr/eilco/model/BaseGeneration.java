package fr.eilco.model;

import java.util.List;

public class BaseGeneration {

    private Long id;
    private int count;
    private String next;
    private String previous;
    private List<GenerationResult> results;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<GenerationResult> getResults() {
        return results;
    }

    public void setResults(List<GenerationResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BaseGeneration{" +
                "id=" + id +
                ", count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}
