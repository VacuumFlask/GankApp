package cn.vacuumflask.gankapp.view.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.databinding.FragmentAndroidLayoutBinding;

/**
 * Created by Administrator on 2017/5/2 0002.
 * Android 模块的Fragment
 */

public class AndroidFragment extends BaseFragment<FragmentAndroidLayoutBinding> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentAndroidLayoutBinding binding = getDataBindingView(R.layout.fragment_android_layout, container);
        return binding.getRoot();
    }
}
