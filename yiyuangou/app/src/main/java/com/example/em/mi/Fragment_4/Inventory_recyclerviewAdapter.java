package com.example.em.mi.Fragment_4;

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

public class Inventory_recyclerviewAdapter extends RecyclerView.Adapter<Inventory_recyclerviewAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Integer> datas;
    public Inventory_recyclerviewAdapter(List<Integer> list, Context context) {
        this.datas = list;
        this.inflater = LayoutInflater.from(context);;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public Inventory_recyclerviewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflater.from(viewGroup.getContext()).inflate(R.layout.fragment_inventory_recyclerview_item,viewGroup,false);
        Inventory_recyclerviewAdapter.ViewHolder vh = new Inventory_recyclerviewAdapter.ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(Inventory_recyclerviewAdapter.ViewHolder viewHolder, int position) {



    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public TextView about;
        public ImageView mImageView;

        public ViewHolder(View view){
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.inventory_recyclerview_item_img);
            title = (TextView) view.findViewById(R.id.inventory_recyclerview_item_titile);
            about = (TextView) view.findViewById(R.id.inventory_recyclerview_item_about);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(inflater.getContext(),"第"+title.getText().toString(), Toast.LENGTH_SHORT).show();


        }
    }

}