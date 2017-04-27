package cn.vacuumflask.gankapp.view;

import android.app.Application;

import com.orhanobut.logger.Logger;

import cn.vacuumflask.gankapp.util.Constant;

/**
 * Created by Administrator on 2017/4/27 0027.
 * Application 配置类
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(Constant.TAG);//初始化日志
    }
}
