package com.example.em.mi.Fragment_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.em.mi.R;

import java.util.List;

/**
 * Created by pc on 2017/6/22.
 */

public class MylistviewAdapter extends BaseAdapter {

    private List<NewsInfo> list;
    private LayoutInflater inflater;
    private final int TYPE_ONE=0,TYPE_TWO=1,TYPE_COUNT=2;

    public MylistviewAdapter(List<NewsInfo> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        int po = position ;
        if (po < 2)
            return TYPE_ONE;
        else
            return TYPE_TWO;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 vh1=null;
        ViewHolder2 vh2=null;
        int type=getItemViewType(i);

        if(view == null) {
            //加载不同的ITEM
            switch (type){
                case TYPE_ONE:
                    vh1 = new ViewHolder1();
                    view = inflater.inflate(R.layout.fragment_news_item2, null);
                    view.setTag(vh1);
                        break;
                case TYPE_TWO:
                    vh2 = new ViewHolder2();
                    view = inflater.inflate(R.layout.fragment_news_item, null);
                    view.setTag(vh2);
                    break;

            }


        }

     /*   ImageView img = (ImageView) view.findViewById(R.id.news_listitem_img);
        TextView title = (TextView)view.findViewById(R.id.news_listitem_title);
        TextView number = (TextView)view.findViewById(R.id.news_listitem_number);
        TextView winners = (TextView)view.findViewById(R.id.news_listitem_winners);
        TextView peoplenumbers = (TextView)view.findViewById(R.id.news_listitem_peoplenumbers);
        TextView luckynumber = (TextView)view.findViewById(R.id.news_listitem_luckynumber);
        TextView time = (TextView)view.findViewById(R.id.news_listitem_time);*/

    /*    //设置item 的值
        img.setImageResource(list.get(i).getImg());
        title.setText(list.get(i).getTitle());
        number.setText(list.get(i).getNumber());
        winners.setText(list.get(i).getWinners());
        peoplenumbers.setText(list.get(i).getPeoplenumbers());
        luckynumber.setText(list.get(i).getLuckynumber());
        time.setText(list.get(i).getTime());*/



        return view;


    }
    static class ViewHolder1{
        ImageView img ;
        TextView title;
        TextView number;
        TextView winners;
        TextView peoplenumbers;
        TextView luckynumber ;
        TextView time ;
    }
    static class ViewHolder2{
        ImageView img2 ;
        TextView title2;
        TextView number2;
        TextView time2 ;
    }


}
