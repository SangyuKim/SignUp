package com.example.tacademy.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2015-10-08.
 */
public class Adapter extends BaseAdapter {
    List<Item> items = new ArrayList<>();


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView v;
        if(convertView == null){
            v= new ItemView(parent.getContext());
        }else{
            v= (ItemView)convertView;
        }

        v.setItem(items.get(position));
        return v;
    }
    public void add(Item item){
        items.add(item);
        notifyDataSetChanged();
    }
}
