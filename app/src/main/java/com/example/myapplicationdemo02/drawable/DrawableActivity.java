package com.example.myapplicationdemo02.drawable;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.tooling.preview.Preview;

import com.example.myapplicationdemo02.R;

public class DrawableActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        Button btnOval = findViewById(R.id.btn_oval);
        //ShapeDrawable: 绘制圆形shape
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(Color.BLUE);
        Rect rect = new Rect();
        rect.top = 0;
        rect.left = 0;//左上的坐标点
        rect.bottom = 50;
        rect.right = 50;//右下的坐标点
        shapeDrawable.setBounds(rect);
        btnOval.setBackground(shapeDrawable);
    }
}
