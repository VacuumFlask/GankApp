package cn.vacuumflask.gankapp.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/4/27 0027.
 * Fragment基类
 */

public class BaseFragment<T extends ViewDataBinding> extends Fragment {

    public T getDataBindingView(int res, ViewGroup container) {
        Context context = getContext();
        if (context != null) {
            return DataBindingUtil.inflate(LayoutInflater.from(context), res, container, false);
        } else {
            return null;
        }
    }
}
