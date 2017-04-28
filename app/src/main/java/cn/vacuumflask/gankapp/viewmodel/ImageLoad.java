package cn.vacuumflask.gankapp.viewmodel;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.util.L;

/**
 * Created by Administrator on 2017/4/27 0027.
 * 加载图片
 */

public class ImageLoad {
    @BindingAdapter("loadImageUrl")
    public static void imageLoadUrl(ImageView ivImage, String url) {
        ivImage.setImageResource(R.mipmap.icon_main);
    }


}
