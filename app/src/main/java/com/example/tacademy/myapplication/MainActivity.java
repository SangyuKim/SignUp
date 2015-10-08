package com.example.tacademy.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Fragment[] list = {BlankFragment.newInstance("one"),
                        BlankFragment.newInstance("two"),
                        BlankFragment.newInstance("three")};
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(savedInstanceState == null){
            //앱이 죽지 않았을때 생성 -> Base Fragment
            getSupportFragmentManager().beginTransaction().add(R.id.container,new BlankFragment().newInstance("base")).commit();
        }
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //조건 BackStack size ->pop
                if(getSupportFragmentManager().getBackStackEntryCount()>0)
                    getSupportFragmentManager().popBackStack();
            }
        });
        btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //count
                int count = getSupportFragmentManager().getBackStackEntryCount();
                //backStack에다가 쌓기
                if(count< list.length){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, list[count]).addToBackStack(null).commit();
                }else{
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        });
        initData();
    }
    void initData(){

    }
}
