package models;

public class CreateUserResponse {
    public String name;
    public String job;
    public String id;
    public String createdAt;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public CreateUserResponse() {
    }

    public CreateUserResponse(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }
}
