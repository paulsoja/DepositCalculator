package com.paulsoja.depositcalculator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.paulsoja.depositcalculator.R;
import com.paulsoja.depositcalculator.Adapters.ViewResultDepositAdapter;
import com.paulsoja.depositcalculator.Models.ViewResultItems;

import java.util.ArrayList;

/**
 * Created by Paul Soja on 20.06.2017.
 */

public class ViewResultDepositFragment extends Fragment {

    ViewResultItems viewResultItems = new ViewResultItems();
    ViewResultDepositAdapter adapter;
    ArrayList<ViewResultItems> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_result_deposit, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listview_result_deposit);
        fillData();
        adapter = new ViewResultDepositAdapter(getContext(), list);
        listView.setAdapter(adapter);
        return view;
    }

    private void fillData() {
        list.add(new ViewResultItems(35, viewResultItems.getSumStart(),
                viewResultItems.getSumRefill(),
                viewResultItems.getProfit(),
                viewResultItems.getSumEnd()));
    }
}
