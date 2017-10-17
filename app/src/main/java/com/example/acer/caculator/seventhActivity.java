package com.example.acer.caculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class seventhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        Button button=(Button)findViewById(R.id.button4);
        Button button2=(Button)findViewById(R.id.button14);
        Button button3=(Button)findViewById(R.id.button13);
        final EditText edittextmg =(EditText)findViewById(R.id.mg);
        final EditText edittextg =(EditText)findViewById(R.id.g);
        final EditText edittextkg =(EditText)findViewById(R.id.kg);
        final EditText edittextt =(EditText)findViewById(R.id.t);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//返回按钮
                Intent intent=new Intent(seventhActivity.this,forthActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {//长度单位按钮触发事件

            public void onClick(View v) {//质量单位转换
                final String str1,str2,str3,str4;
                double mgNum,gNum,kgNum,tNum,flag=0;
                if(edittextmg.getText().toString().length()!=0){//用length（）判断是否为0不要用tostring判断是否为空
                    str1 = edittextmg.getText().toString();
                    mgNum =Double.parseDouble(str1);//字符转化为数字
                    gNum=mgNum/1000.0;
                    kgNum=gNum/1000.0;
                    tNum=kgNum/1000.0;
                    edittextg.setText(""+gNum);
                    edittextkg.setText(""+kgNum);
                    edittextt.setText(""+tNum);
                }
                else if(edittextg.getText().toString().length()!=0){
                    str2=edittextg.getText().toString();
                    gNum =Double.parseDouble(str2);
                    mgNum=gNum*1000.0;
                    kgNum=gNum/1000.0;
                    tNum=kgNum/1000.0;
                    edittextmg.setText(""+mgNum);
                    edittextkg.setText(""+kgNum);
                    edittextt.setText(""+tNum);
                }
                else if(edittextkg.getText().toString().length()!=0){
                    str3=edittextkg.getText().toString();
                    kgNum =Double.parseDouble(str3);
                    mgNum=kgNum*1000000.0;
                    gNum=kgNum*1000.0;
                    tNum=kgNum/1000.0;
                    edittextmg.setText(""+mgNum);
                    edittextg.setText(""+gNum);
                    edittextt.setText(""+tNum);
                }

                else if(edittextt.getText().toString().length()!=0)
                {
                    str4=edittextt.getText().toString();
                    tNum =Double.parseDouble(str4);
                    kgNum=tNum*1000.0;
                    gNum=kgNum*1000.0;
                    mgNum=gNum*1000.0;
                    edittextmg.setText(""+mgNum);
                    edittextg.setText(""+gNum);
                    edittextkg.setText(""+kgNum);

                }

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {//清除按钮
                edittextmg.setText("");
                edittextg.setText("");
                edittextkg.setText("");
                edittextt.setText("");
            }
        });
    }
}
