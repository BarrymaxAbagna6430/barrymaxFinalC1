package com.Barrymax.Abagna.N01266430;

import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static java.util.Arrays.asList;


public class BarrymaxFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_barrymax, container, false);
        ImageView imageView = view.findViewById(R.id.linear);
        imageView.setBackground(BarrymaxMainActivity.gradientDrawable);
        Button btnSave = view.findViewById(R.id.btnAddList);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            BarrymaxMainActivity.setData(getContext());
            }
        });
return view;
    }
}