package cn.vacuumflask.gankapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.databinding.FragmentRecommendLayoutBinding;
import cn.vacuumflask.gankapp.view.activity.BaseActivity;
import cn.vacuumflask.gankapp.viewmodel.WelfareViewModel;

/**
 * Created by Administrator on 2017/4/27 0027.
 * 福利Fragment
 */

public class WelfareFragment extends BaseFragment<FragmentRecommendLayoutBinding> {

    public WelfareViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentRecommendLayoutBinding bindingView = getDataBindingView(R.layout.fragment_recommend_layout, container);
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
        viewModel = new WelfareViewModel(baseActivity, bindingView);
        viewModel.start();
        return bindingView.getRoot();
    }
}
