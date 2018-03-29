package com.example.em.mi.pig.com.shohuodizi;
//收货地址管理

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.em.mi.R;
import com.example.em.mi.pig.BaseAdapter.Add_Delivery_Address_BaseAdapter;
import com.example.em.mi.pig.SwipeMenuListView_bao.SwipeMenu;
import com.example.em.mi.pig.SwipeMenuListView_bao.SwipeMenuCreator;
import com.example.em.mi.pig.SwipeMenuListView_bao.SwipeMenuItem;
import com.example.em.mi.pig.SwipeMenuListView_bao.SwipeMenuListView;




//import static com.example.em.mi.R.id.add_delivery_swipemenuListview;


/**
 * Created by Administrator on 2017-06-30.
 * 收货地址管理
 */

public class DeliveryAddress extends ActionBarActivity implements View.OnClickListener{
    /**
     * add_delivery_add_button 添加收货地址
     *
     */
    private Button add_delivery_add_button;
    private View include_button;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.add_delivery_address);

        //初始化
        add_delivery_add_button = (Button) findViewById(R.id.add_delivery_add_button);

        add_delivery_add_button.setOnClickListener(this);
        // 滑动
        SwipeMenuCreatorss();



        }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //add_delivery_add_button 添加收货地址
            case R.id.add_delivery_add_button:

                Intent add_button = new Intent(DeliveryAddress.this, Add_Dizhi_Info.class);
                startActivity(add_button);
                break;
        }
    }

    // 滑动
    public void SwipeMenuCreatorss(){
        //SwipeMenuCreator 滑动
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                //创建一个菜单条
               /* SwipeMenuItem openItem = new SwipeMenuItem(context);
                // 设置菜单的背景
                openItem.setBackground(new ColorDrawable(Color.GREEN));
                // 宽度  菜单的宽度是一定要有的，否则不显示菜单
                openItem.setWidth(dp2px(90));
                openItem.setTitle("打开");
                openItem.setTitleSize(20);
                // 标题的颜色
                openItem.setTitleColor(Color.WHITE);
                // 添加到menu
                menu.addMenuItem(openItem);*/

                SwipeMenuItem deleteItem = new SwipeMenuItem(context);
                deleteItem.setBackground(new ColorDrawable(Color.LTGRAY));
                deleteItem.setWidth(dp2px(90));
                deleteItem.setIcon(R.mipmap.shuxie);
                menu.addMenuItem(deleteItem);
            }


        };
        //初始化 SwipeMenuListView 组件
        SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.add_delivery_swipemenuListview);
        listView.setMenuCreator(creator);
        //为菜单设置监听事件
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu,int index) {
                //index的值就是在SwipeMenu依次添加SwipeMenuItem顺序值，类似数组的下标。
                //从0开始，依次是：0、1、2、3...
                switch (index) {
                    case 0:
                        Toast.makeText(context, "打开:"+position,Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        Toast.makeText(context, "删除:"+position,Toast.LENGTH_SHORT).show();
                        break;
                }

                // false : 当用户触发其他地方的屏幕时候，自动收起菜单。
                // true : 不改变已经打开菜单的样式，保持原样不收起。
                return false;
            }
        });

        // 监测用户在ListView的SwipeMenu侧滑事件。
        listView.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {

            @Override
            public void onSwipeStart(int pos) {
                Log.d("位置:" + pos, "开始侧滑...");
            }

            @Override
            public void onSwipeEnd(int pos) {
                Log.d("位置:" + pos, "侧滑结束.");
            }
        });

        //测试数据集。
        String[] data = new String[30];
        for (int i = 0; i < data.length; i++) {
            data[i] = "测试数据:" + i;
        }

        // 通过适配器 绑定数据
        Add_Delivery_Address_BaseAdapter add_delivery_address_baseAdapter = new Add_Delivery_Address_BaseAdapter(this);
        listView.setAdapter(add_delivery_address_baseAdapter);

    }

    //计算 宽
    public int dp2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
