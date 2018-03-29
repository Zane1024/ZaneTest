package com.example.em.mi.pig.BaseAdapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2017-07-03.
 */

public class Comm_MyAdapter_Viewpager extends PagerAdapter {
    private List<ImageView> mViewList;

    public Comm_MyAdapter_Viewpager(List<ImageView> viewList) {
        mViewList = viewList;
    }

    @Override
    public ImageView instantiateItem(ViewGroup container, int position) {
        ImageView view = mViewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }
}
