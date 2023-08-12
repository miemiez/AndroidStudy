package com.example.myapplicationdemo02;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import com.example.myapplicationdemo02.Adapter.SpinnerAdapter;
import com.example.myapplicationdemo02.entity.Hero;

import java.util.ArrayList;

public class SpinnerActivity extends ComponentActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spin_one;
    private Spinner spin_two;
    private Context mContext;
    //判断是否为刚进去时触发onItemSelected的标志
    private boolean one_selected = false;
    private boolean two_selected = false;
    private ArrayList<Hero> mData = null;
    private SpinnerAdapter myAdadpter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_layout);
        mContext = this;
        mData = new ArrayList<Hero>();
        bindViews();
    }

    private void bindViews() {
        spin_one = (Spinner) findViewById(R.id.spin_one);
        spin_two = (Spinner) findViewById(R.id.spin_two);

        mData.add(new Hero( "迅捷斥候：提莫（Teemo）"));
        mData.add(new Hero("诺克萨斯之手：德莱厄斯（Darius）"));
        mData.add(new Hero("无极剑圣：易（Yi）"));
        mData.add(new Hero("德莱厄斯：德莱文（Draven）"));
        mData.add(new Hero("德邦总管：赵信（XinZhao）"));
        mData.add(new Hero("狂战士：奥拉夫（Olaf）"));

        myAdadpter = new SpinnerAdapter(mData, mContext);
        spin_two.setAdapter(myAdadpter);
        spin_one.setOnItemSelectedListener(this);
        spin_two.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(parent.getId() == R.id.spin_one) {
                if (one_selected) {
                    Toast.makeText(mContext, "您的分段是~：" + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    System.out.println(one_selected);
                    one_selected = true;
                    System.out.println(one_selected);
                }
            }else if(parent.getId() == R.id.spin_two){
                if (two_selected) {
                    TextView txt_name = (TextView) view.findViewById(R.id.txt_name);
                    Toast.makeText(mContext, "您选择的英雄是~：" + txt_name.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    two_selected = true;
                }
            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
