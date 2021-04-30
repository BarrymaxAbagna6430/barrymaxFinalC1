package com.Barrymax.Abagna.N01266430;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;


public class BarrymaxMainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    static List<String> Lines ;

     static SharedPreferences sharedPreferences = null;
   public  static GradientDrawable gradientDrawable;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         int[] co = new int[]{ContextCompat.getColor(getApplicationContext(), R.color.color1),
                ContextCompat.getColor(getApplicationContext(), R.color.color2),
                ContextCompat.getColor(getApplicationContext(), R.color.color3),
                ContextCompat.getColor(getApplicationContext(), R.color.color4),
                ContextCompat.getColor(getApplicationContext(), R.color.color5),
        };
        super.onCreate(savedInstanceState);
        Lines= Arrays.asList(getResources().getStringArray(R.array.courses));
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Barrymax"));
        tabLayout.addTab(tabLayout.newTab().setText("Abagna"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
         BarrymaxMyAdapter adapter = new BarrymaxMyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
       gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,co);
       gradientDrawable.setShape(GradientDrawable.OVAL);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setData(getApplicationContext());
    }
    // 7:50 pm
   public static void setData(Context context)
    {
        sharedPreferences = context.getSharedPreferences("course",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(Lines);


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("courses", json);
        editor.apply();
    }
    public static  List<String> getData(Context context)
    {
        sharedPreferences = context.getSharedPreferences("course",MODE_PRIVATE);
        Gson gson = new Gson();
        List<String> list;

        String string = sharedPreferences.getString("courses", "nothing to show");
        Type type = new TypeToken<List<String>>() {
        }.getType();
        list = gson.fromJson(string, type);
        return list;
    }
}