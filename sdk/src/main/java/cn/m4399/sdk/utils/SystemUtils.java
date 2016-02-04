package cn.m4399.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

/**
 * Created by 4399-0833 on 2016/2/3.
 */
public class SystemUtils {
    public static String getResolution(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels + " * " + dm.widthPixels;
    }

    public static String getDeviceIdentifier(Context context) {
        return getTelephoyManager(context).getDeviceId();
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getImsi(Context context) {
        return getTelephoyManager(context).getSimSerialNumber();
    }

    public static String getPhone(Context context) {
        return getTelephoyManager(context).getLine1Number();
    }

    public static String getNetworkType(Context context) {
        return NetWorkUtil.getNetWorkType(context);
    }

    private static TelephonyManager getTelephoyManager(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm;
    }

}
