package com.example.myapplicationdemo02.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplicationdemo02.R;
import com.example.myapplicationdemo02.entity.Hero;
import java.util.List;

public class SpinnerAdapter extends BaseAdapter {

    private List<Hero> mData;
    private Context context;

    public SpinnerAdapter(List<Hero> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spin_hero
                    , parent
                    , false);
            holder.name = (TextView) convertView.findViewById(R.id.txt_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(mData.get(position).gethName());
        return convertView;
    }

    static class ViewHolder {
        private TextView name;
    }
}
