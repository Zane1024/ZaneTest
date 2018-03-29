package com.example.em.mi.Fragment_5.com.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.em.mi.R;

/**
 * Created by pc on 2017/6/28.
 */

public class About_usActivity extends Activity implements View.OnClickListener{
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        initView();
    }

    private void initView() {
        back = (ImageView)findViewById(R.id.about_back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_back:
                About_usActivity.this.finish();
                break;
        }
    }
}
