package com.example.em.mi.pig.BaseAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.em.mi.R;

/**
 * 绑定晒单数据
 * Created by Administrator on 2017-07-04.
 */
public class Fragment_5_The_Sun_BaseAdapter extends BaseAdapter {

    private Context context;

    private LayoutInflater inflater;

    public Fragment_5_The_Sun_BaseAdapter (Context context){
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 2;
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

        if(convertView == null){

            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.fragment_5_the_sun_item,null);
            //初始化组件
            holder.f5_the_sun_item_img1 = (ImageView)convertView.findViewById(R.id.f5_the_sun_item_img1);
            holder.f5_the_sun_item_img2 = (ImageView)convertView.findViewById(R.id.f5_the_sun_item_img2);
            holder.f5_the_sun_item_img3 = (ImageView)convertView.findViewById(R.id.f5_the_sun_item_img3);

            holder.f5_the_sun_item_ri = (TextView)convertView.findViewById(R.id.f5_the_sun_item_ri);
            holder.f5_the_sun_item_yue = (TextView)convertView.findViewById(R.id.f5_the_sun_item_yue);
            holder.f5_the_sun_item_tilie = (TextView)convertView.findViewById(R.id.f5_the_sun_item_tilie);
            holder.f5_the_sun_item_contxt = (TextView)convertView.findViewById(R.id.f5_the_sun_item_contxt);
            holder.f5_the_sun_item_dai = (TextView)convertView.findViewById(R.id.f5_the_sun_item_dai);
            holder.f5_the_sun_item_oncemore = (Button)convertView.findViewById(R.id.f5_the_sun_item_oncemore);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        //绑定数据
        holder.f5_the_sun_item_img1.setImageResource(R.mipmap.welcome);
        holder.f5_the_sun_item_img2.setImageResource(R.mipmap.bianxing);
        holder.f5_the_sun_item_img3.setImageResource(R.mipmap.test);
        holder.f5_the_sun_item_ri.setText("32");
        holder.f5_the_sun_item_yue.setText("7月");
        holder.f5_the_sun_item_tilie.setText("获得商品：五福临门 广东大米 优质湛江 大米 4kg");
        holder.f5_the_sun_item_contxt.setText("种种因素，让绝大多数湛江人从没有吃到过真正的“鲜" +
                "米”——粒粒好米，新鲜可口，甚至不用菜就能吃一大碗，这是一些品尝过高级优质米的专家形容的体验");
        holder.f5_the_sun_item_dai.setText("小明不通过");


        return convertView;
    }

    class ViewHolder{
        //日    月     商品标题    内容
        private TextView f5_the_sun_item_ri, f5_the_sun_item_yue, f5_the_sun_item_tilie,
        f5_the_sun_item_contxt, f5_the_sun_item_dai;
        //商品 1 - 3 图片
        private ImageView f5_the_sun_item_img1, f5_the_sun_item_img2, f5_the_sun_item_img3;
        //再试一次
        private Button f5_the_sun_item_oncemore;





    }

}
