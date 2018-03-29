package com.example.em.mi.Fragment_5.ho.participation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.em.mi.MainActivity;
import com.example.em.mi.R;

/**
 * Created by pc on 2017/6/30.
 */

public class Participation_now_fragment extends Fragment implements View.OnClickListener{
    View view;
    private Button duobao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.participation_now_fragment, container, false);
        duobao = (Button)view.findViewById(R.id.participation_now_include_duobao);

        duobao.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.participation_now_include_duobao:
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                getActivity().finish();
                break;
        }

    }
}
