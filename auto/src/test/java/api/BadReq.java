package api;

public class BadReq {
    private String error;

    public BadReq(String error) {
        this.error = error;
    }

    public BadReq() {
    }

    public String getError() {
        return error;
    }
}
