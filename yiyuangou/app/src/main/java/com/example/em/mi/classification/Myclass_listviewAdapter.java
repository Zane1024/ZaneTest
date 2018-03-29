package com.example.em.mi.classification;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.em.mi.R;


/**
 * Created by pc on 2017/6/26.
 */

public class Myclass_listviewAdapter extends BaseAdapter {

    private Context context;
    private String[] strings;
    public static int mPosition;
    private  int DefItem ;

    public Myclass_listviewAdapter(Context context, String[] strings){
        this.context =context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        convertView = LayoutInflater.from(context).inflate(R.layout.classlistview_item, null);
        TextView tv = (TextView) convertView.findViewById(R.id.class_lv_tv);
        ImageView iv = (ImageView) convertView.findViewById(R.id.class_lv_iv);
        mPosition = position;
        tv.setText(strings[position]);
        if (position == ClassificationActivity.mPosition) {
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
          //  convertView.setBackgroundResource(R.drawable.tv_xiahuaxian);
            iv.setImageResource(R.drawable.apple2);
            tv.setTextColor(Color.parseColor("#ff7d25"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#f4f4f4"));
           // convertView.setBackgroundResource(R.drawable.tv_xiahuaxian2);
            tv.setTextColor(Color.parseColor("#000000"));
            iv.setImageResource(R.drawable.apple);
        }
        return convertView;
    }


}