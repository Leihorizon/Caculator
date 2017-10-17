package com.example.acer.caculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    boolean clear_flag;
    TextView input,output;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        Button button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//返回键
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Button btnBackspace = (Button) findViewById(R.id.btnBackspace);
        Button btnCE = (Button) findViewById(R.id.btnCE);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btnadd = (Button) findViewById(R.id.btnAdd);
        Button btnsub = (Button) findViewById(R.id.btnSub);
        Button btnmul = (Button) findViewById(R.id.btnMul);
        Button btndiv = (Button) findViewById(R.id.btnDiv);
        Button btnleft = (Button) findViewById(R.id.btnLeft);
        Button btnright = (Button) findViewById(R.id.btnRight);
        Button btndoc = (Button) findViewById(R.id.btnDoc);
        Button btnln = (Button) findViewById(R.id.button4);
        Button btnmi = (Button) findViewById(R.id.button3);
        Button btnsin = (Button) findViewById(R.id.button2);
        Button btncos = (Button) findViewById(R.id.button);
        Button btnequal = (Button) findViewById(R.id.btnEqu);
        btnBackspace.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btncos.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btndoc.setOnClickListener(this);
        btnequal.setOnClickListener(this);
        btnleft.setOnClickListener(this);
        btnmi.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btnright.setOnClickListener(this);
        btnsin.setOnClickListener(this);
        btnln.setOnClickListener(this);
    }

    public void onClick(View v) {
        String str = input.getText().toString();
        switch (v.getId()) {
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
            case R.id.btn0:
            case R.id.btnDoc:
            case R.id.btnLeft:
            case R.id.btnRight:
            case R.id.button:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    input.setText("");
                }
                input.setText(str + ((Button) v).getText());
                break;
            case R.id.btnAdd:
            case R.id.btnSub:
            case R.id.btnMul:
            case R.id.btnDiv:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    input.setText("");
                }
                input.setText(str + ((Button) v).getText());
                break;
            case R.id.btnCE:
                input.setText("");
                break;
            case R.id.btnBackspace:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    input.setText("");
                }
                if (str != null && !str.equals("")) {
                    input.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btnEqu:
                if (clear_flag){
                    clear_flag = false;
                    str = "";
                    input.setText("");
                }
                input.setText(str + ((Button)v).getText());
                String s1 = input.getText().toString();
                int flag=0;
                for(int j=0;j<s1.length()-1;j++){
                    if(s1.charAt(j)=='+'||s1.charAt(j)=='-'||s1.charAt(j)=='*'||s1.charAt(j)=='/'||s1.charAt(j)=='.'||s1.charAt(j)=='s'||s1.charAt(j)=='c'||s1.charAt(j)=='l'||s1.charAt(j)=='^'){
                        if(s1.charAt(j+1)=='+'||s1.charAt(j+1)=='-'||s1.charAt(j+1)=='*'||s1.charAt(j+1)=='/'||s1.charAt(j+1)=='.'||s1.charAt(j+1)=='=')
                            flag=1;
                    }
                    if(s1.charAt(j)=='.'||s1.charAt(j)=='s'||s1.charAt(j)=='c'||s1.charAt(j)=='l'||s1.charAt(j)=='^'){
                        if(s1.charAt(j+1)=='+'||s1.charAt(j+1)=='-'||s1.charAt(j+1)=='*'||s1.charAt(j+1)=='/'||s1.charAt(j+1)=='.'||s1.charAt(j+1)=='='||s1.charAt(j+1)=='s'||s1.charAt(j+1)=='c'||s1.charAt(j+1)=='l'||s1.charAt(j+1)=='^')
                            flag=1;
                    }
                    if(s1.charAt(j)=='('){
                        if(s1.charAt(j+1)=='+'||s1.charAt(j+1)=='-'||s1.charAt(j+1)=='*'||s1.charAt(j+1)=='/'||s1.charAt(j+1)=='.'||s1.charAt(j+1)=='^'||s1.charAt(j+1)==')')
                            flag=1;
                    }
                    if(s1.charAt(j)==')'){
                        if(s1.charAt(j+1)=='.'||s1.charAt(j+1)=='s'||s1.charAt(j+1)=='c'||s1.charAt(j+1)=='l'||s1.charAt(j+1)=='(')
                            flag=1;
                    }
                }
                if(s1.charAt(0)=='=')
                    flag=1;
                if(flag==0)
                    output.setText(""+getresult());
                if(flag==1)
                    Toast.makeText(this, "您输入的表达式有误",
                            Toast.LENGTH_SHORT).show();
                break;
        }

    }
    public double getresult() {
        Stack stack1 = new Stack(); // 创建数字堆栈对象
        Stack stack2 = new Stack();//创建符号堆栈
        String s = input.getText().toString();
        s=s.replaceAll("sin","s");
        s=s.replaceAll("cos","c");
        s=s.replaceAll("ln","l");
        int x=0;//数字栈元素个数
        stack2.push('@');
        clear_flag = true;//计算完一个算术后可以不用清除项在进行下一个算术时候会直接清除
        int i = 0;//控制字符下标
        double result = 0, t,a,b;//a,b为要计算的两个数字
        char ch;//接受出栈后的运算符
        while (i<s.length()||x>1){//如果数字栈元素只剩一个并且i的值等于字符串长度就停住
            if (isnumber(s.charAt(i)) == 1) {//s.charAt(i)获取字符串第i个位置的字符,类似于数组
                t = Double.parseDouble(String.valueOf(s.charAt(i)));//char类型转化为double类型
                if(i+1<s.length()) {
                    if(s.charAt(i + 1)=='.'){//解决小数入栈问题
                        double p=1;
                        while (isnumber(s.charAt(i + 2)) == 1) {
                            p=p*0.1;
                            t = t + Double.parseDouble(String.valueOf(s.charAt(i+2)))*p;
                            i++;//控制获取字符串下标
                        }
                        i++;//这里一定要记住自加i因为小数点占了一个字符
                    }
                    else {
                        while (isnumber(s.charAt(i + 1)) == 1) {
                            t = t * 10 + Double.parseDouble(String.valueOf(s.charAt(i + 1)));
                            i++;//控制获取字符串下标
                        }
                    }
                }
                stack1.push(t);//将t压栈
                x++;
            }
            else {
                switch (compare((char) stack2.peek() , s.charAt(i))) {//栈顶元素与算术元素优先级的比较
                    case 1://进栈的标志
                        stack2.push(s.charAt(i));
                        break;
                    case 0://计算的标志
                        ch= (char) stack2.pop();
                        a= (double) stack1.pop();
                        b= (double) stack1.pop();
                        stack1.push(calculate (b,ch,a));
                        x--;
                        //如果字符栈顶符号优先级高于s.charAt(i)，并且栈顶元素上一个元素的优先级也比s.charAt(i)高，这时候需要进行多次比较
                        //比如5-1*2+2，加号字符比乘小并且也比减号字符小，因此要进行减法运算再进行加法运算
                        while(compare((char) stack2.peek(), s.charAt(i))==0){//如果栈内优先级高（这里主要考虑+-符号的情况，如果栈内字符比相比字符优先级高）就进行运算出栈入栈操作，并且让a[i]一直与栈内符号相比
                            ch= (char) stack2.pop();
                            a= (double) stack1.pop();
                            b= (double) stack1.pop();
                            stack1.push(calculate (b,ch,a));
                            x--;
                        }
                        //主要解决在字符栈左括号遇到右括号的问题以及第一次计算后s.charAt(i)再次与栈顶字符比较进栈的情况
                        if(s.charAt(i)!=')')
                            stack2.push(s.charAt(i));//不能让右括号进栈
                        else
                            ch=(char) stack2.pop();//左括号要出栈*/
                        break;
                    case 2://将当前符号出栈，主要针对括号和@
                        ch= (char) stack2.pop();
                        break;
                    case 3://考虑sin,cos等函数计算情况
                        ch= (char) stack2.pop();
                        a= (double) stack1.pop();
                        b=Math.toRadians(a);
                        if(ch=='s')
                            stack1.push(Math.sin(b));
                        else if(ch=='c')
                            stack1.push(Math.cos(b));
                        else if(ch=='l')
                            stack1.push(Math.log(a));
                        else {
                            b = (double) stack1.pop();
                            stack1.push(Math.pow(b, a));
                            x--;
                        }
                        while(compare((char) stack2.peek(), s.charAt(i))==0){//如果栈内优先级高（这里主要考虑+-符号的情况，如果栈内字符比相比字符优先级高）就进行运算出栈入栈操作，并且让a[i]一直与栈内符号相比
                            ch= (char) stack2.pop();
                            a= (double) stack1.pop();
                            b= (double) stack1.pop();
                            stack1.push(calculate (b,ch,a));
                            x--;
                        }
                        //主要解决在字符栈左括号遇到右括号的问题以及第一次计算后s.charAt(i)再次与栈顶字符比较进栈的情况
                        if(s.charAt(i)!=')')
                            stack2.push(s.charAt(i));//不能让右括号进栈
                        else
                            ch=(char) stack2.pop();//左括号要出栈*/
                        break;

                }
            }
            if(i<s.length())
                i++;
        }
        result= (double) stack1.peek();
        return result;
    }

    public int isnumber(char a) {//判断是否是数字字符
        boolean IsNumber = Character.isDigit(a);
        if (IsNumber)//如果a是数字字符的话就返回1
            return 1;
        else
            return 0;
    }

    //输入的操作符与栈内操作符优先级的比较
    public int compare(char a, char b) {//a位栈内字符元素
        int t = 0;
        switch (a) {
            case '+':
            case '-': {
                if (b == '*' || b == '/' || b == '('|| b=='s'|| b=='c'|| b=='l'|| b=='^')
                    t= 1;//进栈的标志
                else if (b == ')' || b == '@' || b == '+' || b == '-'||b=='=')
                    t= 0;//计算的标志
            }
            break;
            case '*':
            case '/': {
                if (b == ')' || b == '+' || b == '-' || b == '@' || b == '*' || b == '/'||b=='=')
                    t= 0;//计算的标志
                else if (b == '('|| b=='s'|| b=='c'|| b=='l'|| b=='^')
                    t= 1;//进栈的标志
            }
            break;
            case '(': {
                if (b == ')')
                    t= 2;//将当前的符号出栈
                else
                    t= 1;
            }
            break;
            case '@': {
                if (b == '=')
                    t= 2;
                else
                    t= 1;
            }
            break;
            case 's':
            case 'c':
            case 'l':
            case '^': {
               if(b!='(')
                    t=3;
               else
                    t=1;
            }
            break;

        }
        return t;

    }
    //两个数的计算
    public double calculate (double a,char p,double b){
        double result=0;
        switch(p){
            case'+':
                result=a+b;
                break;
            case'-':
                result=a-b;
                break;
            case'*':
                result=a*b;
                break;
            case'/':
                result=a/b;
                break;
        }
        return result;
    }


}

