package cn.vacuumflask.gankapp.util;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/5/18 0018.
 * 自定义类型转换
 */

public class MyConverterFactory extends Converter.Factory {
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new ResponseConverter<>(type);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new RequestConverter<>();
    }

    private class ResponseConverter<T> implements Converter<ResponseBody, T> {
        private Type type;

        ResponseConverter(Type type) {
            this.type = type;
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            Gson gson = new Gson();
            String result = value.string();
            return gson.fromJson(result, type);
        }
    }

    private class RequestConverter<T> implements Converter<T, RequestBody> {

        @Override
        public RequestBody convert(T value) throws IOException {

            Gson gson = new Gson();
            if (value instanceof String) {
                String content = value.toString();
                return RequestBody.create(MediaType.parse("application/json; charset=UTF-8"), content);
            } else {
                String content = gson.toJson(value);
                L.json(content);
                return RequestBody.create(MediaType.parse("application/json; charset=UTF-8"), content);
            }
        }
    }

}
