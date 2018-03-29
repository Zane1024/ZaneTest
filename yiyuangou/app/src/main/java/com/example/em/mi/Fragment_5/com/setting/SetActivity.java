package com.example.em.mi.Fragment_5.com.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.em.mi.Manager.DataCleanManager;
import com.example.em.mi.R;

/**
 * Created by Administrator on 2017/6/26.
 */

public class SetActivity extends AppCompatActivity implements View.OnClickListener{

    //缓存
    private TextView sette;
    //保存缓存大小
    String cacheSize;
    //返回
    ImageView set_back;
    /**
     * f5_set_xiugaimimas 修改密码
     */
    private RelativeLayout about_us,clear, f5_set_xiugaimimas;
    @Override
    //设置界面
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_5_set);
        init();
        getFileSize();

    }

    private void init() {
        sette= (TextView) findViewById(R.id.sette);
        about_us = (RelativeLayout)findViewById(R.id.set_aboutus);
        clear = (RelativeLayout)findViewById(R.id.set_clear);
        set_back = (ImageView)findViewById(R.id.set_back);
        f5_set_xiugaimimas = (RelativeLayout)findViewById(R.id.f5_set_xiugaimimas);

        about_us.setOnClickListener(this);
        clear.setOnClickListener(this);
        set_back.setOnClickListener(this);
        f5_set_xiugaimimas.setOnClickListener(this);
    }

    private void getFileSize() {
        // TODO Auto-generated method stub
        try {
            cacheSize = DataCleanManager.getCacheSize(this.getCacheDir());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        sette.setText("已缓存" + cacheSize);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_aboutus:
                Intent intent = new Intent(SetActivity.this,About_usActivity.class);
                startActivity(intent);
                break;
            case R.id.set_clear:
                DataCleanManager.cleanInternalCache(this);

                try {
                    cacheSize = DataCleanManager.getCacheSize(this.getCacheDir());

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                sette.setText("已缓存" + cacheSize);
                Toast.makeText(SetActivity.this,"清除成功",Toast.LENGTH_SHORT).show();
                break;

            case R.id.set_back:
                SetActivity.this.finish();
                break;
            //跳转  修改密码
            case R.id.f5_set_xiugaimimas:
                Intent xiugaimima = new Intent(SetActivity.this,Upda_Password.class);
                startActivity(xiugaimima);
                break;

        }

    }
}