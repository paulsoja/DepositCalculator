package com.paulsoja.depositcalculator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.paulsoja.depositcalculator.R;
import com.paulsoja.depositcalculator.Models.ViewResultItems;

import java.util.ArrayList;

/**
 * Created by Paul Soja on 11.07.2017.
 */

public class ViewResultDepositAdapter extends BaseAdapter {

    private class ViewHolder {
        TextView number;
        TextView sumStart;
        TextView sumRefill;
        TextView profit;
        TextView sumEnd;
    }

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<ViewResultItems> items;

    public ViewResultDepositAdapter(Context context, ArrayList<ViewResultItems> items) {
        this.context = context;
        this.items = items;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

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
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.listview_result_deposit, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.number = (TextView) view.findViewById(R.id.listview_result_deposit_number);
            viewHolder.sumStart = (TextView) view.findViewById(R.id.listview_result_deposit_sum_start);
            viewHolder.sumRefill = (TextView) view.findViewById(R.id.listview_result_deposit_sum_refill);
            viewHolder.profit = (TextView) view.findViewById(R.id.listview_result_deposit_profit);
            viewHolder.sumEnd = (TextView) view.findViewById(R.id.listview_result_deposit_sum_end);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        ViewResultItems viewResultItems = getViewResultItems(position);
        viewHolder.number.setText(String.valueOf(viewResultItems.getNumber()));
        viewHolder.sumStart.setText(String.valueOf(viewResultItems.getSumStart()));
        viewHolder.sumRefill.setText(String.valueOf(viewResultItems.getSumRefill()));
        viewHolder.profit.setText(String.valueOf(viewResultItems.getProfit()));
        viewHolder.sumEnd.setText(String.valueOf(viewResultItems.getSumEnd()));
        return view;
    }

    private ViewResultItems getViewResultItems(int position) {
        return (ViewResultItems) getItem(position);
    }
}
