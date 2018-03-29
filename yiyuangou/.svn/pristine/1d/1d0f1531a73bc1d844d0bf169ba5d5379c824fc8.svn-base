package com.example.em.mi.Fragment_5.ho.participation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.em.mi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/6/30.
 */

public class Participation_all_fragment  extends Fragment {
    View view;

    private RecyclerView re;
    //数据
    private List<String> datas;
    //声明适配器
    private Participation_all_rvAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.participation_all_fragment, container, false);
        //初始化数据
        initDatas();
        //初始化组件
        initView();
        return view;


    }

    private void initDatas() {
        datas = new ArrayList<String>();
        datas.add("3000淘宝卡");
        datas.add("移动充值卡100元");
        datas.add("30G中国黄金");

    }

    //初始化组件
    private void initView() {
        re = (RecyclerView)view.findViewById(R.id.participation_all_recyclerview);

        /*
		* 设置布局管理器
		* */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        re.setLayoutManager(linearLayoutManager);

        //设置适配器
        adapter = new Participation_all_rvAdapter(datas,view.getContext());
        re.setAdapter(adapter);
    }
}
