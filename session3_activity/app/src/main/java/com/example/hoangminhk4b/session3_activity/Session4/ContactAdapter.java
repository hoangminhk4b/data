package com.example.hoangminhk4b.session3_activity.Session4;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoangminhk4b.session3_activity.ContactModel;
import com.example.hoangminhk4b.session3_activity.R;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<ContactModel> listContact;
    private Activity activity;

    public ContactAdapter(List<ContactModel> listContact, Activity activity) {
        this.listContact = listContact;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.d(ContactAdapter.class.getSimpleName(), view + "");

        if (view == null) {
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.itemcontact, viewGroup, false);

            ViewHolder viewHolder = new ViewHolder();

            viewHolder.imgAvatar = view.findViewById(R.id.imgAvatar);
            viewHolder.tvName = view.findViewById(R.id.tvName);
            viewHolder.tvPhone = view.findViewById(R.id.tvPhone);
            view.setTag(viewHolder);

        }

        ViewHolder viewHolder = (ViewHolder) view.getTag();

        ContactModel model = listContact.get(i);
        viewHolder.imgAvatar.setImageResource(model.getAvatar());
        viewHolder.tvName.setText(model.getName());
        viewHolder.tvPhone.setText(model.getPhone());

        return view;
    }

    public static class ViewHolder {
        ImageView imgAvatar;
        TextView tvName;
        TextView tvPhone;
    }
}
