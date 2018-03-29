package com.example.em.mi.Fragment_2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.em.mi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EM on 2017/4/17.
 */

public class Fragment_2 extends Fragment {
    private ListView listView;
    private  MylistviewAdapter mAdapter;
    private List<NewsInfo> datas ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_2,null);
        listView = (ListView)view.findViewById(R.id.news_listview);

        initDatas();
        mAdapter = new MylistviewAdapter(datas,view.getContext());
        listView.setAdapter(mAdapter);

        return view;
    }

    //初始化数据
    private void initDatas(){
        datas = new ArrayList<NewsInfo>();
        NewsInfo new1 = new NewsInfo(R.drawable.main_tab_item_user,"Test",666,
                "幸运儿",99,"100006","2017-6-22");

        NewsInfo new2 = new NewsInfo(R.drawable.main_tab_item_user,"Test",666,
                "幸运儿",99,"100006","2017-6-22");
        NewsInfo new3 = new NewsInfo(R.drawable.main_tab_item_user,"Test",666,
                "幸运儿",99,"100006","2017-6-22");
        NewsInfo new4 = new NewsInfo(R.drawable.main_tab_item_user,"Test",666,
                "幸运儿",99,"100006","2017-6-22");
        NewsInfo new5 = new NewsInfo(R.drawable.main_tab_item_user,"Test",666,
                "幸运儿",99,"100006","2017-6-22");
        datas.add(new1);
        datas.add(new2);
        datas.add(new3);
        datas.add(new4);


    }

}
