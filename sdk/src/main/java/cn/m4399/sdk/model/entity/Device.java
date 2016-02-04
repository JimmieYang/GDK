package cn.m4399.sdk.model.entity;


import org.json.JSONException;
import org.json.JSONObject;

import cn.m4399.sdk.constance.Const;

/**
 * Created by 4399-0833 on 2016/2/3.
 */
public class Device {
    private String device_identifier;
    private String screen_resolution;
    private String device_model;
    private String device_model_version;
    private String system_version;
    private String platform_type;
    private String sdk_version;
    private String game_key;
    private String canal_identifier;
    private String game_version;
    private String bid;
    private String imsi;
    private String phone;
    private String udid;
    private String debug;
    private String network_type;
    private String uid;

    public Device() {
        device_model_version = Const.DEVICE_MODEL_VERSION;
        platform_type = Const.PLATFORM_TYPE_VALUE;
        sdk_version = Const.SDK_VERSION_VALUE;
        game_key = Const.GAME_KEY_VALUE;
        canal_identifier = Const.CANAL_IDENTIFIER_VALUE;
        game_version = Const.GAME_VERSION_VALUE;
        bid = Const.BID_VALUE;
        udid = Const.UDID_VALUE;
        debug = Const.DEBUG_VALUE;
        uid = Const.UDID;
    }

    public String parse() {
        JSONObject object = new JSONObject();
        try {
            object.putOpt(Const.DEVICE_IDENTIFIER, getDevice_identifier());
            object.putOpt(Const.SCREEN_RESOLUTION, getScreen_resolution());
            object.putOpt(Const.DEVICE_MODEL, getDevice_model());
            object.putOpt(Const.DEVICE_MODEL_VERSION, getDevice_model_version());
            object.putOpt(Const.SYSTEM_VERSION, getSystem_version());
            object.putOpt(Const.PLATFORM_TYPE, getPlatform_type());
            object.putOpt(Const.SDK_VERSION, getSdk_version());
            object.putOpt(Const.GAME_KEY, getGame_key());
            object.putOpt(Const.CANAL_IDENTIFIER, getCanal_identifier());
            object.putOpt(Const.GAME_VERSION, getGame_version());
            object.putOpt(Const.BID, getBid());
            object.putOpt(Const.IMSI, getImsi());
            object.putOpt(Const.PHONE, getPhone());
            object.putOpt(Const.UDID, getUdid());
            object.putOpt(Const.DEBUG, getDebug());
            object.putOpt(Const.NETWORK_TYPE, getNetwork_type());
            object.putOpt(Const.UID, getUid());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    public String getDevice_identifier() {
        return device_identifier;
    }

    public void setDevice_identifier(String device_identifier) {
        this.device_identifier = device_identifier;
    }

    public String getScreen_resolution() {
        return screen_resolution;
    }

    public void setScreen_resolution(String screen_resolution) {
        this.screen_resolution = screen_resolution;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getDevice_model_version() {
        return device_model_version;
    }

    public void setDevice_model_version(String device_model_version) {
        this.device_model_version = device_model_version;
    }

    public String getSystem_version() {
        return system_version;
    }

    public void setSystem_version(String system_version) {
        this.system_version = system_version;
    }

    public String getPlatform_type() {
        return platform_type;
    }

    public void setPlatform_type(String platform_type) {
        this.platform_type = platform_type;
    }

    public String getSdk_version() {
        return sdk_version;
    }

    public void setSdk_version(String sdk_version) {
        this.sdk_version = sdk_version;
    }

    public String getGame_key() {
        return game_key;
    }

    public void setGame_key(String game_key) {
        this.game_key = game_key;
    }

    public String getCanal_identifier() {
        return canal_identifier;
    }

    public void setCanal_identifier(String canal_identifier) {
        this.canal_identifier = canal_identifier;
    }

    public String getGame_version() {
        return game_version;
    }

    public void setGame_version(String game_version) {
        this.game_version = game_version;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public String getNetwork_type() {
        return network_type;
    }

    public void setNetwork_type(String network_type) {
        this.network_type = network_type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
