package cloudsource.com.postdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import cloudsource.com.postdemo.Utils.ApiUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText etName, etPass;
    public ApiService apiService;
    //  SigninPresenter signinPresenter;
    Button btn;
    private static final String email = "htetsuhlaing@cloudsource.co.jp";
    private static final String pass = "12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.email);
        etPass = (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.singin);
        //signinPresenter=new PresenterImpl(MainActivity.class);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etName.getText().toString();
                String password = etPass.getText().toString();

                apiService = ApiUtil.getApiService();
                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
//                    JSONObject body = new JSONObject();
//                    JSONObject auth = new JSONObject();
//                    try {
//                        auth.put("email", email);
//                        auth.put("password", pass);
//                        body.put("auth", auth);
////
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                    JsonObject body=new JsonObject();
                    JsonObject auth=new JsonObject();
                    try {
                        auth.addProperty("email",email);
                        auth.addProperty("password",pass);
                        body.add("auth",auth);
                    }
                    catch (JsonIOException e){
                        e.printStackTrace();
                    }

                    Call<JsonObject> usersignin=apiService.sendBody(body);
                    usersignin.enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            Log.d("mylog", "response success " + response);
                            Log.d("mylog", "response body " + response.body());
                            Toast.makeText(getApplicationContext(), "Login Success " + response, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Login fail ", Toast.LENGTH_SHORT).show();
                        }
                    });

//
                    //Call<Auth>usersignin= null;

//                     Call<Auth>usersignin = apiService.getAuth(body.toString());



//                    usersignin.enqueue(new Callback<Auth>() {
//                        @Override
//                        public void onResponse(Call<Auth> call, Response<Auth> response) {
//                            Toast.makeText(getApplicationContext(), "Login Success " + response, Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onFailure(Call<Auth> call, Throwable t) {
//                            Toast.makeText(getApplicationContext(), "Login fail ", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    //   Call<Signin> usersign = apiService.getSignin(body);
//                    usersign.enqueue(new Callback<Signin>() {
//                        @Override
//                        public void onResponse(Call<Signin> call, Response<Signin> response) {
//                            Log.d("mylog", "response success " + response);
//                            Toast.makeText(getApplicationContext(), "Login Success " + response, Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onFailure(Call<Signin> call, Throwable t) {
//                            Log.d("mylog", "faliure " + t.getMessage());
//                            Toast.makeText(getApplicationContext(), "Login fail ", Toast.LENGTH_SHORT).show();
//                        }
//                    });


//                    usersign.enqueue(new Callback<ResponseBody>() {
//                        @Override
//                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            Log.d("mylog", "response success " + response);
//                            Toast.makeText(getApplicationContext(), "Login Success " + response, Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseBody> call, Throwable t) {
//                            Log.d("mylog", "faliure " + t.getMessage());
//                            Toast.makeText(getApplicationContext(), "Login fail ", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                }

            }
        });


    }
}

