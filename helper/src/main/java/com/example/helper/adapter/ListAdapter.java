package com.example.helper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.helper.R;
import com.example.helper.db.info.Gu;
import com.example.helper.db.info.ListInfo;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    Context context;
    List<ListInfo> data;

    public ListAdapter(Context context, List<ListInfo> data) {
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
            view = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            holder.name = view.findViewById(R.id.name);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        ListInfo gu = data.get(i);
        holder.name.setText(gu.getName());
        return view;
    }

    public final class ViewHolder {
        public TextView name;
    }
}
