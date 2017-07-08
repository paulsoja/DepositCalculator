package com.paulsoja.depositcalculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Paul Soja on 20.06.2017.
 */

public class ViewResultDepositFragment extends Fragment {

    String[] items = {"one", "two", "three"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_result_deposit, container, false);
        ListView listView = (ListView) view.findViewById(R.id.listview_result_deposit);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(arrayAdapter);
        return view;
    }
}
