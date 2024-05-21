package org.aston.exercise.Parser;

import org.aston.exercise.Parser.People;

import java.util.List;

public class Root {

    private int total;

    private List<People> people;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Root{" +
                "total='" + total + '\'' +
                ", people=" + people +
                '}';
    }
}
