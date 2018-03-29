package com.example.em.mi.Fragment_4;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.em.mi.Fragment_4.amount.AmountView;
import com.example.em.mi.MainActivity;
import com.example.em.mi.R;
import com.example.em.mi.bean.Commodity;
import com.example.em.mi.pig.SwipeMenuListView_bao.SwipeMenu;
import com.example.em.mi.pig.SwipeMenuListView_bao.SwipeMenuCreator;
import com.example.em.mi.pig.SwipeMenuListView_bao.SwipeMenuItem;
import com.example.em.mi.pig.SwipeMenuListView_bao.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;


public class Fragment_4 extends Fragment implements View.OnClickListener,AmountView.OnAmountChangeListener{
    //声明组件
    private RecyclerView mRecyclerView;
    private Inventory_recyclerviewAdapter myrecyclerviewAdapter;
    private Button duobao;
    private TextView sumprice;
    private Context context;
    //数据
    List<Integer> list;
    List<Commodity> datas;
    //主视图   有东西include组件
    View view, inventory_nonempty;
    //有商品界面ListView
    SwipeMenuListView listView;
    Inventory_lvAdapter ad;
    int sum;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_4,null);
         sum = 0;
        //初始化数据
        initDatas();

        //得到控件
        initView();
        //保存总价
        for (int i = 0; i < datas.size(); i++) {
            sum += datas.get(i).getBuy_number();

        }
        sumprice.setText(sum+"");

       /* // 通过适配器 绑定数据
        Inventory_lvAdapter ad = new Inventory_lvAdapter(getContext(), datas,this);
        listView.setAdapter(ad);*/


        myrecyclerviewManager();

        //滑动列表
        SwipeMenuCreatorss();


        return view;
    }
    //得到控件
    private void initView() {

        mRecyclerView = (RecyclerView)view.findViewById(R.id.inventory_recyclerview);
        duobao = (Button) view.findViewById(R.id.inventory_duobao);

        //listView = (ListView)view.findViewById(R.id.inventory_listview);

        sumprice = (TextView)view.findViewById(R.id.inventory_sumprice);




        //设置监听
        duobao.setOnClickListener(this);

    }


    public void  initDatas(){
        //无商品猜你喜欢RecyclerView数据
        list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        datas = new ArrayList<Commodity>();
        Commodity data1 =  new Commodity("APPLE Iphone 128G 红色",R.mipmap.img2,1000,500);
        data1.setBuy_number(20);
        data1.setPrice(2);
        Commodity data2 =  new Commodity("Iphone 128G 红色",R.mipmap.img2,1000,400);
        data2.setBuy_number(30);
        data2.setPrice(3);
        Commodity data3 =  new Commodity("Iphone 128G 红色",R.mipmap.img2,1000,400);
        data3.setBuy_number(40);
        data3.setPrice(3);
        Commodity data4 =  new Commodity("Iphone 128G 红色",R.mipmap.img2,1000,400);
        data3.setBuy_number(50);
        data3.setPrice(3);
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);

    }
    //设置布局管理器,适配器
    private void myrecyclerviewManager (){

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        //设置适配器
        myrecyclerviewAdapter = new Inventory_recyclerviewAdapter(list,view.getContext());
        mRecyclerView.setAdapter(myrecyclerviewAdapter);

    }
    //实现购物车加减组件监听借口
    @Override
    public void onAmountChange(View view, int amount) {

        int poa = (Integer) view.getTag();
        datas.get(poa).setBuy_number(amount);
        Log.i("t", "onAmountChange: "+poa+amount);


        Toast.makeText(getContext(),amount+"数量,第"+poa+"个LIST",Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inventory_duobao:
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.setTab(0);
                break;

        }

    }

    /**
     * 滑动列表
     */
    // 滑动
    public void SwipeMenuCreatorss(){
        //SwipeMenuCreator 滑动
        final SwipeMenuCreator creator = new SwipeMenuCreator() {

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

                SwipeMenuItem deleteItem = new SwipeMenuItem(view.getContext());
                deleteItem.setBackground(new ColorDrawable(Color.LTGRAY));
                deleteItem.setWidth(dp2px(90));
                deleteItem.setIcon(R.mipmap.shuxie);
                menu.addMenuItem(deleteItem);
            }


        };
        //inventory_nonempty = (View)view.findViewById(R.id.inventory_nonempty);
        //初始化 SwipeMenuListView 组件
         listView = (SwipeMenuListView) view.findViewById(R.id.inventory_listview);
        listView.setMenuCreator(creator);
        //为菜单设置监听事件
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu,int index) {
                //index的值就是在SwipeMenu依次添加SwipeMenuItem顺序值，类似数组的下标。
                //从0开始，依次是：0、1、2、3...
                switch (index) {
                    case 0:

                        datas.remove(position);
                        ad.notifyDataSetChanged();
                        Toast.makeText(view.getContext(), "打开:"+position,Toast.LENGTH_SHORT).show();
                        break;

                    /*case 1:
                        Toast.makeText(view.getContext(), "删除:"+position,Toast.LENGTH_SHORT).show();
                        break;*/
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

        // 通过适配器 绑定数据s
        ad = new Inventory_lvAdapter(getContext(), datas,this);
        listView.setAdapter(ad);
    }

    //计算 宽
    public int dp2px(float dipValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
