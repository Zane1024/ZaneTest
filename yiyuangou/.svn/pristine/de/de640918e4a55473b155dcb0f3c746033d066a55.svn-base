package com.example.em.mi.restLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.em.mi.R;

/**
 * Created by Administrator on 2017/6/22.
 */
//登录界面
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    TextView login_retrieve;
    Button login_fast_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();//初始化方法
    }

    private void init() {
        login_retrieve= (TextView) findViewById(R.id.login_retrieve);
        login_retrieve.setOnClickListener(this);

        login_fast_register= (Button) findViewById(R.id.login_fast_register);
        login_fast_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_retrieve:
                Intent a=new Intent(LoginActivity.this,RetrieveActivity.class);
                startActivity(a);
                break;

            case R.id.login_fast_register:
                Intent b=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(b);
                break;
        }
    }
}