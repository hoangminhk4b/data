package com.example.hoangminhk4b.session3_activity.Session5;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoangminhk4b.session3_activity.ContactModel;
import com.example.hoangminhk4b.session3_activity.R;

import java.util.List;

public class ContactAdapter5 extends RecyclerView.Adapter {
    private List<ContactModel> listContact;
    private Activity activity;
    private  IOnItemClickListener iOnItemClickListener;

    public ContactAdapter5(List<ContactModel> listContact, Activity activity) {
        this.listContact = listContact;
        this.activity = activity;
    }

    public void registerLister(IOnItemClickListener ion){
        iOnItemClickListener=ion;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.itemcontact,parent,false);
        ContactHolder holder=new ContactHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ContactHolder viewholder= (ContactHolder)holder;
        ContactModel model=listContact.get(position);
        viewholder.tvPhone.setText(model.getPhone());
        viewholder.tvName.setText(model.getName());
        viewholder.imgAvatar.setImageResource(model.getAvatar());


    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }
    public class ContactHolder extends RecyclerView.ViewHolder{
        ImageView imgAvatar;
        TextView tvName;
        TextView tvPhone;
        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar=itemView.findViewById(R.id.imgAvatar);
            tvName=itemView.findViewById(R.id.tvName);
            tvPhone=itemView.findViewById(R.id.tvPhone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("ContactHolder", getAdapterPosition()+"");
                    iOnItemClickListener.OnClickItem(getAdapterPosition());
                }
            });
        }
    }
    public interface IOnItemClickListener{
        void OnClickItem(int position);
        void OnClickButton(int position);
    }
}
