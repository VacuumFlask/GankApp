package cn.vacuumflask.gankapp.viewmodel;

import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.adapter.RecommendRecyclerviewAdapter;
import cn.vacuumflask.gankapp.databinding.FragmentRecommendLayoutBinding;
import cn.vacuumflask.gankapp.entity.response.RecommendResponse;
import cn.vacuumflask.gankapp.view.activity.BaseActivity;

/**
 * Created by Administrator on 2017/5/2 0002.
 * 推荐 ViewModel
 */

public class WelfareViewModel {
    private BaseActivity activity;
    private FragmentRecommendLayoutBinding binding;

    public WelfareViewModel(BaseActivity activity, FragmentRecommendLayoutBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }

    public void start() {
        ArrayList<RecommendResponse> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new RecommendResponse("地址" + i, "4-27 测试内容不要在意这么多好吗"));
        }

        binding.fragmentRecommendRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        RecommendRecyclerviewAdapter adapter = new RecommendRecyclerviewAdapter(list);
        binding.fragmentRecommendRecyclerview.setAdapter(adapter);
    }

}
