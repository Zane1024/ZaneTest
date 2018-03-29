package com.example.em.mi.Fragment_5.ho.participation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.em.mi.R;

/**
 * Created by Administrator on 2017/6/28.
 */
//参与记录界面
public class ParticipationActivity extends FragmentActivity implements View.OnClickListener{

    //声明顶部导航的TextView;
    private TextView all,now,open;

    //返回图片
    ImageView back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participation);
        //初始化组件
        initView();
        //初次进来显示第一个页面
        changFragment(new Participation_all_fragment(),"Participation_all_fragment");

    }
    //初始化组件
    private void initView() {
        all = (TextView)findViewById(R.id.participation_tab_all);
        now = (TextView)findViewById(R.id.participation_tab_now);
        open = (TextView)findViewById(R.id.participation_tab_open);
        back =(ImageView)findViewById(R.id.participation_back);

        all.setOnClickListener(this);
        now.setOnClickListener(this);
        open.setOnClickListener(this);
        back.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.participation_tab_all:
                changFragment(new Participation_all_fragment(),"Participation_all_fragment");
                all.setTextColor(this.getResources().getColor(R.color.orange));
                now.setTextColor(Color.BLACK);
                open.setTextColor(Color.BLACK);


                all.setBackgroundResource(R.drawable.tv_xiahuaxian);
                now.setBackgroundResource(R.drawable.tv_xiahuaxian2);
                open.setBackgroundResource(R.drawable.tv_xiahuaxian2);


                break;
            case R.id.participation_tab_now:
                changFragment(new Participation_now_fragment(),"Participation_now_fragment");
                now.setTextColor(this.getResources().getColor(R.color.orange));
                all.setTextColor(Color.BLACK);
                open.setTextColor(Color.BLACK);


                now.setBackgroundResource(R.drawable.tv_xiahuaxian);
                all.setBackgroundResource(R.drawable.tv_xiahuaxian2);
                open.setBackgroundResource(R.drawable.tv_xiahuaxian2);

                break;
            case R.id.participation_tab_open:
                changFragment(new Participation_open_fragment(),"Participation_open_fragment");
                open.setTextColor(this.getResources().getColor(R.color.orange));
                now.setTextColor(Color.BLACK);
                all.setTextColor(Color.BLACK);


                open.setBackgroundResource(R.drawable.tv_xiahuaxian);
                now.setBackgroundResource(R.drawable.tv_xiahuaxian2);
                all.setBackgroundResource(R.drawable.tv_xiahuaxian2);

                break;
            case R.id.participation_back:
                ParticipationActivity.this.finish();

                break;
        }

    }
    //导航绑定Fragment 页面
    private void changFragment(Fragment fragment, String tag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.participation_frameLayout,fragment,tag);
        ft.commit();



    }
}
