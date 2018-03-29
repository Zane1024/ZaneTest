package com.example.em.mi.Fragment_1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.em.mi.R;
import com.example.em.mi.pig.DialogFragment_p.DialogFragment_canyu_ja;
import com.example.em.mi.pig.com.shohuodizi.CommodityDetails;

import java.util.List;

/**
 * Created by pc on 2017/6/26.
 */
public class Popularity_rvAdapter extends RecyclerView.Adapter<Popularity_rvAdapter.ViewHolder>{
    LayoutInflater inflater;
    List<String> datas;

    //Item设置点击事件借口
    private OnItemClickListener mOnItemClickListener;

    private OnBtnClickListener mOnBtnClickListener;



    //Item自定义设置点击事件接口
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public interface OnBtnClickListener{
        void onbtClick(View view,int position);
    }



    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnBtnClickListener(OnBtnClickListener onBtnClickListener){
        this.mOnBtnClickListener = onBtnClickListener;
    }


    public Popularity_rvAdapter( List<String> list, Context context) {
        this.datas = list;
        this.inflater = LayoutInflater.from(context);
    }
    //创建新View，被LayoutManager所调用
    @Override
    public Popularity_rvAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflater.from(viewGroup.getContext()).inflate(R.layout.home_popularity_rv_item,viewGroup,false);
        Popularity_rvAdapter.ViewHolder vh = new Popularity_rvAdapter.ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final Popularity_rvAdapter.ViewHolder viewHolder, int position) {

        viewHolder.title.setText(datas.get(position));
        //判断是否设置了监听器
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(viewHolder.itemView,position); // 2
                }
            });
        }


        if(mOnBtnClickListener != null){
            //为BTN设置监听器
            viewHolder.home_popularity_rv_item_duobao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getLayoutPosition(); // 1
                    mOnBtnClickListener.onbtClick(viewHolder.home_popularity_rv_item_duobao,position); // 2
                }
            });
        }






    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView sum;
        public TextView surplus;
        public ImageView mImageView;
        public Button home_popularity_rv_item_duobao;

        public ViewHolder(View view){
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.home_popularity_rv_item_img);
            title = (TextView) view.findViewById(R.id.home_popularity_rv_item_title);
            sum = (TextView) view.findViewById(R.id.home_popularity_rv_item_sum);
            surplus = (TextView) view.findViewById(R.id.home_popularity_rv_item_surplus);
            home_popularity_rv_item_duobao = (Button)view.findViewById(R.id
                    .home_popularity_rv_item_duobao);


           // view.setOnClickListener(this);

        }




       /* @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.home_popularity_rv_item_duobao :
                    //调用弹窗
                    //DialogFragment_canyu_ja dia = new DialogFragment_canyu_ja();
                    //dia.show(getSupportFragmentManager(),"payDetailFragment");
                    Toast.makeText(inflater.getContext(),"立即夺宝", Toast.LENGTH_SHORT).show();
                    break;

            }

            //字符串 转换成 整形
            String titles = title.getText().toString();
            int i = Integer.valueOf(titles);
            switch (i){
                case  1:
                    //准备抢
                    Intent intent1 = new Intent(inflater.getContext(),CommodityDetails.class);
                    Toast.makeText(inflater.getContext(),"准备抢", Toast.LENGTH_SHORT).show();
                    //传值 改变布局
                    intent1.putExtra("number",1);
                    inflater.getContext().startActivity(intent1);
                    break;

                    //正在抢
                case  2:
                    Intent intent2 = new Intent(inflater.getContext(),CommodityDetails.class);
                    Toast.makeText(inflater.getContext(),"正在抢", Toast.LENGTH_SHORT).show();
                    intent2.putExtra("number",2);
                    inflater.getContext().startActivity(intent2);
                    break;

                    //公开结束
                case  3:
                    Intent intent3 = new Intent(inflater.getContext(),CommodityDetails.class);
                    Toast.makeText(inflater.getContext(),"公开结束", Toast.LENGTH_SHORT).show();
                    intent3.putExtra("number",3);
                    inflater.getContext().startActivity(intent3);
                    break;

            }
            //什么都干的时候
            Toast.makeText(inflater.getContext(),"我什么都不干就默默数数 第"+title.getText(), Toast
                    .LENGTH_SHORT)
                    .show();

        }*/
    }



}
