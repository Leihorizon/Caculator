package com.example.acer.caculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent=getIntent();
        Button button=(Button)findViewById(R.id.button4);
        Button button2=(Button)findViewById(R.id.button8);
        Button button3=(Button)findViewById(R.id.button13);
        final EditText edittext2 =(EditText)findViewById(R.id.two);
        final EditText edittext8 =(EditText)findViewById(R.id.eight);
        final EditText edittext10 =(EditText)findViewById(R.id.ten);
        final EditText edittext16 =(EditText)findViewById(R.id.sixteen);
        button.setOnClickListener(new View.OnClickListener() {//发送
            @Override
            public void onClick(View v) {//返回的按钮
                Intent intent=new Intent(thirdActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {//发送
            @Override
            public void onClick(View v) {//计算按钮
                final String str1,str2,str3,str4;
                int twoNum,eightNum,tenNum,sixteenNum;
                if(edittext10.getText().toString().length()!=0){//用length（）判断是否为0不要用tostring判断是否为空
                    str3 = edittext10.getText().toString();
                    tenNum =Integer.parseInt(str3);//字符转化为数字
                    str1=Integer.toBinaryString(tenNum);//十转二
                    str2=Integer.toOctalString(tenNum);//十转八
                    str4=Integer.toHexString(tenNum);//十转16
                    edittext2.setText(str1);
                    edittext8.setText(str2);
                    edittext16.setText(str4);
                }
                else if(edittext2.getText().toString().length()!=0){//用length（）判断是否为0不要用tostring判断是否为空
                    str1 = edittext2.getText().toString();
                   // tenNum =Integer.parseInt(str2);//字符转化为数字
                   // 方法parseInt(String s,int radix)的目的是输出一个十进制数，这个数字是“String s”但是我们要知道他是多少进制的，而方法中“int radix”参数正是来表达这个信息的
                    tenNum=Integer.parseInt(str1,2);//2转十
                    str2=Integer.toOctalString(tenNum);//十转八
                    str4=Integer.toHexString(tenNum);//十转16
                    edittext8.setText(str2);
                    edittext10.setText(""+tenNum);
                    edittext16.setText(str4);
                }
                else if(edittext8.getText().toString().length()!=0){//用length（）判断是否为0不要用tostring判断是否为空
                    str2 = edittext8.getText().toString();
                    // tenNum =Integer.parseInt(str2);//字符转化为数字
                    // 方法parseInt(String s,int radix)的目的是输出一个十进制数，这个数字是“String s”但是我们要知道他是多少进制的，而方法中“int radix”参数正是来表达这个信息的
                    tenNum=Integer.parseInt(str2,8);//八转十
                    str1=Integer.toBinaryString(tenNum);//十转二
                    str4=Integer.toHexString(tenNum);//十转16
                    edittext2.setText(str1);
                    edittext10.setText(""+tenNum);
                    edittext16.setText(str4);
                }
                else if(edittext16.getText().toString().length()!=0){//用length（）判断是否为0不要用tostring判断是否为空
                    str4 = edittext16.getText().toString();
                    // tenNum =Integer.parseInt(str2);//字符转化为数字
                    // 方法parseInt(String s,int radix)的目的是输出一个十进制数，这个数字是“String s”但是我们要知道他是多少进制的，而方法中“int radix”参数正是来表达这个信息的
                    tenNum=Integer.parseInt(str4,16);//十六转十
                    str1=Integer.toBinaryString(tenNum);//十转二
                    str2=Integer.toOctalString(tenNum);//十转八
                    edittext2.setText(str1);
                    edittext8.setText(str2);
                    edittext10.setText(""+tenNum);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {//清除按钮
                edittext2.setText("");
                edittext8.setText("");
                edittext10.setText("");
                edittext16.setText("");
            }
        });

    }
}
