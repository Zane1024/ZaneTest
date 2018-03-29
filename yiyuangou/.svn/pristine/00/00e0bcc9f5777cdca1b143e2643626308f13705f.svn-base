package com.example.em.mi.Fragment_1.search;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.em.mi.Fragment_1.search.search_history.FlowLayout;
import com.example.em.mi.R;
import com.example.em.mi.bean.Commodity;
import com.example.em.mi.sqlite.RecordSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
//搜索界面
public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    //返回
    private ImageView back;
    //搜索
    private TextView  search;
    //输入框
    private EditText search_et;
    //搜索结果LISTVIEW
    private ListView mlistview;
    //输入框清除
    private ImageView delete;
    //结果适配器
    private Search_lvAdapter search_lvAdapter;
    //清除历史
    private Button clear;
    //数据
    private List<Commodity> datas;
    //搜索历史/搜索结果
    View include1,include2;


    /*
    * 流式布局搜索历史所用到的组件
    * */
    private FlowLayout mFlowLayout;
    private LayoutInflater mInflater;
    //储存搜索历史
    private List<String>  history = new ArrayList<String>();;


    /*数据库变量*/
    private RecordSQLiteOpenHelper helper ;
    private SQLiteDatabase db;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_1_search);
        //初始化数据
        initDatas();
        //初始化组件
        init();
        //实例化数据库SQLiteOpenHelper子类对象
        helper = new RecordSQLiteOpenHelper(this);
        //查询所有的搜索历史
        chauxn();
        //对EditText 进行监听
        edittext_Onclick();
        //初始化流式布局搜索历史
        initFlowView();




    }
    //初始化组件
    private void init(){
        back = (ImageView)findViewById(R.id.search_back);
        search = (TextView)findViewById(R.id.search_search);
        search_et = (EditText)findViewById(R.id.search_edittext);
        include1 = (View)findViewById(R.id.search_include1);
        include2 = (View)findViewById(R.id.search_include2);
        delete = (ImageView)findViewById(R.id.search_delete);
        clear = (Button)findViewById(R.id.search_clear);

        delete.setOnClickListener(this);
        back.setOnClickListener(this);
        search.setOnClickListener(this);
        clear.setOnClickListener(this);

        mlistview = (ListView)findViewById(R.id.search_listview);
        search_lvAdapter = new Search_lvAdapter(this,datas);
        mlistview.setAdapter(search_lvAdapter);



    }


    //初始化流式布局搜索历史
    private void initFlowView() {
        mInflater = LayoutInflater.from(this);
        mFlowLayout = (FlowLayout) findViewById(R.id.flowlayout);
        initData();

    }

    /**
     * 将数据放入流式布局
     */
    private void initData() {
        for (int i = 0; i < history.size(); i++) {
            TextView tv = (TextView) mInflater.inflate(
                    R.layout.search_history_label_tv, mFlowLayout, false);
            tv.setText(history.get(i));
            final String str = tv.getText().toString();
            //点击事件
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //加入搜索历史纪录记录
                    Toast.makeText(SearchActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            });
            mFlowLayout.addView(tv);
        }
    }




    //监听按钮
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_back:
                SearchActivity.this.finish();
                //Toast.makeText(this,"BACK",Toast.LENGTH_SHORT).show();

                break;
            case R.id.search_search:
               /* include1.setVisibility(View.GONE);
                include2.setVisibility(View.VISIBLE);*/
                //调用搜索逻辑
                search();

                break;
            case R.id.search_delete:
                search_et.setText("");
                break;
            case R.id.search_clear:

                deleteData();
                history.removeAll(history);
                mFlowLayout.removeAllViews();
                break;

        }

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

    //对EditText 事件的监听
    private void edittext_Onclick (){
         /*
        * 监听EditText是否有长度 并设置deldte 的可见或不可见
        * */
        search_et.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    delete.setVisibility(View.GONE);
                } else {
                    delete.setVisibility(View.VISIBLE);
                }
            }
        });


        /*
        * 监听软键盘的回车
        * */
        search_et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //写入搜索操作和数据库插入搜索记录操作
                    search();

                }

                return false;
            }
        });

    }

    /*插入数据*/
    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
        Toast.makeText(SearchActivity.this,"成功",Toast.LENGTH_SHORT).show();
    }


/*    *//*模糊查询数据*//*
    private void queryData(String tempName) {

        //模糊搜索
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);

    }*/


    /*检查数据库中是否已经有该条记录*/
    private boolean hasData(String tempName) {
        //从Record这个表里找到name=tempName的id
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{tempName});
        //判断是否有下一个
        return cursor.moveToNext();
    }

    /*清空数据*/
    private void deleteData() {
        db = helper.getWritableDatabase();
        db.execSQL("delete from records");
        db.close();
    }
    /*
    *
    * 查询出最近10条搜索历史
    * */

    private void chauxn(){
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from records", null);

        while (cursor.moveToNext()) {

            int personid = cursor.getInt(0); //获取第一列的值,第一列的索引从0开始

            String name = cursor.getString(1);//获取第二列的值

            Log.i("chaxun", "chauxn: "+personid+name);

            history.add(name);

        }

        cursor.close();

        db.close();

    }


    /*
    * 查询搜索历史
    * 判断输入框是否为空
    * 判断数据库是否存在此搜索名词
    * */
    private void search(){

        if (search_et.length()!=0) {
            boolean hasData = hasData(search_et.getText().toString().trim());
            if (!hasData) {
                insertData(search_et.getText().toString().trim());
            }
            include1.setVisibility(View.GONE);
            include2.setVisibility(View.VISIBLE);
        }else {
            Toast.makeText(SearchActivity.this,"请输入搜索内容",Toast.LENGTH_SHORT).show();
        }

    }





}
