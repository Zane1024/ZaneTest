package com.example.em.mi.restLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.em.mi.R;

/**
 * Created by Administrator on 2017/6/22.
 */
//忘记密码界面
public class RetrieveActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView retrieve_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve);
        init();
    }

    private void init() {
        retrieve_back= (ImageView) findViewById(R.id.retrieve_back);
        retrieve_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.retrieve_back:
                Intent a = new Intent(RetrieveActivity.this, LoginActivity.class);
                startActivity(a);
                break;
        }
    }
}

