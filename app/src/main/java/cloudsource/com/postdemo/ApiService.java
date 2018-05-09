package cloudsource.com.postdemo;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ayemyathu on 4/23/18.
 */

public interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("/login_token")
//    //ResponseEntity<JsonElement> login(@Body Map<String, Object> formData);
//   // Call<ResponseBody> ApiName(@Body JSONObject json, User user);
    //Call<Signin> getSignin(@Body String auth);
    //Call<Auth> getAuth(@Body String auth);
    Call<JsonObject> sendBody(@Body JsonObject jsonObject);


//    Call<Auth> getauth(@Field("username") String username,
//                    @Field("password") String password);

//   // ResponseEntity<JsonElement> login(@Body Map<String, Object> formData);

}
