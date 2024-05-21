package api;

public class SuccessReq {
    private Integer id;
    private String token;

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public SuccessReq(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessReq() {
    }
}
