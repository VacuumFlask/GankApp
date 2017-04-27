package cn.vacuumflask.gankapp.util;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/4/27 0027.
 * 日志输出工具类
 */

public class L {

    public static void i(String msg) {
        Logger.i(msg);
    }

    public static void d(String msg) {
        Logger.d(msg);
    }

    public static void e(String msg) {
        Logger.e(msg);
    }

    //打印json
    public static void json(String json){
        Logger.json(json);
    }


}
