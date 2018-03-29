package com.example.em.mi.Fragment_5;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.em.mi.R;
import com.nostra13.universalimageloader.utils.L;

/**
 * 充值页面  2017年7月6日18:13:40  去除充值焦点
 * Created by Administrator on 2017/6/26.
 */

public class ChonZhiAcvtivity extends AppCompatActivity  implements View.OnClickListener{

    private ImageView back;
    private Button radioButton_zidingyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_5_topups);
        initView();



    }

    private void initView() {

        back = (ImageView)findViewById(R.id.chongzhi_back);
        radioButton_zidingyi = (Button)findViewById(R.id.radioButton_zidingyi);


        radioButton_zidingyi.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chongzhi_back:
                ChonZhiAcvtivity.this.finish();
                break;

            case R.id.radioButton_zidingyi:
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonZhiAcvtivity.this);
                //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
                View view = LayoutInflater.from(ChonZhiAcvtivity.this).inflate(R.layout.chonzhi_edittext, null);
                //    设置我们自己定义的布局文件作为弹出框的Content
                builder.setView(view);

                final EditText chonzhu_edittext = (EditText)view.findViewById(R.id.chonzhu_edittext);

                builder.setPositiveButton("确定", new DialogInterface
                        .OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String a = chonzhu_edittext.getText().toString().trim();
                        radioButton_zidingyi.setText(a);
                        //    将输入的用户名和密码打印出来
                        /**//*Toast.makeText(ChonZhiAcvtivity.this, "用户名: " + a , Toast.LENGTH_SHORT)
                            .show();*/
                    }
                });

                /*builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });*/
                builder.show();

                break;
        }
    }
}
