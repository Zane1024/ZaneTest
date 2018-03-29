package com.example.em.mi.Fragment_1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.em.mi.R;

import java.util.List;

/**
 * Created by pc on 2017/6/22.
 */

public class Home_recyclerviewAdapter extends RecyclerView.Adapter<Home_recyclerviewAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Home_recyclerview_commodity> datas;
    public Home_recyclerviewAdapter( List<Home_recyclerview_commodity> datas, Context context) {
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public Home_recyclerviewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflater.from(viewGroup.getContext()).inflate(R.layout.home_recyclerview_item,viewGroup,false);
        Home_recyclerviewAdapter.ViewHolder vh = new Home_recyclerviewAdapter.ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(Home_recyclerviewAdapter.ViewHolder viewHolder, int position) {

        viewHolder.title.setText(datas.get(position).getTime());




    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public ImageView mImageView;

        public ViewHolder(View view){
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.home_recyclerview_iv);
            title = (TextView) view.findViewById(R.id.home_recyclerview_time_tv);


            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(inflater.getContext(),"第"+title.getText(), Toast.LENGTH_SHORT).show();


        }
    }

}