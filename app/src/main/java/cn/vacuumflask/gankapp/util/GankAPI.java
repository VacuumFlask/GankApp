package cn.vacuumflask.gankapp.util;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Part;

/**
 * Created by Administrator on 2017/5/2 0002.
 * API地址
 */

public interface GankAPI {

    //http://gank.io/api/data/数据类型/请求个数/第几页
    //http://gank.io/api/data/年/月/日
    public static final String BASE_URL = "http://gank.io/api/";


    /**
     * 根据类型分页请求数据
     * @param type  福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param count 数字，大于0
     * @param pages 数字，大于0
     * @return 请求数据
     */
    @GET("data/{type}/{count}/{pages}")
    Observable<String> getGankData(@Part("type") String type, @Part("count") String count, @Part("pages") String pages);

    /**
     * 根据日期请求数据
     * @param year 年
     * @param month 月
     * @param day 日
     * @return 请求数据
     */
    @GET("data/{year}/{month}/{day}")
    Observable<String> getGankDataByDate(@Part("year") String year, @Part("month") String month, @Part("day") String day);

}
