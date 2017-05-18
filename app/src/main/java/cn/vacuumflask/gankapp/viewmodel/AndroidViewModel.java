package cn.vacuumflask.gankapp.viewmodel;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.adapter.ItemShowAdapter;
import cn.vacuumflask.gankapp.databinding.FragmentAndroidLayoutBinding;
import cn.vacuumflask.gankapp.entity.bean.ItemShow;
import cn.vacuumflask.gankapp.util.L;
import cn.vacuumflask.gankapp.view.activity.BaseActivity;

/**
 * Created by Administrator on 2017/5/2 0002.
 * Android ViewModel 负责业务
 */

public class AndroidViewModel {

    private BaseActivity activity;
    private FragmentAndroidLayoutBinding binding;
    public ArrayList<ItemShow> list;
    public ItemShowAdapter adapter;
    private Handler handler;

    public AndroidViewModel(BaseActivity activity, FragmentAndroidLayoutBinding binding) {
        this.activity = activity;
        this.binding = binding;
        handler = new Handler();
    }

    public void start() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ItemShow show = new ItemShow.Builder()
                    .author("作者")
                    .createTime("创建时间：2017-05-03")
                    .desc("描述信息")
                    .url("地址").build();
            list.add(show);
        }

        binding.fragmentAndroidRecyclerview.setLayoutManager(new LinearLayoutManager(activity));
        binding.fragmentAndroidRecyclerview.setItemAnimator(new MyRecyclerviewAnimation());
        adapter = new ItemShowAdapter(list);
        binding.fragmentAndroidRecyclerview.setAdapter(adapter);

        binding.fragmentAndroidRefresh.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
        setEvent();
    }

    private void setEvent() {
        adapter.setOnItemClickListener(new ItemShowAdapter.OnItemClickListener() {
            @Override
            public void setOnItemClickListener(View view, int position) {
                list.remove(position);
                adapter.notifyItemRangeChanged(0, list.size());

            }
        });
        binding.fragmentAndroidRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list.add(0, new ItemShow("小何", "2017年5月17号", "", "一个描述而已，不要这么在意好吗"));
                        adapter.notifyItemRangeChanged(0, list.size());
                        binding.fragmentAndroidRefresh.setRefreshing(false);
                    }
                }, 3000);

            }
        });

    }
}
