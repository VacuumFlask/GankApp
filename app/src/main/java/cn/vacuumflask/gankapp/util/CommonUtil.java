package cn.vacuumflask.gankapp.util;

import android.widget.Toast;

import cn.vacuumflask.gankapp.view.MyApplication;

/**
 * Created by Administrator on 2017/4/27 0027.
 * 常用工具类
 */

public class CommonUtil {

    /**
     * 短时间吐司
     * @param msg 提示信息
     */
    public static void shortToast(String msg) {
        Toast.makeText(MyApplication.mAppContext, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间吐司
     * @param msg 提示信息
     */
    public static void longToast(String msg) {
        Toast.makeText(MyApplication.mAppContext, msg, Toast.LENGTH_LONG).show();
    }
}
