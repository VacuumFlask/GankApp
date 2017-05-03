package cn.vacuumflask.gankapp.viewmodel;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.adapter.HomeViewPagerAdapter;
import cn.vacuumflask.gankapp.databinding.ActivityHomeLayoutBinding;
import cn.vacuumflask.gankapp.util.L;
import cn.vacuumflask.gankapp.view.activity.HomeActivity;
import cn.vacuumflask.gankapp.view.fragment.AndroidFragment;
import cn.vacuumflask.gankapp.view.fragment.IosFragment;
import cn.vacuumflask.gankapp.view.fragment.RecommendFragment;

/**
 * Created by Administrator on 2017/5/2 0002.
 * 主页ViewModel
 */

public class HomeViewModel {
    private ActivityHomeLayoutBinding binding;
    private HomeActivity activity;

    public HomeViewModel(ActivityHomeLayoutBinding binding, HomeActivity activity) {
        this.binding = binding;
        this.activity = activity;
    }

    public void start() {
        String[] titles = activity.getResources().getStringArray(R.array.HomeTiltes);

        L.array(titles);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        //推荐
        RecommendFragment recommendFragment = new RecommendFragment();
        fragmentList.add(recommendFragment);
        //Android
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentList.add(androidFragment);
        //ios
        IosFragment iosFragment = new IosFragment();
        fragmentList.add(iosFragment);

        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(activity.getSupportFragmentManager(), fragmentList, titles);
        binding.homeViewpager.setAdapter(adapter);
        binding.homeTablayout.setupWithViewPager(binding.homeViewpager);
        setEvent();
    }


    private void setEvent() {
        binding.homeViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
