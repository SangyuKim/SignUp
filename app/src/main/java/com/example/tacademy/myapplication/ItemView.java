package com.example.tacademy.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Tacademy on 2015-10-08.
 */
public class ItemView extends FrameLayout {
    public ItemView(Context context) {
        super(context);
        init();
    }
    TextView textView;
    CheckBox checkBox;
    public void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.view_item, this);
        textView = (TextView)findViewById(R.id.textView_desc);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
    }
    public void setItem(Item item){
        textView.setText(item.desc);
        checkBox.setSelected(item.agreement);
    }


}
