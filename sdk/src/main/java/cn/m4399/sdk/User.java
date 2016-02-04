package cn.m4399.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 4399-0833 on 2016/2/3.
 */
public class User {
    private String uid;
    private String username;
    private String bindedphone;
    private String nick;
    private String avatar_middle;
    private String access_token;
    private String state;
    private String account_type;

    public User() {

    }

    public User(String str) {
        parse(str);
    }

    public void parse(String str) {
        if (str != null && !str.equals("")) {
            try {
                JSONObject result = new JSONObject(str);
                setUid(result.optString("uid"));
                setUsername(result.optString("username"));
                setBindedphone(result.optString("bindedphone"));
                setAvatar_middle(result.optString("avatar_middle"));
                setAccess_token(result.optString("access_token"));
                setNick(result.optString("nick"));
                setState(result.optString("state"));
                setAccount_type(result.optString("account_type"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getBindedphone() {
        return bindedphone;
    }

    public String getNick() {
        return nick;
    }

    public String getAvatar_middle() {
        return avatar_middle;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getState() {
        return state;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBindedphone(String bindedphone) {
        this.bindedphone = bindedphone;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setAvatar_middle(String avatar_middle) {
        this.avatar_middle = avatar_middle;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
}
