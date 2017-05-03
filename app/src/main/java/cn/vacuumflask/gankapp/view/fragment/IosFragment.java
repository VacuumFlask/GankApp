package cn.vacuumflask.gankapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.databinding.FragmentIosLayoutBinding;

/**
 * Created by Administrator on 2017/5/2 0002.
 * IOS 模块的Fragment
 */

public class IosFragment extends BaseFragment<FragmentIosLayoutBinding> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentIosLayoutBinding binding = getDataBindingView(R.layout.fragment_ios_layout, container);
        return binding.getRoot();
    }
}
