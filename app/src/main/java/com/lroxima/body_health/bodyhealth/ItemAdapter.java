package com.lroxima.body_health.bodyhealth;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<String> {

    public ItemAdapter(@NonNull Context context, String[] items) {
        super(context, R.layout.item_row ,items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater itemInflater = LayoutInflater.from(getContext());
        View itemView = itemInflater.inflate(R.layout.item_row, parent, false);

        String singleItem = getItem(position);
        TextView  textView1 = (TextView) itemView.findViewById(R.id.textView1);
        TextView  textView2 = (TextView) itemView.findViewById(R.id.textView2);

        textView1.setText(singleItem);
        textView2.setText("13th Nov 2017");

        return itemView;
    }
}
