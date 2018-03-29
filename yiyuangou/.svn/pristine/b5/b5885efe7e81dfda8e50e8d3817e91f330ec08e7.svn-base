package com.example.em.mi.pig.DialogFragment_p;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.example.em.mi.Fragment_5.RadioGroupEx;
import com.example.em.mi.R;
import com.example.em.mi.pig.DialogFragment_p.amount.AmountView;

/**
 * Created by Administrator on 2017-07-03.
 */

public class DialogFragment_canyu_ja extends DialogFragment implements RadioGroup.OnCheckedChangeListener{

    private RelativeLayout rePayDetail;
    private LinearLayout linPass;
    private Button button1,button2;

    private RadioGroupEx radioGroupEx;

    private AmountView amountView;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 使用不带Theme的构造器, 获得的dialog边框距离屏幕仍有几毫米的缝隙。
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        dialog.setContentView(R.layout.m_canyu_dialogfragment_item);
        dialog.setCanceledOnTouchOutside(true); // 外部点击取消
        // 设置宽度为屏宽, 靠近屏幕底部。
        final Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.AnimBottom);
        final WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM; // 紧贴底部
        lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
        lp.height = getActivity().getWindowManager().getDefaultDisplay().getHeight() * 5 / 11;
        window.setAttributes(lp);

        radioGroupEx = (RadioGroupEx)dialog.findViewById(R.id.dialogfragment_radio);
        amountView = (AmountView)dialog.findViewById(R.id.dialogfragment_amountview);

        amountView.setGoods_storage(999);
        amountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                Toast.makeText(getActivity(), "Amount=>  " + amount, Toast.LENGTH_SHORT).show();
            }
        });

        radioGroupEx.setOnCheckedChangeListener(this);



        return dialog;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.dialogfragment_button5:
                Log.i("tag","你选着"+5+"按钮");
                amountView.setNumber(5);
                break;
            case R.id.dialogfragment_button10:
                Log.i("tag","你选着"+10+"按钮");
                amountView.setNumber(10);
                break;
            case R.id.dialogfragment_button50:
                Log.i("tag","你选着"+50+"按钮");
                amountView.setNumber(50);
                break;
            case R.id.dialogfragment_button100:
                Log.i("tag","你选着"+100+"按钮");
                amountView.setNumber(100);
                break;
            case R.id.dialogfragment_button_baowei:
                Log.i("tag","你选着包尾按钮");
                break;

        }

    }
}
