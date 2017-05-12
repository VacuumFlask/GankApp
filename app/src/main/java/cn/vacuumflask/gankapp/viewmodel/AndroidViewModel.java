package cn.vacuumflask.gankapp.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.adapter.ItemShowAdapter;
import cn.vacuumflask.gankapp.databinding.FragmentAndroidLayoutBinding;
import cn.vacuumflask.gankapp.entity.bean.ItemShow;
import cn.vacuumflask.gankapp.view.activity.BaseActivity;

/**
 * Created by Administrator on 2017/5/2 0002.
 * Android ViewModel 负责业务
 */

public class AndroidViewModel {

    private BaseActivity activity;
    private FragmentAndroidLayoutBinding binding;

    public AndroidViewModel(BaseActivity activity, FragmentAndroidLayoutBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }

    public void start() {
        ArrayList<ItemShow> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ItemShow show = new ItemShow.Builder()
                    .author("作者")
                    .createTime("创建时间：2017-05-03")
                    .desc("描述信息")
                    .url("地址").build();
            list.add(show);
        }

        binding.fragmentAndroidRecyclerview.setLayoutManager(new LinearLayoutManager(activity));

        ItemShowAdapter adapter = new ItemShowAdapter(list);
        binding.fragmentAndroidRecyclerview.setAdapter(adapter);
    }
}
