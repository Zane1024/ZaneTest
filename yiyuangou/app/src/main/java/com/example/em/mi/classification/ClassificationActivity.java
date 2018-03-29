package com.example.em.mi.classification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.example.em.mi.MainActivity;
import com.example.em.mi.R;

/**
 * Created by pc on 2017/6/26.
 */

public class ClassificationActivity extends FragmentActivity implements View.OnClickListener {
    private String[] strs = { "常用分类", "服饰内衣", "鞋靴", "手机", "家用电器", "数码", "电脑办公",
            "个护化妆", "图书" };
    private ListView listView;
    private Myclass_listviewAdapter adapter;
    private Myclass_Fragment myFragment;
    private ImageButton  imgbtn_back,imgbtn_gouwuche;

    public static int mPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classification);
        initView();



    }

    /**
     * 初始化view
     */
    private void initView() {
        // TODO Auto-generated method stub
        listView = (ListView) findViewById(R.id.class_listview);
        imgbtn_back = (ImageButton)findViewById(R.id.class_back);
        imgbtn_gouwuche = (ImageButton)findViewById(R.id.class_gouwuche);
        adapter = new Myclass_listviewAdapter(this, strs);
        listView.setAdapter(adapter);
        listView.setSelection(0);


        //创建MyFragment对象
        myFragment = new Myclass_Fragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.replace(R.id.class_fragment_container, myFragment);
        //通过bundle传值给MyFragment
        Bundle bundle = new Bundle();
        bundle.putString(Myclass_Fragment.TAG, strs[mPosition]);
        myFragment.setArguments(bundle);
        fragmentTransaction.commit();

        //设置监听
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //拿到当前位置
                mPosition = position;
                //即使刷新adapter
                adapter.notifyDataSetChanged();
                for (int i = 0; i < strs.length; i++) {
                    myFragment = new Myclass_Fragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                            .beginTransaction();
                    fragmentTransaction.replace(R.id.class_fragment_container, myFragment);
                    Bundle bundle = new Bundle();
                    bundle.putString(Myclass_Fragment.TAG, strs[position]);
                    myFragment.setArguments(bundle);
                    fragmentTransaction.commit();
                }
            }
        });

        //设置顶部点击事件
        imgbtn_back.setOnClickListener(this);
        imgbtn_gouwuche.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.class_back:
                    ClassificationActivity.this.finish();
                break;
            case R.id.class_gouwuche:
               // Toast.makeText(ClassificationActivity.this,"购物车", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(ClassificationActivity.this,MainActivity.class);

                intent.putExtra("pagenum",3);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

                break;
        }

    }
}
