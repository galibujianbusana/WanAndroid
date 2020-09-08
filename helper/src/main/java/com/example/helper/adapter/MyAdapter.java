package com.example.helper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helper.R;
import com.example.helper.db.info.Gu;

import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Gu> data;

    public MyAdapter(Context context, List<Gu> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item,null);
            holder.name = view.findViewById(R.id.name);
            holder.begin = view.findViewById(R.id.begin);
            holder.end = view.findViewById(R.id.end);
            holder.max = view.findViewById(R.id.max);
            holder.min = view.findViewById(R.id.min);
            holder.lv = view.findViewById(R.id.lv);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Gu gu = data.get(i);
        holder.name.setText(gu.getName());
        holder.begin.setText(gu.getBeginPrice());
        holder.end.setText(gu.getEndPrice());
        holder.max.setText(gu.getHighestPrice());
        holder.min.setText(gu.getMinimumPrice());
        holder.lv.setText(gu.getAmplitude());
        return null;
    }

    public final class ViewHolder {
        public TextView name;
        public TextView begin;
        public TextView end;
        public TextView max;
        public TextView min;
        public TextView lv;

    }
}
