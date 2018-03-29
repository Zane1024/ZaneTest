package com.example.em.mi.pig.com.shohuodizi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.em.mi.R;
import com.example.em.mi.bean.Participant_user;
import com.example.em.mi.pig.BaseAdapter.All_Participation_Records_BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有参与记录
 * Created by Administrator on 2017-07-04.
 */

public class All_Participation_Records_J extends Activity {

    private ListView all_participation_listview;

    //参与用户实体数据
    private List<Participant_user> user_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_participation_records);

        all_participation_listview = (ListView)findViewById(R.id.all_participation_listview);
        initUserDatas();
        All_Participation_Records_BaseAdapter adapter = new All_Participation_Records_BaseAdapter(this,user_list,1);
        all_participation_listview.setAdapter(adapter);

    }

    //初始化参与用户数据
    private void initUserDatas() {
        user_list = new ArrayList<Participant_user>();
        Participant_user p1 = new Participant_user("猪");
        for (int i = 0; i <10 ; i++) {
            user_list.add(p1);
        }


    }
}
