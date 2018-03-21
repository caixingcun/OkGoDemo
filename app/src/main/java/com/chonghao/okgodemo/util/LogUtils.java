package com.chonghao.okgodemo.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者: gang
 * 描述:工具类
 * 日志工具类
 */

public class LogUtils {
    //定义全局的标志
    public static boolean isOpen = true;

    public static  void info(String info,String msg) {
        if (isOpen) {
            Log.d(info, msg);
        }
    }
    public static  void error(String msg) {
        if (isOpen) {
            Log.e(Constants.TAG, msg);
        }
    }
    public static  void debug(String msg) {
        if (isOpen) {
            Log.d(Constants.TAG, msg);
        }
    }

    public  static void printJson(String tag, String msg, String headString) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(4);//最重要的方法，就一行，返回格式化的json字符串，其中的数字4是缩进字符数
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(4);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        printLine(tag, true);
        message = headString + LINE_SEPARATOR + message;
        String[] lines = message.split(LINE_SEPARATOR);
        for (String line : lines) {
          LogUtils.debug("║ " + line);
        }
        printLine(tag, false);
    }
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void printLine(String tag, boolean isTop) {
        if (isTop) {
            LogUtils.debug("╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            LogUtils.debug("╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }
}
