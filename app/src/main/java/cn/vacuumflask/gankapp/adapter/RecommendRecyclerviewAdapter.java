package cn.vacuumflask.gankapp.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.databinding.ItemRecommendLayoutBinding;
import cn.vacuumflask.gankapp.entity.response.RecommendResponse;
import cn.vacuumflask.gankapp.util.L;

/**
 * Created by Administrator on 2017/4/27 0027.
 * 推荐fragmentRecyclerview设配器
 */

public class RecommendRecyclerviewAdapter extends RecyclerView.Adapter<RecommendRecyclerviewAdapter.MyViewHolder> {

    private List<RecommendResponse> list;

    public RecommendRecyclerviewAdapter(List<RecommendResponse> list) {
        L.i("适配器执行");
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRecommendLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_recommend_layout, parent, false);
        View view = binding.getRoot();
        MyViewHolder holder = new MyViewHolder(view);
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RecommendResponse recommendResponse = list.get(position);
        holder.binding.setRecommend(recommendResponse);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ItemRecommendLayoutBinding binding;

        MyViewHolder(View itemView) {
            super(itemView);
        }

        void setBinding(ItemRecommendLayoutBinding binding) {
            this.binding = binding;
        }
    }
}
