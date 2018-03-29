package com.example.em.mi.pig.BaseAdapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.em.mi.R;


import java.util.List;

/**
 * Created by Administrator on 2017-06-30.
 */

public class Add_Delivery_Address_BaseAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context context;

    public Add_Delivery_Address_BaseAdapter(Context context){
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.add_delivery_address_item, null);
            holder.add_item_img_moren = (ImageView)convertView.findViewById(R.id.add_item_img_moren);
            holder.add_item_name = (TextView)convertView.findViewById(R.id.add_item_name);
            holder.add_item_phone = (TextView)convertView.findViewById(R.id.add_item_phone);
            holder.add_item_dizhi = (TextView)convertView.findViewById(R.id.add_item_dizhi);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.add_item_img_moren.setImageResource(R.mipmap.moren);
        holder.add_item_name.setText("小明");
        holder.add_item_phone.setText("13726485977");
        holder.add_item_dizhi.setText("广东省广州市番禺区上城国际");


    return convertView;
    }
        /**
         *  ImageView add_item_img_moren;默认图标
         *              名字              电话          地址
         *  TextView add_item_name, add_item_phone, add_item_dizhi;
         */

    class ViewHolder {
        ImageView add_item_img_moren;
        TextView add_item_name, add_item_phone, add_item_dizhi;


    }

}
