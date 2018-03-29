package com.example.em.mi.pig.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.em.mi.R;
import com.example.em.mi.bean.Participant_user;

import java.util.List;

/**
 * 绑定所有参与记录BaseAdapter
 * Created by Administrator on 2017-07-04.
 */

public class All_Participation_Records_BaseAdapter extends BaseAdapter {

    private Context context;

    private LayoutInflater inflater;

    List<Participant_user> list;
    /*
    * 用于保存类型
    * 0表示详情页
    * 1表示全部参与页面
    * */
    int type = 0;

    public All_Participation_Records_BaseAdapter(Context context, List<Participant_user> list,int type){
        this.inflater = LayoutInflater.from(context);
        this.list = list;
        this.type = type;
    }

    @Override
    public int getCount() {
        //根据类型判断ListView 所需要的长度
        if(type==0) {
            if (list.size() < 5) {
                return list.size();
            } else {
                return 5;
            }
        }else {
            return list.size();
        }
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
            convertView = inflater.inflate(R.layout.commodity_details_4_item,null);

            holder.all_participation_records_img_touxiang = (ImageView)convertView.findViewById(R.id.all_participation_records_img_touxiang);
            //holder.all_participation_records_img_vip = (ImageView)convertView.findViewById(R.id.all_participation_records_img_vip);

            holder.all_participation_records_tv_name = (TextView)convertView.findViewById(R.id.all_participation_records_tv_name);
            holder.all_participation_records_tv_ip = (TextView)convertView.findViewById(R.id.all_participation_records_tv_ip);
            holder.all_participation_records_tv_number = (TextView)convertView.findViewById(R.id.all_participation_records_tv_number);
            holder.all_participation_records_tv_time = (TextView)convertView.findViewById(R.id.all_participation_records_tv_time);
            /**
             *  convertView.setTag(holder); 这个一定要加  不然滑动报错
             */
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.all_participation_records_img_touxiang.setImageResource(R.mipmap.test);
        holder.all_participation_records_tv_name.setText("小明同学");
        holder.all_participation_records_tv_ip.setText("192.168.1.2");
        holder.all_participation_records_tv_number.setText("参与了32人次");
        holder.all_participation_records_tv_time.setText("2017-07-04-14:35:15");


        return convertView;
    }

    class ViewHolder{
        //头像   会员等级 all_participation_records_img_vip
        private ImageView all_participation_records_img_touxiang;
        //昵称   IP   参与次数  时间
        private TextView all_participation_records_tv_name, all_participation_records_tv_ip,
        all_participation_records_tv_number, all_participation_records_tv_time;

    }
}
