package com.example.myapplicationdemo02;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

public class ListViewActivity extends ComponentActivity implements AdapterView.OnItemClickListener {
    private List<News> mData = null;
    private Context mContext;
    private NewsAdapter2 mAdapter = null;
    private ListView listView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mContext = this;
        listView = findViewById(R.id.listview); //View层
        mData = new LinkedList<News>();
        for(int i = 0;i < 25;i++){
            mData.add(new News("我是标题" + i,"我是内容" + i,R.drawable.kafuka));
        } //Model层
        mAdapter = new NewsAdapter2(mContext,mData); //Controller层
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(mContext,"点击了第" + position + "条数据",Toast.LENGTH_SHORT).show();
    }
}
