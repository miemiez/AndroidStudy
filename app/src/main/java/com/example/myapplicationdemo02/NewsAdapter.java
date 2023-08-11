package com.example.myapplicationdemo02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class NewsAdapter extends BaseAdapter {  //单一布局
    private Context mContext;
    private List<News> mData;

    public NewsAdapter(Context mContext,List<News> mData){
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        System.out.println("wwwwwwwwwwww");
        System.out.println(convertView == null);
        if(convertView == null){  //convertView在被第一次赋值的时候，系统会把它缓存起来，所以加一个是否为null的判断，能性能优化
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item_layout,parent,false);//如果每次调用getView方法的时候都要进行inflate()的话，每次都要加载一次xml
            viewHolder.imageView = convertView.findViewById(R.id.listview_item_image);
            viewHolder.title = convertView.findViewById(R.id.listview_item_title);
            viewHolder.content = convertView.findViewById(R.id.listview_item_content);
            convertView.setTag(viewHolder); //把viewHolder与convertView相关联
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        ImageView imageView = convertView.findViewById(R.id.listview_item_image);
//        TextView title = convertView.findViewById(R.id.listview_item_title);
//        TextView content = convertView.findViewById(R.id.listview_item_content);
        viewHolder.imageView.setBackgroundResource(mData.get(position).getaIcon());
        viewHolder.title.setText(mData.get(position).getTitle());
        viewHolder.content.setText(mData.get(position).getContent());
        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView content;
    }
}
