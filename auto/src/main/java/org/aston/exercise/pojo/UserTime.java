package org.aston.exercise.pojo;

public class UserTime extends User{
    private String updatedAt;
    public UserTime(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
