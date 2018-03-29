package com.example.em.mi;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/6/28.
 */

public class WelcomeActivity extends AppCompatActivity {

    private TextView tv_skip;
    private MyCount myCount;
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);
        tv_skip = (TextView) findViewById(R.id.tv_skip);
        myCount = new MyCount(4000, 1000);// 创建一个倒计时 总时长10秒 间隔1秒
        myCount.start();// 开启倒计时
        tv_skip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myCount.cancel();// 点击之后跳过
                startActivity(new Intent(WelcomeActivity.this,
                        MainActivity.class));
                finish();
            }
        });


    }

    /* 定义一个倒计时的内部类 */
    class MyCount extends CountDownTimer {
        /**
         *
         * @param millisInFuture
         *            持续时长
         * @param countDownInterval
         *            间隔时长
         */
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        /**
         * 在倒计时结束时调用
         */
        @Override
        public void onFinish() {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }

        /**
         * 每间隔countDownInterval会调用一次
         *
         * @param millisUntilFinished
         *            已经过去了多长时间
         */
        @Override
        public void onTick(long millisUntilFinished) {
            tv_skip.setText("跳过" + millisUntilFinished / 1000 + "s");
        }
    }
}


