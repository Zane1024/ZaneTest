package com.example.em.mi.Fragment_5.ho.participation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.em.mi.R;

import java.util.List;

/**
 * Created by pc on 2017/6/26.
 */
public class Participation_all_rvAdapter extends RecyclerView.Adapter<Participation_all_rvAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<String> datas;
    public Participation_all_rvAdapter(List<String> list, Context context) {
        this.datas = list;
        this.inflater = LayoutInflater.from(context);;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public Participation_all_rvAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflater.from(viewGroup.getContext()).inflate(R.layout.participation_all_recyvlerview_item,viewGroup,false);
        Participation_all_rvAdapter.ViewHolder vh = new Participation_all_rvAdapter.ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(Participation_all_rvAdapter.ViewHolder viewHolder, int position) {

        viewHolder.title.setText(datas.get(position));



    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mImageView;
        private TextView title,number,frequency,details,winners,sumpelpeo;
        private Button button;



        public ViewHolder(View view){
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.participation_open_item_img);
            title = (TextView) view.findViewById(R.id.participation_open_item_title);
            number = (TextView) view.findViewById(R.id.participation_open_item_number);
            frequency = (TextView) view.findViewById(R.id.participation_open_item_frequency);
            details = (TextView) view.findViewById(R.id.participation_open_item_details);
            winners = (TextView) view.findViewById(R.id.participation_open_item_winners);
            sumpelpeo = (TextView) view.findViewById(R.id.participation_open_item_sumpeople);
            button = (Button)view.findViewById(R.id.participation_open_item_btn);


            view.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            Toast.makeText(inflater.getContext(),"第"+title.getText(), Toast.LENGTH_SHORT).show();


        }
    }

}
