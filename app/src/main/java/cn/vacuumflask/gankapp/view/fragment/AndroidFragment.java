package cn.vacuumflask.gankapp.view.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.databinding.FragmentAndroidLayoutBinding;
import cn.vacuumflask.gankapp.view.activity.BaseActivity;
import cn.vacuumflask.gankapp.viewmodel.AndroidViewModel;

/**
 * Created by Administrator on 2017/5/2 0002.
 * Android 模块的Fragment
 */

public class AndroidFragment extends BaseFragment<FragmentAndroidLayoutBinding> {

    public AndroidViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentAndroidLayoutBinding binding = getDataBindingView(R.layout.fragment_android_layout, container);
        FragmentActivity activity = getActivity();
        //Activity判空
        if (activity == null) {
            return null;
        }
        //强转判断
        BaseActivity baseActivity;
        if (activity instanceof BaseActivity) {
            baseActivity = ((BaseActivity) activity);
        } else {
            return null;
        }
        viewModel = new AndroidViewModel(baseActivity, binding);
        viewModel.start();
        return binding.getRoot();
    }
}
