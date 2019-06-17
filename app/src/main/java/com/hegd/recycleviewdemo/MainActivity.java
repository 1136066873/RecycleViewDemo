package com.hegd.recycleviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.hegd.recycleviewdemo.activity.ComplexActivity;
import com.hegd.recycleviewdemo.activity.SimpleActivity;
//https://juejin.im/post/5a2907136fb9a0450e7603b2
//https://www.jianshu.com/p/c3c6c81adfbc
//https://blog.csdn.net/lb377463323/article/details/48023171


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_simple,btn_complex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btn_simple = findViewById(R.id.btn_simple);
        btn_simple.setOnClickListener(this);
        btn_complex = findViewById(R.id.btn_complex);
        btn_complex.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_simple:
                startActivity(new Intent(this, SimpleActivity.class));
                break;

            case R.id.btn_complex:
                startActivity(new Intent(this, ComplexActivity.class));
                break;

            default:
                    break;
        }
    }
}
