package tests;

import endpoints.UserService;
import models.UserListRootResponse;
import org.junit.jupiter.api.Assertions;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.junit.jupiter.api.Test;
import models.UserResponse;

import java.io.IOException;
import java.util.List;

public class UserTests {
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final UserService userService = retrofit.create(UserService.class);

    @Test
    public void testUserListPage() throws IOException {
        int page = 1;
        Response<UserListRootResponse> response = userService
                .getUserList(page).execute();

        Assertions.assertTrue(response.isSuccessful());

        UserListRootResponse rootResponse = response.body();
        Assertions.assertEquals(page, rootResponse.getPage());

        List<UserResponse> userData = rootResponse.getData();
        Assertions.assertTrue(userData.size() > 0);
    }
}
