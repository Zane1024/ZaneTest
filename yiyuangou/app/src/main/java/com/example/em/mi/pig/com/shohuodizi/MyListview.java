package com.example.em.mi.pig.com.shohuodizi;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by pc on 2017/7/6.
 */

public class MyListview extends ListView{
    public MyListview(Context context) {
        super(context);
    }

    public MyListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, mExpandSpec);



    }

}
