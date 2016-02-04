package cn.m4399.sdk;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 4399-0833 on 2016/2/3.
 */
public class LoginResult {
    private int code;
    private String message;
    private boolean success;
    private User user;

    public LoginResult() {

    }

    public LoginResult(String result) {
        parse(result);
    }

    public void parse(String result) {
        try {
            JSONObject object = new JSONObject(result);
            setCode(Integer.parseInt(object.optString("code")));
            setMessage(object.optString("message"));
            setUser(new User(object.optString("result")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
