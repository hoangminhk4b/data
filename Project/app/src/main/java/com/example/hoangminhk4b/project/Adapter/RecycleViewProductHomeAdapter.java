package com.example.hoangminhk4b.project.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hoangminhk4b.project.Model.RecycleViewProductHomeModel;
import com.example.hoangminhk4b.project.R;

import java.util.List;

public class RecycleViewProductHomeAdapter extends RecyclerView.Adapter<RecycleViewProductHomeAdapter.ViewHomeHolder> {
    Activity activity;
    List<RecycleViewProductHomeModel> listData;

    public RecycleViewProductHomeAdapter(Activity activity, List<RecycleViewProductHomeModel> listData) {
        this.activity = activity;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View view =inflater.inflate(R.layout.item_product_recycleview_home,parent,false);
        ViewHomeHolder viewHomeHolder=new ViewHomeHolder(view);
        return viewHomeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHomeHolder holder, int position) {
        RecycleViewProductHomeModel recycleViewProductHomeModel=listData.get(position);
        Glide.with(activity).load(recycleViewProductHomeModel.getImg()).into(holder.img);
        holder.tvPrice.setText(recycleViewProductHomeModel.getPrice()+"");
        holder.nameProduct.setText(recycleViewProductHomeModel.getNameProduct());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHomeHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tvPrice;
        TextView nameProduct;
        public ViewHomeHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.ivProduct);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            nameProduct=itemView.findViewById(R.id.tvNameProduct);
        }
    }
}
