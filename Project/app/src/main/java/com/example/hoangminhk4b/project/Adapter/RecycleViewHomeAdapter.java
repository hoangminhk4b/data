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
import com.example.hoangminhk4b.project.Model.RecycleViewIconHomeModel;
import com.example.hoangminhk4b.project.R;

import java.util.List;

public class RecycleViewHomeAdapter extends RecyclerView.Adapter<RecycleViewHomeAdapter.ViewHolderHome> {
    Activity activity;
    List<RecycleViewIconHomeModel> listData;

    public RecycleViewHomeAdapter(Activity activity, List<RecycleViewIconHomeModel> listData) {
        this.activity = activity;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolderHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View view=inflater.inflate(R.layout.item_recyleview_home,parent,false);
        ViewHolderHome viewHolderHome=new ViewHolderHome(view);

        return viewHolderHome;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHome holder, int position) {
        RecycleViewIconHomeModel recycleViewIconHomeModel=listData.get(position);
        holder.tvIcon.setText(recycleViewIconHomeModel.getTitle());
        Glide.with(activity).load(recycleViewIconHomeModel.getAvatar()).into(holder.img);
        if(listData.size()==(position+1)){
            holder.view.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolderHome extends RecyclerView.ViewHolder{
        TextView tvIcon;
        ImageView img;
        View view;
        public ViewHolderHome(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.ivHome);
            tvIcon=itemView.findViewById(R.id.tvIcon);
            view=itemView.findViewById(R.id.vItemRv);
        }
    }
}
