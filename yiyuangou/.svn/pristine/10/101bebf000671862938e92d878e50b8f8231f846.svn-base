package com.example.em.mi.Fragment_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.em.mi.Fragment_4.amount.AmountView;
import com.example.em.mi.R;
import com.example.em.mi.bean.Commodity;

import java.util.List;

/**
 * Created by pc on 2017/6/27.
 */
public class Inventory_lvAdapter extends BaseAdapter {

    private Context context;
    private List<Commodity> datas;
    public static int mPosition;


    //第一步，设置接口
    AmountView.OnAmountChangeListener ocl;


    public Inventory_lvAdapter(Context context, List<Commodity> datas,AmountView.OnAmountChangeListener ocl){
        this.context =context;
        this.datas = datas;
        this.ocl = ocl;
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


        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(this.context).inflate(R.layout.inventory_listview_item, null,true);
            holder.iv=(ImageView) convertView.findViewById(R.id.inventory_lv_item_iv);
            holder.title=(TextView) convertView.findViewById(R.id.inventory_lv_item_tv_title);
            holder.sum=(TextView) convertView.findViewById(R.id.inventory_lv_item_tv_sum);
            holder.surplus=(TextView)convertView.findViewById(R.id.inventory_lv_item_tv_surplus);
            holder.bw = (Button)convertView.findViewById(R.id.inventory_lv_item_btn_baowei);
            holder.av = (AmountView)convertView.findViewById(R.id.inventory_lv_item_amount_view);
            holder.et = (EditText)holder.av.findViewById(R.id.inventory_etAmount);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (this.datas != null) {
            holder.title.setText(datas.get(position).getTitle());
            holder.sum.setText(datas.get(position).getSum()+"");
            holder. surplus.setText(datas.get(position).getSurplus()+"");
            holder.iv.setImageResource(datas.get(position).getImg());
            holder. av.setGoods_storage(999);
            holder.et.setHint(datas.get(position).getBuy_number()+"");
            holder.av.setNumber(datas.get(position).getBuy_number());
            holder. av.setOnAmountChangeListener(ocl);
            //设置TAG让Fragment 知道哪个在增加
            holder.av.setTag(position);
        }

        return convertView;

    }



    /*定义item对象*/
    public class ViewHolder {
        ImageView iv;
        TextView title;
        TextView sum;
        TextView surplus;
        Button bw;
        AmountView av;
        EditText et;
    }

}






