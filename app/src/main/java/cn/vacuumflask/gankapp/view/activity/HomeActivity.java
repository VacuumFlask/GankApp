package cn.vacuumflask.gankapp.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.adapter.HomeViewPagerAdapter;
import cn.vacuumflask.gankapp.databinding.ActivityHomeLayoutBinding;
import cn.vacuumflask.gankapp.util.L;
import cn.vacuumflask.gankapp.view.fragment.RecommendFragment;
import cn.vacuumflask.gankapp.viewmodel.HomeViewModel;

public class HomeActivity extends BaseActivity {

    public HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeLayoutBinding dataBinding = getDataBindingView(R.layout.activity_home_layout);
        viewModel = new HomeViewModel(dataBinding,this);
        viewModel.start();
    }
}
