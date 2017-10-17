package com.example.acer.caculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
        //  Intent intent=getIntent();
        Button button = (Button) findViewById(R.id.button12);
        Button button2 = (Button) findViewById(R.id.button9);
        Button button3 = (Button) findViewById(R.id.button10);
        Button button4 = (Button) findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {//发送
            @Override
            public void onClick(View v) {//返回按钮
                Intent intent = new Intent(forthActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {//长度单位转换
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forthActivity.this, FifthActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {//发送
            @Override
            public void onClick(View v) {//面积单位转换
                Intent intent = new Intent(forthActivity.this, sixthActivity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {//发送
            @Override
            public void onClick(View v) {//质量单位转换
                Intent intent = new Intent(forthActivity.this, seventhActivity.class);
                startActivity(intent);
            }
        });
    }
}
