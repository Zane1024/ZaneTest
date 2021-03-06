package com.example.em.mi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.em.mi.Fragment_1.FloatView.FxService;
import com.example.em.mi.Fragment_1.Fragment_1;
import com.example.em.mi.Fragment_2.Fragment_2;
import com.example.em.mi.Fragment_3.Fragment_3;
import com.example.em.mi.Fragment_4.Fragment_4;
import com.example.em.mi.Fragment_5.Fragment_5;

public class MainActivity extends FragmentActivity {
    // 定义FragmentTabHost对象
    private FragmentTabHost mTabHost;

    // 定义一个布局
    private LayoutInflater layoutInflater;

    // 定义数组来存放Fragment界面
    private Class fragmentArray[] = { Fragment_1.class,
            Fragment_2.class, Fragment_3.class, Fragment_4.class
            ,Fragment_5.class};

    // 定义数组来存放按钮图片
    private int mImageViewArray[] = { R.drawable.main_tab_item_home,
            R.drawable.main_tab_item_news, R.drawable.main_tab_item_down,
            R.drawable.main_tab_item_setting, R.drawable.main_tab_item_user };

    // Tab选项卡的文字
    private String mTextviewArray[] = { "首页", "最新揭晓", "发现", "清单", "我" };

    TextView msgTV;

    int pagenum = 0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();

       pagenum = intent.getIntExtra("pagenum",0);

        //启动浮动窗口
        Intent intent = new Intent(MainActivity.this, FxService.class);
        startService(intent);


        initView();

        /*
        * 设置Tab小红点上面的数值
        * */

        int count = 2;

        if (count == 0) {
            msgTV.setVisibility(View.GONE);
        } else {
            msgTV.setVisibility(View.VISIBLE);
            if (count > 99) {
                msgTV.setText("99+");
            } else {
                msgTV.setText(String.valueOf(count));
            }
        }
    }
    /**
     * 初始化组件
     */
    private void initView() {
        // 实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        // 实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        // 得到fragment的个数
        int count = fragmentArray.length;

        for (int i = 0; i < count; i++) {
            // 为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i])
                    .setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            // 设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.main_tab_item_bg);
            mTabHost.getTabWidget().setDividerDrawable(R.color.white);
        }
        mTabHost.setCurrentTab(pagenum);
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);
            //清单页面上的小红点
        if(index == 3){
            msgTV = (TextView) view.findViewById(R.id.tab_hongdian);
        }

        return view;
    }
    /*
    * 给Fragment 跳转 Fragment 使用的方法
    * */

    public void setTab(int tab){
        mTabHost.setCurrentTab(tab);

    }




}
