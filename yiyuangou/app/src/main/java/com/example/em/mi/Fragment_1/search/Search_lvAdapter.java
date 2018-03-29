package com.example.em.mi.Fragment_1.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.em.mi.R;
import com.example.em.mi.bean.Commodity;

import java.util.List;

/**
 * Created by pc on 2017/6/27.
 */
public class Search_lvAdapter extends BaseAdapter {

    private Context context;
    private List<Commodity> datas;
    public static int mPosition;

    public Search_lvAdapter(Context context,  List<Commodity> datas){
        this.context =context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.search_listview_item, null);
        }
        ImageView iv = (ImageView)convertView.findViewById(R.id.search_lv_item_iv) ;
        TextView title = (TextView)convertView.findViewById(R.id.search_lv_item_tv_title);
        TextView sum = (TextView)convertView.findViewById(R.id.search_lv_item_tv_sum);
        TextView surplus = (TextView)convertView.findViewById(R.id.search_lv_item_tv_surplus);
        ProgressBar pb = (ProgressBar)convertView.findViewById(R.id.search_lv_item_ProgressBar);

        title.setText(datas.get(position).getTitle());
        sum.setText(datas.get(position).getSum()+"");
        surplus.setText(datas.get(position).getSurplus()+"");
        iv.setImageResource(datas.get(position).getImg());
        pb.setMax(datas.get(position).getSum());
        pb.setProgress(datas.get(position).getSurplus());


        return convertView;
    }


}
