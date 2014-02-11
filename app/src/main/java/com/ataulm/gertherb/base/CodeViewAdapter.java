package com.ataulm.gertherb.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ataulm.gertherb.R;

public class CodeViewAdapter extends BaseAdapter {

    private final Context context;
    private final String[] lines;

    public CodeViewAdapter(Context context, String[] lines) {
        this.context = context;
        this.lines = lines;
    }

    @Override
    public int getCount() {
        return lines.length;
    }

    @Override
    public String getItem(int position) {
        return lines[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = createView(parent);
        }

        updateView(position, (TextView) convertView);
        return convertView;
    }

    public View createView(ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_code, parent, false);
    }

    public void updateView(int position, TextView view) {
        view.setText(getItem(position));
    }

}
