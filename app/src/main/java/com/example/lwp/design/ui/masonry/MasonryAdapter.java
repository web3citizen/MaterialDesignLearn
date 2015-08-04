package com.example.lwp.design.ui.masonry;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwp.design.R;

import java.util.List;

/**
 * Created by clevo on 2015/7/27.
 */

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView>{
    private List<Product> products;
    private static RecycleItemClickListener itemClickListener;


    public MasonryAdapter(List<Product> list,RecycleItemClickListener clickListener) {
        products=list;
        itemClickListener=clickListener;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_masonry_item, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        masonryView.imageView.setImageResource(products.get(position).getImg());
        masonryView.textView.setText(products.get(position).getTitle());

    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    //viewholder
    public static class MasonryView extends  RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imageView;
        private TextView textView;


       public MasonryView(View itemView){
           super(itemView);
           imageView= (ImageView) itemView.findViewById(R.id.masonry_item_img );
           textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
           itemView.setOnClickListener(this);

       }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v,this.getLayoutPosition());
        }
    }


}
