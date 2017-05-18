package cn.vacuumflask.gankapp.util;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/5/18 0018.
 * Retrofit工具类
 */

public class RetrofitUtil {

    /**
     * 根据类型分页请求数据
     *
     * @param type  福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param count 数字，大于0
     * @param pages 数字，大于0
     * @return 请求数据
     */
    public Observable<String> getDataByType(String type, String count, String pages) {

        return new Retrofit.Builder()
                .baseUrl(GankAPI.BASE_URL)
                .addConverterFactory(new MyConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GankAPI.class)
                .getGankData(type, count, pages);

    }

    /**
     * 根据日期请求数据
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return 请求数据
     */
    public Observable<String> getDataByDate(String year, String month, String day) {

        return new Retrofit.Builder()
                .baseUrl(GankAPI.BASE_URL)
                .addConverterFactory(new MyConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GankAPI.class)
                .getGankDataByDate(year, month, day);

    }

}
