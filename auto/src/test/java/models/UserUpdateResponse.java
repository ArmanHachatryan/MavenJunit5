package models;

public class UserUpdateResponse {
    public String name;
    public String job;
    public String updatedAt;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public UserUpdateResponse(String name, String job, String updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    public UserUpdateResponse() {
    }
}
