package com.example.em.mi.pig.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.em.mi.R;

/**
 * Created by Administrator on 2017-07-04.
 */

public class Lucky_Record_J_BaseAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    public Lucky_Record_J_BaseAdapter(Context context){
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

        if (convertView == null){

            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.lucky_record_item,null);
            holder.lucky_item_img_commodity = (ImageView)convertView.findViewById(R.id.lucky_item_img_commodity);
            holder.lucky_item_img_yiling = (ImageView)convertView.findViewById(R.id.lucky_item_img_yiling);
            holder.lucky_item_tv_title = (TextView)convertView.findViewById(R.id.lucky_item_tv_title);
            holder.lucky_item_tv_number = (TextView)convertView.findViewById(R.id.lucky_item_tv_number);
            holder.lucky_item_tv_canyu = (TextView)convertView.findViewById(R.id.lucky_item_tv_canyu);
            holder.lucky_item_tv_name = (TextView)convertView.findViewById(R.id.lucky_item_tv_name);
            holder.lucky_item_btn = (Button)convertView.findViewById(R.id.lucky_item_btn);
            convertView.setTag(holder);

        }else{

            holder = (ViewHolder)convertView.getTag();

        }

        holder.lucky_item_img_commodity.setImageResource(R.mipmap.shangping);
        holder.lucky_item_img_yiling.setImageResource(R.mipmap.yilingqu);
        holder.lucky_item_tv_title.setText("五福临门 广东大米 优质选择 大米 4kg");
        holder.lucky_item_tv_number.setText("期号：101239");
        holder.lucky_item_tv_canyu.setText("我已参与：36人次");
        holder.lucky_item_tv_name.setText("获得者：华华");

        return convertView;
    }

    //定义各种属性
    class ViewHolder{
        //商品图片   已领取
        ImageView lucky_item_img_commodity, lucky_item_img_yiling;
        //标题    期号   参与次数   获得者
        TextView lucky_item_tv_title, lucky_item_tv_number, lucky_item_tv_canyu, lucky_item_tv_name;
        //继续买按钮
        Button lucky_item_btn;
    }
}
