package cn.vacuumflask.gankapp.viewmodel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.view.Window;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.adapter.HomeViewPagerAdapter;
import cn.vacuumflask.gankapp.databinding.ActivityHomeLayoutBinding;
import cn.vacuumflask.gankapp.util.L;
import cn.vacuumflask.gankapp.view.activity.HomeActivity;
import cn.vacuumflask.gankapp.view.fragment.AndroidFragment;
import cn.vacuumflask.gankapp.view.fragment.IosFragment;
import cn.vacuumflask.gankapp.view.fragment.WelfareFragment;

/**
 * Created by Administrator on 2017/5/2 0002.
 * 主页ViewModel
 */

public class HomeViewModel {
    private ActivityHomeLayoutBinding binding;
    private HomeActivity activity;
    private int[] resDraw = new int[]{R.mipmap.icon_bg_5, R.mipmap.icon_bg_6, R.mipmap.icon_bg_7};

    public HomeViewModel(ActivityHomeLayoutBinding binding, HomeActivity activity) {
        this.binding = binding;
        this.activity = activity;
    }

    public void start() {
        String[] titles = activity.getResources().getStringArray(R.array.HomeTiltes);

        L.array(titles);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        //推荐
        WelfareFragment welfareFragment = new WelfareFragment();
        fragmentList.add(welfareFragment);
        //Android
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentList.add(androidFragment);
        //ios
        IosFragment iosFragment = new IosFragment();
        fragmentList.add(iosFragment);

        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(activity.getSupportFragmentManager(), fragmentList, titles);
        binding.homeViewpager.setAdapter(adapter);
        binding.homeTablayout.setupWithViewPager(binding.homeViewpager);

        binding.homeImage.setImageResource(resDraw[0]);
        changeBgColor(0);

        setEvent();
    }


    private void setEvent() {
        binding.homeViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeBgColor(position);
                binding.homeImage.setImageResource(resDraw[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void changeBgColor(int position) {
        final Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), resDraw[position]);
        L.d("位图：" + bitmap);
        Palette palette = Palette.from(bitmap).generate();

        Palette.Swatch vibrantSwatch = palette.getLightVibrantSwatch();
        if (vibrantSwatch==null){
            return;
        }

        binding.homeTablayout.setTabTextColors(vibrantSwatch.getRgb(), colorBurn(vibrantSwatch.getRgb()));
        binding.homeTablayout.setSelectedTabIndicatorColor(colorBurn(vibrantSwatch.getRgb()));
        binding.homeAppbar.setBackgroundColor(vibrantSwatch.getRgb());
        binding.homeCollapsingtoobar.setContentScrimColor(colorShallow(vibrantSwatch.getRgb()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.setStatusBarColor(colorBurn(vibrantSwatch.getRgb()));
            window.setNavigationBarColor(colorBurn(vibrantSwatch.getRgb()));
        }
    }

    /**
     * 颜色加深处理
     * @return 加深颜色
     */
    private int colorBurn(int RGBValues) {
        float[] hsv = new float[3];
        Color.colorToHSV(RGBValues, hsv); // convert to hsv

        hsv[1] = hsv[1] + 0.1f; // less saturation
        hsv[2] = hsv[2] - 0.1f; // more brightness
        return Color.HSVToColor(hsv);
    }

    /**
     * 颜色变浅处理
     *
     * @return 变浅颜色
     */
    private int colorShallow(int RGBValues) {
        float[] hsv = new float[3];
        Color.colorToHSV(RGBValues, hsv); // convert to hsv

        hsv[1] = hsv[1] - 0.1f; // less saturation
        hsv[2] = hsv[2] + 0.1f; // more brightness
        return Color.HSVToColor(hsv);
    }


}
