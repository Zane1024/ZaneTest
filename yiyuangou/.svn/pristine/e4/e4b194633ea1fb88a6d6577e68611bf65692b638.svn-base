package com.example.em.mi.pig.com.shohuodizi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.em.mi.Fragment_1.FullyGridLayoutManager;
import com.example.em.mi.Fragment_1.Popularity_rvAdapter;
import com.example.em.mi.R;
import com.example.em.mi.bean.Participant_user;
import com.example.em.mi.pig.BaseAdapter.All_Participation_Records_BaseAdapter;
import com.example.em.mi.pig.BaseAdapter.Comm_MyAdapter_Viewpager;
import com.example.em.mi.pig.pigscrollview.MyScrollView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017-06-30.
 */

public class CommodityDetails extends Activity implements View.OnClickListener, MyScrollView.ScrollViewLine {
    /**
     * 三个分别  已经  准备  进行
     */
    private View commodity_yijing_include, commodity_zb_include, commodity_jingxing_include, commodity_details_1_viewpager_include;

    private ViewPager vp_guide;
    private List<ImageView> mImgList;//导航图集合
    private LinearLayout ll_container;//小圆点容器
    private int mCurrentIndex = 0;//当前小圆点的位置
    private int[] imgArray = {R.mipmap.guide_3, R.mipmap.guide_3, R.mipmap.guide_3, R.mipmap.guide_3};
    //找到include
    private View commoditylayout_include_4;
    //所有参与记录的listview
    private ListView commoditylistviews;
    //重写的滚动条
    private MyScrollView myScrollView;
    //头部背景
    private RelativeLayout commodity_title_bg;
    //返回按钮  主页按钮
    private ImageButton commodity_img_fanhui, commodity_home_imgbut;

    //本期参与记录 按钮
    private LinearLayout commodity_layout_allparticipation;

    //参与用户实体数据
    private List<Participant_user> user_list;
    //查看更多
    private TextView seeMore;

    //才你喜欢RecyclerView
    private RecyclerView guess_rv;
    //定义RecyclerView适配器
    private Popularity_rvAdapter rvAdapter;

    //猜你喜欢数据
    List<String> geess_datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commodity_details_1);


        //初始化数据
        initDatas();

        //初始化组件
        initView();

        //添加适配器和监听点击;
        initAdapter();

        /*
        * 如果参与用户大于5
        * 显示查看更多
        * */
        if (user_list.size()>5){
            seeMore.setVisibility(View.VISIBLE);
        }else {
            seeMore.setVisibility(View.GONE);
        }

        //滑动商品图片 Viewpager
        viewpager();

        //头部背景渐变  各种配置
        myScrollViwe();

    }
    //添加适配器和监听点击;
    private void initAdapter() {
        //找到ListView 通过适配器绑定
        //listview
        commoditylistviews = (ListView)this.findViewById(R.id.commoditylistviews);
        All_Participation_Records_BaseAdapter adapter = new All_Participation_Records_BaseAdapter(this,user_list,0);
        //根据listview 里面的 Item 数量 设置listview高度
        commoditylistviews.setAdapter(adapter);


        //猜你喜欢RecyclerView
        guess_rv = (RecyclerView)findViewById(R.id.commodity_GuessUlike_rv);

        /*
		* 设置布局管理器
		* 禁止Recyclerview滑动 解决卡顿问题
		* */
        FullyGridLayoutManager gridLayoutManager = new FullyGridLayoutManager(this, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };


        guess_rv.setLayoutManager(gridLayoutManager);

        //设置适配器
        rvAdapter = new Popularity_rvAdapter(geess_datas,this);
        guess_rv.setAdapter(rvAdapter);



    }


    //初始化组件
    private void initView() {
        //初始化
        commoditylayout_include_4 = this.findViewById(R.id.commoditylayout_include_4);
        //图片
        commodity_details_1_viewpager_include = this.findViewById(R.id.commodity_details_1_viewpager_include);
        vp_guide = (ViewPager) commodity_details_1_viewpager_include.findViewById(R.id.vp_guide);
        ll_container = (LinearLayout) findViewById(R.id.ll_container);

        commodity_layout_allparticipation = (LinearLayout) commoditylayout_include_4.findViewById(R.id.commodity_layout_allparticipation);

        seeMore = (TextView)this.findViewById(R.id.commodity_seeMore);

        //监听点击
        commodity_layout_allparticipation.setOnClickListener(this);
        seeMore.setOnClickListener(this);

    }

    //初始化参与用户数据
    private void initDatas() {
        user_list = new ArrayList<Participant_user>();
        Participant_user p1 = new Participant_user("猪");
        for (int i = 0; i <10 ; i++) {
            user_list.add(p1);
        }
        geess_datas = new ArrayList<String>();
        geess_datas.add("1");
        geess_datas.add("2");
        geess_datas.add("3");
        geess_datas.add("4");
        geess_datas.add("5");
        geess_datas.add("6");


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            //跳转到 所有参与记录
            case  R.id.commodity_layout_allparticipation:
                //All_Participation_Records_J
                Intent intent = new Intent(this,ZFB_Confirmed_J.class);
                startActivity(intent);
                break;
            case  R.id.commodity_seeMore:
                //All_Participation_Records_J
                Intent inten2 = new Intent(this,All_Participation_Records_J.class);
                startActivity(inten2);
                break;
        }
    }





    //滑动商品图片 Viewpager
    public void viewpager(){

        mImgList = new ArrayList<>();
        for (int i = 0; i < imgArray.length; i++) {
            ImageView imageView = new ImageView(this);//获取4个圆点
            imageView.setImageResource(imgArray[i]);
            mImgList.add(imageView);
            ImageView dot = new ImageView(this);
            if (i == mCurrentIndex) {
                dot.setImageResource(R.mipmap.page_indicator_focused);//设置当前页的圆点
            } else {
                dot.setImageResource(R.mipmap.page_indicator);//其余页的圆点
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout
                    .LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i > 0) {
                params.leftMargin = 10;//设置圆点边距
            }
            dot.setLayoutParams(params);
            ll_container.addView(dot);//将圆点添加到容器中
        }
        vp_guide.setAdapter(new Comm_MyAdapter_Viewpager(mImgList));
        //添加监听
        vp_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据监听的页面改变当前页对应的小圆点
                mCurrentIndex = position;
                for (int i = 0; i < ll_container.getChildCount(); i++) {
                    ImageView imageView = (ImageView) ll_container.getChildAt(i);
                    if (i == position) {
                        imageView.setImageResource(R.mipmap.page_indicator_focused);
                    } else {
                        imageView.setImageResource(R.mipmap.page_indicator);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //*************头部背景渐变
    public void myScrollViwe(){

        setTitleLayout(findViewById(R.id.commodity_title_bg));
        commodity_title_bg = (RelativeLayout)findViewById(R.id.commodity_title_bg);
        commodity_img_fanhui = (ImageButton)findViewById(R.id.commodity_img_fanhui);
        commodity_home_imgbut = (ImageButton)findViewById(R.id.commodity_home_imgbut);
        //头部获取焦点，防止listview抢焦点
        commodity_title_bg.setFocusable(true);
        commodity_title_bg.setFocusableInTouchMode(true);
        commodity_title_bg.requestFocus();
        commodity_title_bg.getBackground().setAlpha(0);//开始是透明的
        //头部获取焦点，防止listview抢焦点
        commodity_img_fanhui.setFocusable(true);
        commodity_img_fanhui.setFocusableInTouchMode(true);
        commodity_img_fanhui.requestFocus();
        commodity_img_fanhui.getBackground().setAlpha(0);//开始是透明的
        //头部获取焦点，防止listview抢焦点
        commodity_home_imgbut.setFocusable(true);
        commodity_home_imgbut.setFocusableInTouchMode(true);
        commodity_home_imgbut.requestFocus();
        commodity_home_imgbut.getBackground().setAlpha(0);//开始是透明的
        myScrollView = (MyScrollView) findViewById(R.id.commodity_scrollview);
        myScrollView.setScrollViewLine(this);


    }
    //透明度设置
    @Override
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (oldt < 750 && oldt > 10) {
            commodity_title_bg.getBackground().setAlpha((int) (oldt / 3));
            commodity_img_fanhui.getBackground().setAlpha((int) (oldt / 3));
            commodity_home_imgbut.getBackground().setAlpha((int) (oldt / 3));
        } else if (oldt < 20) {
            commodity_title_bg.getBackground().setAlpha(0);
            commodity_img_fanhui.getBackground().setAlpha(0);
            commodity_home_imgbut.getBackground().setAlpha(0);
        } else if (oldt >= 750) {
            commodity_title_bg.getBackground().setAlpha(255);
            commodity_img_fanhui.getBackground().setAlpha(255);
            commodity_home_imgbut.getBackground().setAlpha(255);
        }
    }
   //获取屏幕高宽度
    protected void setTitleLayout(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int statusBarHeight = getStatusBarHeight(this.getBaseContext());
            view.setPadding(0, statusBarHeight, 0, 0);

        }
    }
    /**
     * 获取状态栏高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
        //状态栏渐变结束*******************
    }
}
