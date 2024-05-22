package models;

public class SingleUserResponse {
    public UserResponse data;
    public Support support;

    public SingleUserResponse(UserResponse data, Support support) {
        this.data = data;
        this.support = support;
    }

    public SingleUserResponse() {
    }

    public UserResponse getData() {
        return data;
    }

    public void setData(UserResponse data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
