package cloudsource.com.postdemo;

/**
 * Created by ayemyathu on 4/25/18.
 */

public class User {
    //String auth;
    String email;
    String password;

   // Auth auth;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
