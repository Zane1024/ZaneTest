package com.example.em.mi.pig.com.shohuodizi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.em.mi.R;
import com.example.em.mi.pig.BaseAdapter.Lucky_Record_J_BaseAdapter;

/**
 * 绑定幸运记录界面
 * Created by Administrator on 2017-07-04.
 */

public class Lucky_Record_J extends Activity {

    private ListView lucky_record_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lucky_record);
        //初始化组件
        lucky_record_listview = (ListView)findViewById(R.id.lucky_record_listview);
        //通过适配器绑定数据
        Lucky_Record_J_BaseAdapter baseAdapter = new Lucky_Record_J_BaseAdapter(this);
        lucky_record_listview.setAdapter(baseAdapter);

    }
}
