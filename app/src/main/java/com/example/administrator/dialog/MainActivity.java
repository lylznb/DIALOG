package com.example.administrator.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater=getLayoutInflater();
                final View i=inflater.inflate(R.layout.login_dialog,null);//添加内容
                builder.setView(i)                                            //括号内原为“inflater.inflate(R.layout.login_dialog,null)”
                        .setTitle("登陆")
                        .setNegativeButton("取消",new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog,int id){
                            }
                        })
                        .setPositiveButton("登陆", new DialogInterface.OnClickListener() {

                            @Override
                            public void  onClick(DialogInterface dialog ,int id ){
                                EditText et1=i.findViewById(R.id.ET1);//i.原为“（EditText）”
                                EditText et2=i.findViewById(R.id.ET2);
                               if((et1.getText().toString().trim().equals("abc")) && (et2.getText().toString().trim().equals("123"))){
                                    Toast toast = Toast.makeText(MainActivity.this, "用户登陆成功", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                                else{
                                    Toast toast = Toast.makeText(MainActivity.this, "用户名或者密码有错误", Toast.LENGTH_SHORT);
                                   toast.show();
                               }
                            }
                        });

                builder.show();
            }
        });
        Button btn1 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                finish();
            }
        });
    }
}