package cn.vacuumflask.gankapp.viewmodel;

import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.adapter.ItemShowAdapter;
import cn.vacuumflask.gankapp.databinding.FragmentIosLayoutBinding;
import cn.vacuumflask.gankapp.entity.bean.ItemShow;
import cn.vacuumflask.gankapp.view.activity.BaseActivity;

/**
 * Created by Administrator on 2017/5/3 0003.
 * IOS的ViewModel负责业务
 */

public class IosViewModel {
    private BaseActivity activity;
    private FragmentIosLayoutBinding binding;

    public IosViewModel(BaseActivity activity, FragmentIosLayoutBinding binding) {
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

        binding.fragmentIosRecyclerview.setLayoutManager(new LinearLayoutManager(activity));

        ItemShowAdapter adapter = new ItemShowAdapter(list);
        binding.fragmentIosRecyclerview.setAdapter(adapter);
    }

}
