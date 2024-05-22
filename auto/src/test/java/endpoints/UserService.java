package endpoints;

import models.UserListRootResponse;
import models.SingleUserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("api/users")
    Call<UserListRootResponse> getUserList(@Query("page") int pageParam);

    @GET("api/users/{id}")
    Call<SingleUserResponse> getUserById(@Path("id") int id);
}
