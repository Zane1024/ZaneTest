package com.example.em.mi.Fragment_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.em.mi.R;
import com.example.em.mi.pig.DialogFragment_p.DialogFragment_canyu_ja;
import com.example.em.mi.pig.com.shohuodizi.CommodityDetails;

import java.util.ArrayList;
import java.util.List;

public class Popularity_Fragment extends Fragment {
	//定义RecyclerView
	private RecyclerView popularity_rv;
	//定义RecyclerView适配器
	private Popularity_rvAdapter popularity_rvAdapter;
	//数据
	List<String> datas;
	//定义主要视图
	private View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		 view = inflater.inflate(R.layout.home_vp_fragment_popularity, container,false);
		initDatas();
		initPopularityRecyclerView();

		return view;
		
		
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
	}
	//初始化人气RecyclerView
	private void initPopularityRecyclerView (){
		//得到控件
		popularity_rv = (RecyclerView) view.findViewById(R.id.home_popularity_rv);
		/*
		* 设置布局管理器
		* 禁止Recyclerview滑动 解决卡顿问题
		* */
		FullyGridLayoutManager gridLayoutManager = new FullyGridLayoutManager(view.getContext(), 2) {
			@Override
			public boolean canScrollVertically() {
				return false;
			}
		};


		popularity_rv.setLayoutManager(gridLayoutManager);

		//初始化适配器
		popularity_rvAdapter = new Popularity_rvAdapter(datas,view.getContext());

		//给RcyclerView 设置点击时间
		popularity_rvAdapter.setOnItemClickListener(new Popularity_rvAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				Toast.makeText(getActivity(),"onclick "+datas.get(position),Toast.LENGTH_SHORT).show();
				Intent intent1 = new Intent(getActivity(),CommodityDetails.class);
				//Toast.makeText(inflater.getContext(),"准备抢", Toast.LENGTH_SHORT).show();
				//传值 改变布局
				intent1.putExtra("number",1);
				startActivity(intent1);

			}
		});

		popularity_rvAdapter.setOnBtnClickListener(new Popularity_rvAdapter.OnBtnClickListener() {
			@Override
			public void onbtClick(View view, int position) {
				DialogFragment_canyu_ja dia = new DialogFragment_canyu_ja();
				dia.show(getFragmentManager(),"payDetailFragment");

				Toast.makeText(getActivity(),"onBTNclick "+datas.get(position),Toast.LENGTH_SHORT).show();
			}
		});

		//设置适配器
		popularity_rv.setAdapter(popularity_rvAdapter);


	}


	//初始化RecyclerView数据
	public void initDatas(){
		datas = new ArrayList<String>();
		datas.add("1");
		datas.add("2");
		datas.add("3");
		datas.add("4");
		datas.add("5");
		datas.add("6");
	}
}
