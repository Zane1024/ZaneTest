package com.example.em.mi.classification;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.em.mi.R;
import com.example.em.mi.bean.Commodity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/6/26.
 */

public class Myclass_Fragment extends Fragment {

    public static final String TAG = "MyFragment";
    private String str;
    //定义ListView
    private ListView mlListView;
    //适配器
    private Fragment_ListviewAdapter mAdapter;
    //数据
    private List<Commodity> datas;
    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view = inflater.inflate(R.layout.class_fragment_listview, null);
        //初始化数据
        initDatas();
        //初始化View
        initView();
        //得到数据
        str = getArguments().getString(TAG);


        TextView tv_title = (TextView) view.findViewById(R.id.testtv);
        tv_title.setText(str);
        return view;
    }
    //初始化View
   private void initView(){
       mlListView = (ListView)view.findViewById(R.id.class_fragment_lv);
       mAdapter = new Fragment_ListviewAdapter(getContext(),datas);
       mlListView.setAdapter(mAdapter);


   }

    //初始化数据
    private void initDatas(){
        datas = new ArrayList<Commodity>();
        Commodity data1 =  new Commodity("APPLE Iphone 128G 红色",R.mipmap.img2,1000,500);
        Commodity data2 =  new Commodity("Iphone 128G 红色",R.mipmap.img2,1000,400);
        Commodity data3 =  new Commodity("无线充电宝",R.mipmap.gouwuche,1000,300);
        Commodity data4 =  new Commodity("ipad pr0",R.mipmap.img2,1000,800);
        Commodity data5 =  new Commodity("ipad Air",R.mipmap.gouwuche,1000,100);
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);
        datas.add(data5);
        datas.add(data5);
        datas.add(data5);
        datas.add(data5);
        datas.add(data5);

    }


}
