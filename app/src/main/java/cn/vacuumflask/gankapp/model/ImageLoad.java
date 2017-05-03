package cn.vacuumflask.gankapp.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.util.L;

/**
 * Created by Administrator on 2017/4/27 0027.
 * 加载图片
 */

public class ImageLoad {
    private static int index;
    @BindingAdapter("loadImageUrl")
    public static void imageLoadUrl(ImageView ivImage, String url) {
        index++;
        if (index%3==0){

            ivImage.setImageResource(R.mipmap.icon_three);
        }else {
            ivImage.setImageResource(R.mipmap.icon_main);
        }
    }


}
