package com.example.acer.caculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        Button button=(Button)findViewById(R.id.button4);
        Button button2=(Button)findViewById(R.id.button14);
        Button button3=(Button)findViewById(R.id.button13);
        final EditText edittextcm =(EditText)findViewById(R.id.cm2);
        final EditText edittextdm =(EditText)findViewById(R.id.dm2);
        final EditText edittextm =(EditText)findViewById(R.id.m2);
        final EditText edittextkm =(EditText)findViewById(R.id.km2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//返回按钮
                Intent intent=new Intent(sixthActivity.this,forthActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {//长度单位按钮触发事件

            public void onClick(View v) {//面积单位转换
                final String str1,str2,str3,str4;
                double cm2Num2,dm2Num2,m2Num2,km2Num2;
                if(edittextcm.getText().toString().length()!=0){//用length（）判断是否为0不要用tostring判断是否为空
                    str1 = edittextcm.getText().toString();
                    cm2Num2 =Double.parseDouble(str1);//字符转化为数字
                    dm2Num2=cm2Num2/100.0;
                    m2Num2=dm2Num2/100.0;
                    km2Num2=m2Num2/1000000.0;
                    edittextdm.setText(""+dm2Num2);
                    edittextm.setText(""+m2Num2);
                    edittextkm.setText(""+km2Num2);
                }
                else if(edittextdm.getText().toString().length()!=0){//不加第二个条件无法实现
                    str2=edittextdm.getText().toString();
                    dm2Num2 =Double.parseDouble(str2);
                    cm2Num2=dm2Num2*100.0;
                    m2Num2=dm2Num2/100.0;
                    km2Num2=dm2Num2/100000000.0;
                    edittextcm.setText(""+cm2Num2);
                    edittextm.setText(""+m2Num2);
                    edittextkm.setText(""+km2Num2);
                }
                else if(edittextm.getText().toString().length()!=0){
                    str3=edittextm.getText().toString();
                    m2Num2 =Double.parseDouble(str3);
                    cm2Num2=m2Num2*10000.0;
                    dm2Num2=m2Num2*100.0;
                    km2Num2=m2Num2/1000000.0;
                    edittextcm.setText(""+cm2Num2);
                    edittextdm.setText(""+dm2Num2);
                    edittextkm.setText(""+km2Num2);
                }

                else if(edittextkm.getText().toString().length()!=0)
                {
                    str4=edittextkm.getText().toString();
                    km2Num2 =Double.parseDouble(str4);
                    cm2Num2=km2Num2*10000000000.0;
                    dm2Num2=km2Num2*100000000.0;
                    m2Num2=km2Num2*1000000.0;
                    edittextcm.setText(""+cm2Num2);
                    edittextdm.setText(""+dm2Num2);
                    edittextm.setText(""+m2Num2);

                }

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {//清空按钮
                edittextcm.setText("");
                edittextdm.setText("");
                edittextm.setText("");
                edittextkm.setText("");
            }
        });
    }
}
