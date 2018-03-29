package com.example.em.mi.Fragment_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.em.mi.Fragment_1.ho.daojishi.SystemUtil;
import com.example.em.mi.Fragment_1.myScrollView.MyScrollView;
import com.example.em.mi.Fragment_1.search.SearchActivity;
import com.example.em.mi.MainActivity;
import com.example.em.mi.R;
import com.example.em.mi.classification.ClassificationActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by EM on 2017/4/17.
 */

public class Fragment_1 extends Fragment implements View.OnClickListener{
    //定义RecyclerView
    private RecyclerView mRecyclerView;

    //定义RecyclerView适配器
    private Home_recyclerviewAdapter myAdapter;
    //分类按钮/搜索按钮

    private ImageButton class_btn,search_btn;

    //最新揭晓
    RelativeLayout relativeLayout;



    //定义主要视图
    private View view;

    //定义导航 ViewPager
    private ViewPager mPageVp;

    //保存导航的Fragment页面
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();

    //导航的Fragment页面适配器
    private FragmentAdapter mFragmentAdapter;

    //最新揭晓数据
    List<Home_recyclerview_commodity> datas;

    /**
     * Tab显示内容LinearLayout和Textview
     */


    TextView mTabPopularity_tv, mTabNew_tv, mTabJindu_tv,mTabAll_tv;

    //顶部的导航
    TextView mTabPopularity_tv2, mTabNew_tv2, mTabJindu_tv2,mTabAll_tv2;


    // 声明 TAB 顶部悬浮组件
    LinearLayout topView,mFlowLayout;
    //自定义的ScrollView;
    MyScrollView myScrollView;

    //返回顶部的图片
    private ImageView back_top;

    private MyThread timeThread;







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);
        //初始化数据
        initDatas();

        //初始化RecyclerView
        initRecyclerView();


        //初始化FrameLayout
        initView();
        //对scroolview 滚动的监听
        ScroolViewListen();

        //倒计时线程
        timeThread = new MyThread(datas);
        new Thread(timeThread).start();
        myAdapter.notifyDataSetChanged();








        return view;
    }






    //初始化RecyclerView数据
    public void initDatas(){
        datas = new ArrayList<Home_recyclerview_commodity>();
        for (int i = 0; i <4 ; i++) {
            Home_recyclerview_commodity entity = new Home_recyclerview_commodity();
            entity.setNow_time("2016-12-04 15:24:43");
            entity.setmType(1);
            entity.setTime("0:00:00");
            entity.setStart_time("2016-12-05 16:10:24");
            entity.setPic(R.mipmap.img1);
            datas.add(entity);

        }

        //遍历所有数据，算出时间差并保存在每个商品的counttime属性内
        for (int i = 0; i <datas.size() ; i++) {
            long counttime = SystemUtil.timeDifference(datas.get(i).getNow_time()
                    ,datas.get(i).getStart_time());
            datas.get(i).setCountTime(counttime);
           // Log.i("counttime", "initDatas: "+counttime);
         }



    }


    //初始化RecyclerView
    private void initRecyclerView (){
        //得到控件
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_recyclerview);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 4){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        mRecyclerView.setLayoutManager(gridLayoutManager);

        //设置适配器
        myAdapter = new Home_recyclerviewAdapter(datas,view.getContext());
        mRecyclerView.setAdapter(myAdapter);



    }
    //初始化布局
    private void initView(){

        //初始化顶部分类搜索
        class_btn = (ImageButton)view.findViewById(R.id.home_class_ib);
        search_btn = (ImageButton)view.findViewById(R.id.home_search);

        //最新揭晓
        relativeLayout = (RelativeLayout)view.findViewById(R.id.home_jumpnews);
        //初始化tab导航
        mTabPopularity_tv = (TextView)view.findViewById(R.id.home_tab_hot);
        mTabNew_tv = (TextView)view.findViewById(R.id.home_tab_new);
        mTabJindu_tv = (TextView)view.findViewById(R.id.home_tab_jindu);
        mTabAll_tv = (TextView)view.findViewById(R.id.home_tab_all);

        //初始化tab导航2
        mTabPopularity_tv2 = (TextView)view.findViewById(R.id.home_tab_hot2);
        mTabNew_tv2 = (TextView)view.findViewById(R.id.home_tab_new2);
        mTabJindu_tv2 = (TextView)view.findViewById(R.id.home_tab_jindu2);
        mTabAll_tv2 = (TextView)view.findViewById(R.id.home_tab_all2);

        //返回顶部
        back_top = (ImageView)view.findViewById(R.id.home_back_top);

        //初始化TaB顶部悬浮需要用到的组件
        myScrollView = (MyScrollView)view.findViewById(R.id.home_scrollview);
        topView = (LinearLayout)view.findViewById(R.id.home_topview);
        mFlowLayout = (LinearLayout)view.findViewById(R.id.home_flow_llay);


        //设置分类，搜索，返回，最新揭晓监听
        class_btn.setOnClickListener(this);
        search_btn.setOnClickListener(this);
        back_top.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);

        //Tab1监听
        mTabPopularity_tv.setOnClickListener(this);
        mTabNew_tv.setOnClickListener(this);
        mTabJindu_tv.setOnClickListener(this);
        mTabAll_tv.setOnClickListener(this);

        //Tab21监听
        mTabPopularity_tv2.setOnClickListener(this);
        mTabNew_tv2.setOnClickListener(this);
        mTabJindu_tv2.setOnClickListener(this);
        mTabAll_tv2.setOnClickListener(this);

        //第一次进入界面首先选中第一个TAB
        changFragment(new Popularity_Fragment(),"Popularity_Fragment");
        mTabPopularity_tv.setTextColor(this.getResources().getColor(R.color.orange));
        mTabPopularity_tv.setBackgroundResource(R.drawable.tv_xiahuaxian);

        //第一次进入界面首先选中第一个TAB
        mTabPopularity_tv2.setTextColor(this.getResources().getColor(R.color.orange));
        mTabPopularity_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian);
    }


    @Override
    public void onClick(View v) {
        /*
        * 对两个TBA导航 监听 和 切换背景效果
        * 切换字体颜色
        * */
        if(v.getId()==R.id.home_tab_hot || v.getId()==R.id.home_tab_hot2){
            changFragment(new Popularity_Fragment(),"Popularity_Fragment");
            mTabPopularity_tv.setTextColor(this.getResources().getColor(R.color.orange));
            mTabNew_tv.setTextColor(Color.BLACK);
            mTabJindu_tv.setTextColor(Color.BLACK);
            mTabAll_tv.setTextColor(Color.BLACK);

            mTabPopularity_tv.setBackgroundResource(R.drawable.tv_xiahuaxian);
            mTabNew_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabJindu_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabAll_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);

            mTabPopularity_tv2.setTextColor(this.getResources().getColor(R.color.orange));
            mTabNew_tv2.setTextColor(Color.BLACK);
            mTabJindu_tv2.setTextColor(Color.BLACK);
            mTabAll_tv2.setTextColor(Color.BLACK);

            mTabPopularity_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian);
            mTabNew_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabJindu_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabAll_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);

        }else if(v.getId()==R.id.home_tab_new || v.getId()==R.id.home_tab_new2){
            changFragment(new New_Fragment(),"New_Fragment");
            mTabPopularity_tv.setTextColor(Color.BLACK);
            mTabNew_tv.setTextColor(this.getResources().getColor(R.color.orange));
            mTabJindu_tv.setTextColor(Color.BLACK);
            mTabAll_tv.setTextColor(Color.BLACK);

            mTabPopularity_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabNew_tv.setBackgroundResource(R.drawable.tv_xiahuaxian);
            mTabJindu_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabAll_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);

            mTabPopularity_tv2.setTextColor(Color.BLACK);
            mTabNew_tv2.setTextColor(this.getResources().getColor(R.color.orange));
            mTabJindu_tv2.setTextColor(Color.BLACK);
            mTabAll_tv2.setTextColor(Color.BLACK);

            mTabPopularity_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabNew_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian);
            mTabJindu_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabAll_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);

        }else if (v.getId()==R.id.home_tab_jindu || v.getId()==R.id.home_tab_jindu2){
            changFragment(new Jindu_Fragment(),"Jindu_Fragment");
            mTabPopularity_tv.setTextColor(Color.BLACK);
            mTabNew_tv.setTextColor(Color.BLACK);
            mTabJindu_tv.setTextColor(this.getResources().getColor(R.color.orange));
            mTabAll_tv.setTextColor(Color.BLACK);

            mTabPopularity_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabNew_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabJindu_tv.setBackgroundResource(R.drawable.tv_xiahuaxian);
            mTabAll_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);

            mTabPopularity_tv2.setTextColor(Color.BLACK);
            mTabNew_tv2.setTextColor(Color.BLACK);
            mTabJindu_tv2.setTextColor(this.getResources().getColor(R.color.orange));
            mTabAll_tv2.setTextColor(Color.BLACK);

            mTabPopularity_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabNew_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabJindu_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian);
            mTabAll_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);

        }else if (v.getId()==R.id.home_tab_all || v.getId()==R.id.home_tab_all2){
            changFragment(new All_Fragment(),"All_Fragment");
            mTabPopularity_tv.setTextColor(Color.BLACK);
            mTabNew_tv.setTextColor(Color.BLACK);
            mTabJindu_tv.setTextColor(Color.BLACK);
            mTabAll_tv.setTextColor(this.getResources().getColor(R.color.orange));
            mTabPopularity_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabNew_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabJindu_tv.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabAll_tv.setBackgroundResource(R.drawable.tv_xiahuaxian);

            mTabPopularity_tv2.setTextColor(Color.BLACK);
            mTabNew_tv2.setTextColor(Color.BLACK);
            mTabJindu_tv2.setTextColor(Color.BLACK);
            mTabAll_tv2.setTextColor(this.getResources().getColor(R.color.orange));
            mTabPopularity_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabNew_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabJindu_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            mTabAll_tv2.setBackgroundResource(R.drawable.tv_xiahuaxian);
        }



        switch (v.getId()){

            case R.id.home_class_ib:
                Intent intent = new Intent(getActivity(), ClassificationActivity.class);
                //startActivity(intent);
                startActivityForResult(intent,0);


                break;
            case R.id.home_search:
                Intent intent2 = new Intent(getActivity(), SearchActivity.class);
                //startActivity(intent);
                startActivityForResult(intent2,0);


                break;
            case R.id.home_back_top:
                myScrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        // 滚动至顶部
                        myScrollView.fullScroll(ScrollView.FOCUS_UP);
                        back_top.setVisibility(View.GONE);
                    }
                });


                break;
            case R.id.home_jumpnews:
                MainActivity main = (MainActivity) getActivity();
                main.setTab(1);

                break;

        }

    }

    //导航绑定Fragment 页面
    private void changFragment(Fragment fragment, String tag){
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.home_frameLayout,fragment,tag);
        ft.commit();



    }

    /*
    * 监听浮动view的滚动状态
    * ONTouch来监听Scroolview是否滑动到底部,并且显示返回顶部的图片
    * */
    public void ScroolViewListen (){

        //监听浮动view的滚动状态
        myScrollView.listenerFlowViewScrollState(topView, mFlowLayout);

        //ONTouch来监听Scroolview是否滑动到底部
        myScrollView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 监听滑动到头部与底部
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE: {
                        /**
                         * 1.getScrollY()获取滑动的距离 <br>
                         * 2.getHeight()获取在屏幕上显示的高度 <br>
                         * 3.getMeasureHeight()获取控件的真实高度(包含屏幕外的高度) <br>
                         */
                        if (myScrollView.getScrollY() <= 0) {
                            // 说明没有滑动，在屏幕顶部
                           // System.out.println("已经滑动到屏幕顶部");
                        }

                        // TODO: 获取ScrollView中包裹的View的高度！！！
                        int measuredHeight = myScrollView.getChildAt(0)
                                .getMeasuredHeight();
                        int scrollY = myScrollView.getScrollY();
                        int height = myScrollView.getHeight();
                        if (measuredHeight <= scrollY + height+10) {
                            // 已经滑动的距离+在屏幕上显示的高度>=控件真实高度。说明已经滑动到底部
                           // System.out.println("已经滑动到底部");
                            back_top.setVisibility(View.VISIBLE);
                            System.out
                                    .println("measuredHeight=" + measuredHeight
                                            + " scrollY= " + scrollY + " height= "
                                            + height);


                        }else {
                            back_top.setVisibility(View.GONE);
                        }

                        break;
                    }
                    default:
                        break;
                }
                return false;
            }
        });

    }



    Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    //刷新适配器
                    myAdapter.notifyDataSetChanged();
                    //优化刷新adapter的方法
                    // mRecommendActivitiesAdapter.notifyData();
                    break;
            }
            super.handleMessage(msg);
        }
    };
    /*
    *
    * 商品倒计时线程
    * */
    class MyThread implements Runnable{
        //用来停止线程
        boolean endThread;
        List<Home_recyclerview_commodity> datas;
        public MyThread(List<Home_recyclerview_commodity> datas){
            this.datas = datas;
        }
        @Override
        public void run() {
            while(!endThread){
                try{
                    //线程每秒钟执行一次
                    Thread.sleep(1000);
                    //遍历商品列表
                    for(int i = 0;i < datas.size();i++){
                        //拿到每件商品的时间差，转化为具体的多少天多少小时多少分多少秒
                        //并保存在商品time这个属性内
                        long counttime = datas.get(i).getCountTime();
                        long days = counttime / (1000 * 60 * 60 * 24);
                        long hours = (counttime-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                        long minutes = (counttime-days*(1000 * 60 * 60 * 24)
                                -hours*(1000* 60 * 60))/(1000* 60);
                        long second = (counttime-days*(1000 * 60 * 60 * 24)
                                -hours*(1000* 60 * 60)-minutes*(1000*60))/1000;
                        //并保存在商品time这个属性内
                        String second2 = second +"";
                        if(second<10){
                            second2="0"+second;
                        }
                        String finaltime = hours + ":" + minutes + ":" + second2 ;
                        datas.get(i).setTime(finaltime);
                       // Log.i("TIME", "run: "+finaltime);
                        //如果时间差大于1秒钟，将每件商品的时间差减去一秒钟，
                        // 并保存在每件商品的counttime属性内
                        if(counttime > 1000) {
                            datas.get(i).setCountTime(counttime - 1000);
                        }
                    }
                    Message message = new Message();
                    message.what = 1;
                    //发送信息给handler
                    handler.sendMessage(message);
                }catch (Exception e){
                }
            }
        }
    }
}













