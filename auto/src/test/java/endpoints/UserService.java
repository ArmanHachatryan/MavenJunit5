package endpoints;

import models.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {
    @GET("api/users")
    Call<UserListRootResponse> getUserList(@Query("page") int pageParam);

    @GET("api/users/{id}")
    Call<SingleUserResponse> getUserById(@Path("id") int id);

    @GET("api/users")
    Call<CreateUserResponse> createUser(@Body UserRequest userRequest);

    @PUT("apu/users/{id}")
    Call<UserUpdateResponse> updateUser(@Path("id") int id,
                                        @Body UserRequest userRequest);

    @DELETE("api/users/{id}")
    Call<Void> deleteUserById(@Path("id") int id);
}
