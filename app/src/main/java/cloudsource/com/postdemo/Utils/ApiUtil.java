package cloudsource.com.postdemo.Utils;

import cloudsource.com.postdemo.ApiService;
import cloudsource.com.postdemo.RetrofitClient;

/**
 * Created by ayemyathu on 4/23/18.
 */

public class ApiUtil {
    public static final String BASE_URL="http://thetthar.com:3000/";

public static ApiService getApiService(){
    return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
}
}
