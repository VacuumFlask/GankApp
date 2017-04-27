package cn.vacuumflask.gankapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/6/27.
 * SharedPreference工具类
 */
public class SPFileUtil {

    private String fileName;
    private Context context;
    private SharedPreferences sharedPreferences;

    public SPFileUtil(String fileName, Context context) {
        this.fileName = fileName;
        this.context = context;
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public String getFileName() {
        return fileName;
    }

    /**
     * 拿到相对应的键的值
     *
     * @param key 键值
     * @return 返回相对键值的数据
     */
    public String getFileMessage(String key) {
        return sharedPreferences.getString(key, "");
    }

    /**
     * 返回SharedPreference文件中的所有键值
     *
     * @return 键值的集合
     */
    public List<String> getKeys() {
        Map<String, ?> map = sharedPreferences.getAll();
        Set<? extends Map.Entry<String, ?>> entries = map.entrySet();
        Iterator<? extends Map.Entry<String, ?>> iterator = entries.iterator();
        ArrayList<String> keys = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<String, ?> entry = iterator.next();
            String key = entry.getKey();
            keys.add(key);
        }
        return keys;
    }

    /**
     * 返回SharedPreference文件中是否含有该值
     *
     * @return 键值的集合
     */
    public boolean hasKey(String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * @param key     键值
     * @param defalut 默认值
     * @return
     */
    public boolean getFileBoolean(String key, boolean defalut) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defalut);
    }

    /**
     * 保存先对应的Key值和Value值
     *
     * @param key   键值
     * @param value 键值相对应的值
     * @return 返回boolean
     */
    public boolean setSPFileValue(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * 保存先对应的Key值和Value值
     *
     * @param key   键值
     * @param value 键值相对应的值
     * @return 返回boolean
     */
    public boolean setSPFileValue(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * 删除所有数据
     *
     * @return 返回是否成功
     */
    public boolean deleteAllMessage() {
        return sharedPreferences.edit().clear().commit();
    }

    /**
     * 删除指定的键值所对应的值
     *
     * @param key 键值
     * @return 返回是否成功
     */
    public boolean deleteSingle(String key) {
        return sharedPreferences.edit().remove(key).commit();
    }

    /**
     * 不实例化对象 获取文件中相对应的值
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      键值
     * @return 返回相对应的数据
     */
    public static String getMsg(Context context, String fileName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    /**
     * 不实例化对象 获取文件中相对应的值
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      键值
     * @return
     */
    public static boolean getMessageBoolean(Context context, String fileName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * 返回SharedPreference文件中是否含有该值
     *
     * @return 键值的集合
     */
    public static boolean hasKey(Context context, String fileName, String key) {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE).contains(key);
    }

    /**
     * 不实例化对象 删除相对所有键值数据
     *
     * @param context  上下文
     * @param fileName 文件名
     */
    public static void deleteAllKey(Context context, String fileName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    /**
     * 不实例化对象 删除相对所有键值数据
     *
     * @param context  上下文
     * @param fileName 文件名
     */
    public static void deleteKey(Context context, String fileName, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).apply();
    }

    /**
     * 不实例化对象，直接保存数据
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      键值
     * @param vlaue    值
     * @return 返回是否保存成功
     */
    public static boolean setMessage(Context context, String fileName, String key, String vlaue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.edit().putString(key, vlaue).commit();
    }

    /**
     * 不实例化对象，直接保存数据
     *
     * @param context  上下文
     * @param fileName 文件名
     * @param key      键值
     * @param vlaue    值
     * @return 返回是否保存成功
     */
    public static boolean setMessage(Context context, String fileName, String key, boolean vlaue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.edit().putBoolean(key, vlaue).commit();
    }

    /**
     * 不初始化返回SharedPreference的键值集合
     *
     * @param context  上下文
     * @param fileName 文件名
     * @return 返回集合
     */
    public static List<String> getKeys(Context context, String fileName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Map<String, ?> map = sharedPreferences.getAll();
        Set<? extends Map.Entry<String, ?>> entries = map.entrySet();
        Iterator<? extends Map.Entry<String, ?>> iterator = entries.iterator();
        ArrayList<String> keys = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<String, ?> entry = iterator.next();
            String key = entry.getKey();
            keys.add(key);
        }
        return keys;
    }

}
