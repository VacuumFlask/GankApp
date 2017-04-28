package cn.vacuumflask.gankapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.adapter.RecommendRecyclerviewAdapter;
import cn.vacuumflask.gankapp.databinding.FragmentRecommendLayoutBinding;
import cn.vacuumflask.gankapp.entity.response.RecommendResponse;
import cn.vacuumflask.gankapp.util.L;

/**
 * Created by Administrator on 2017/4/27 0027.
 * 推荐Fragment
 */

public class RecommendFragment extends BaseFragment<FragmentRecommendLayoutBinding> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentRecommendLayoutBinding bindingView = getDataBindingView(R.layout.fragment_recommend_layout, container);

        ArrayList<RecommendResponse> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new RecommendResponse("地址" + i, "4-27 测试内容不要在意这么多好吗"));
        }

        bindingView.fragmentRecommendRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        RecommendRecyclerviewAdapter adapter = new RecommendRecyclerviewAdapter(list);
        bindingView.fragmentRecommendRecyclerview.setAdapter(adapter);
        return bindingView.getRoot();
    }
}
