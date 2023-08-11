package com.example.myapplicationdemo02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter2 extends BaseAdapter { //多种布局风格
    private Context mContext;
    private List<News> mData;

    private static final int TYPE_NEWS_1 = 0;

    private static final int TYPE_NEWS_2 = 1;
    public NewsAdapter2(Context mContext,List<News> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
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
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return TYPE_NEWS_1;
        }else{
            return TYPE_NEWS_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        System.out.println(view == null);
        int type = getItemViewType(position);
        if(view == null){
            viewHolder = new ViewHolder();
            switch (type){
                case TYPE_NEWS_1:
                    view = LayoutInflater.from(mContext).inflate(R.layout.listview_item_layout,parent,false);
                    System.out.println("type1" + view);
                    break;
                case TYPE_NEWS_2:
                    view = LayoutInflater.from(mContext).inflate(R.layout.listview_item_layout2,parent,false);
                    System.out.println("type2" + view);
                    break;
            }
            viewHolder.imageView = view.findViewById(R.id.listview_item_image);
            viewHolder.title = view.findViewById(R.id.listview_item_title);
            viewHolder.content = view.findViewById(R.id.listview_item_content);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.imageView.setBackgroundResource(mData.get(position).getaIcon());
        viewHolder.title.setText(mData.get(position).getTitle());
        viewHolder.content.setText(mData.get(position).getContent());
        return view;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView content;
    }
}
