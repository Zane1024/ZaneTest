package com.example.em.mi.restLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.em.mi.R;


/**
 * Created by Administrator on 2017/6/22.
 */
//注册界面
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView register_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
    }

    private void init() {
        register_back= (ImageView) findViewById(R.id.register_back);
        register_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_back:
                Intent a =new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(a);
                break;
        }

    }
}