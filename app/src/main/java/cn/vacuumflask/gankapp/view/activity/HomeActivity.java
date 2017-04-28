package cn.vacuumflask.gankapp.view.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.adapter.HomeViewPagerAdapter;
import cn.vacuumflask.gankapp.databinding.ActivityHomeLayoutBinding;
import cn.vacuumflask.gankapp.util.L;
import cn.vacuumflask.gankapp.view.fragment.RecommendFragment;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeLayoutBinding dataBinding = getDataBindingView(R.layout.activity_home_layout);
        String[] titles = getResources().getStringArray(R.array.HomeTiltes);

        L.array(titles);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        //推荐
        for (String title : titles) {
            RecommendFragment fragment = new RecommendFragment();
            fragmentList.add(fragment);
        }

        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager(), fragmentList, titles);
        dataBinding.homeViewpager.setAdapter(adapter);
        dataBinding.homeTablayout.setupWithViewPager(dataBinding.homeViewpager);
    }
}
