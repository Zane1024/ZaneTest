package com.example.em.mi.pig.pigscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 重写 ScrollView 监听滚动条实现渐变
 * Created by Administrator on 2017-07-06.
 */

public class MyScrollView extends ScrollView {
    ScrollViewLine scrollViewLine;
    boolean isup = false;
    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        scrollViewLine.onScrollChanged(l, t, oldl, oldt);
    }


    public ScrollViewLine getScrollViewLine() {
        return scrollViewLine;
    }
    public void setScrollViewLine(ScrollViewLine scrollViewLine) {
        this.scrollViewLine = scrollViewLine;
    }



    public interface ScrollViewLine{
        void onScrollChanged(int l, int t, int oldl, int oldt);
    }
}
