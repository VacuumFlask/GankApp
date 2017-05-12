package cn.vacuumflask.gankapp.view.activity;

import android.os.Bundle;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.databinding.ActivityHomeLayoutBinding;
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
