package com.example.lwp.design.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lwp.design.R;

/**
 * Created by clevo on 2015/8/2.
 */
public class FragmentRecyclerAdapter  extends  RecyclerView.Adapter<FragmentRecyclerAdapter.ViewHolder>{

    private String[] names={"非常好","还不错","好烂啊","天下良心啊","下次还来","必须顶","beatiful","非常好","还不错","好烂啊","天下良心啊","下次还来","必须顶","beatiful"};


    public FragmentRecyclerAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(names[position]);

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.tv_fragment_item);
        }
    }
}
