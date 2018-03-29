package com.example.em.mi.pig.com.shohuodizi;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.em.mi.R;

import java.util.Calendar;

/**
 * Created by Administrator on 2017-07-03.
 * 个人信息界面绑定
 */

public class MyInfo extends Activity implements View.OnClickListener{
    //绑定手机
    private TextView myinfo_bangdingshouji;
    private TextView myinfo_nianyueri;
    final int DATE_DIALOG = 1;
    //年 月 日
    int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);
        //初始化
        myinfo_bangdingshouji = (TextView)findViewById(R.id.myinfo_bangdingshouji);
        myinfo_nianyueri = (TextView)findViewById(R.id.myinfo_nianyueri);

        myinfo_bangdingshouji.setOnClickListener(this);
        myinfo_nianyueri.setOnClickListener(this);

        //获取年月日参数值
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //绑定手机号
            case R.id.myinfo_bangdingshouji:
                Intent bingding = new Intent(this,BangDingShouJi.class);
                startActivity(bingding);
                break;

            //生日
            case R.id.myinfo_nianyueri:
                showDialog(DATE_DIALOG);
                break;


        }
    }

//***************年月日
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        myinfo_nianyueri.setText(new StringBuffer().append(mMonth + 1).append("-").append(mDay)
                .append("-").append(mYear).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };
//年月日****************************
}
