package cn.vacuumflask.gankapp.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import java.util.List;

import cn.vacuumflask.gankapp.R;
import cn.vacuumflask.gankapp.databinding.ItemShowLayoutBinding;
import cn.vacuumflask.gankapp.entity.bean.ItemShow;

/**
 * Created by Administrator on 2017/5/2 0002.
 * Android  和 IOS 的适配器
 */

public class ItemShowAdapter extends RecyclerView.Adapter<ItemShowAdapter.MyViewHolder> {


    public interface OnItemClickListener {
        void setOnItemClickListener(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    private List<ItemShow> list;

    public ItemShowAdapter(List<ItemShow> list) {
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemShowLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_show_layout, parent, false);
        return new MyViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.binding.setShow(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.setOnItemClickListener(holder.itemView, position);
                }
            }
        });


        holder.itemView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_item_in));
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemShowLayoutBinding binding;

        public MyViewHolder(View itemView, ItemShowLayoutBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }

}
