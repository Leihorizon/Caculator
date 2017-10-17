package com.example.acer.caculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Button button=(Button)findViewById(R.id.button4);
        Button button2=(Button)findViewById(R.id.button14);
        Button button3=(Button)findViewById(R.id.button13);
        final EditText edittextcm =(EditText)findViewById(R.id.cm);
        final EditText edittextdm =(EditText)findViewById(R.id.dm);
        final EditText edittextm =(EditText)findViewById(R.id.m);
        final EditText edittextkm =(EditText)findViewById(R.id.km);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//返回按钮
                Intent intent=new Intent(FifthActivity.this,forthActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){//长度单位按钮触发事件
            public void onClick(View v) {//长度单位转换
                final String str1,str2,str3,str4;
                double cmNum,dmNum,mNum,kmNum;
                if(edittextcm.getText().toString().length()!=0){//用length（）判断是否为0不要用tostring判断是否为空
                    str1 = edittextcm.getText().toString();
                    cmNum =Double.parseDouble(str1);//字符转化为数字
                    dmNum=cmNum/10.0;
                    mNum=dmNum/10.0;
                    kmNum=mNum/1000.0;
                    edittextdm.setText(""+dmNum);
                    edittextm.setText(""+mNum);
                    edittextkm.setText(""+kmNum);
                    }
                else if(edittextdm.getText().toString().length()!=0){
                     str2=edittextdm.getText().toString();
                     dmNum =Double.parseDouble(str2);
                     cmNum=dmNum*10.0;
                     mNum=dmNum/10.0;
                     kmNum=dmNum/10000.0;
                     edittextcm.setText(""+cmNum);
                     edittextm.setText(""+mNum);
                     edittextkm.setText(""+kmNum);
                    }
                else if(edittextm.getText().toString().length()!=0){
                     str3=edittextm.getText().toString();
                     mNum =Double.parseDouble(str3);
                     cmNum=mNum*100.0;
                     dmNum=mNum*10.0;
                     kmNum=mNum/1000.0;
                     edittextcm.setText(""+cmNum);
                     edittextdm.setText(""+dmNum);
                     edittextkm.setText(""+kmNum);
                }

                else if(edittextkm.getText().toString().length()!=0)
                {
                    str4=edittextkm.getText().toString();
                     kmNum =Double.parseDouble(str4);
                     cmNum=kmNum*100000.0;
                     dmNum=kmNum*10000.0;
                     mNum=kmNum*1000.0;
                     edittextcm.setText(""+cmNum);
                     edittextdm.setText(""+dmNum);
                     edittextm.setText(""+mNum);

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
