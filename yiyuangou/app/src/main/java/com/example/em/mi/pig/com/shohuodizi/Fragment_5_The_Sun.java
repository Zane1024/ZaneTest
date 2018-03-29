package com.example.em.mi.pig.com.shohuodizi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.em.mi.R;
import com.example.em.mi.pig.BaseAdapter.Fragment_5_The_Sun_BaseAdapter;
import com.nostra13.universalimageloader.utils.L;

/**
 * 绑定晒单界面代码
 * Created by Administrator on 2017-07-04.
 */

public class Fragment_5_The_Sun extends Activity {

    private ListView f5_the_sun_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_5_the_sun);
        //初始化 组件
        f5_the_sun_listview = (ListView)findViewById(R.id.f5_the_sun_listview);
        //通过适配器绑定数据
        Fragment_5_The_Sun_BaseAdapter baseAdapter = new Fragment_5_The_Sun_BaseAdapter(this);
        f5_the_sun_listview.setAdapter(baseAdapter);
        Toast.makeText(this,"我过来了", Toast.LENGTH_LONG).show();

    }
}
