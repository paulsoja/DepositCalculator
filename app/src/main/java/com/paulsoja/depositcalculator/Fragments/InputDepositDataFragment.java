package com.paulsoja.depositcalculator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.paulsoja.depositcalculator.R;
import com.paulsoja.depositcalculator.Utils.ConvertUtil;
import com.paulsoja.depositcalculator.Models.ViewResultItems;

/**
 * Created by Paul Soja on 20.06.2017.
 */

public class InputDepositDataFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    public static final String KEY_ITEMS = "KEY_ITEMS";

    private ViewResultItems viewResultItems;

    private Spinner spinner;
    private Button button;
    private EditText etSumStart;
    private EditText etSumRefill;
    private EditText etProfit;
    private EditText etInterval;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_deposit_data, container, false);
        button = (Button) view.findViewById(R.id.button_schedule);
        spinner = (Spinner) view.findViewById(R.id.Spinner_capitalization);
        etSumStart = (EditText) view.findViewById(R.id.etSumStart);
        etSumRefill = (EditText) view.findViewById(R.id.etSumRefill);
        etProfit = (EditText) view.findViewById(R.id.etProfit);
        etInterval = (EditText) view.findViewById(R.id.etInterval);
        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView3 = (TextView) view.findViewById(R.id.textView3);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_capitalization, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button.setOnClickListener(this);
        return view;
    }

    public void fillData() {
        viewResultItems.setSumStart(ConvertUtil.bigDecimalFromEt(etSumStart));
        viewResultItems.setSumRefill(ConvertUtil.bigDecimalFromEt(etSumRefill));
        viewResultItems.setProfit(ConvertUtil.bigDecimalFromEt(etProfit));
        int interval = ConvertUtil.intFromEt(etInterval);
    }

    @Override
    public void onClick(View v) {
        ViewResultDepositFragment fragment = new ViewResultDepositFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] chooseItem = getResources().getStringArray(R.array.spinner_capitalization);
        int yearCapitalization = 10;
        if (position == 0) {
            yearCapitalization = 12;
        } else if (position == 1) {
            int quarterCapitalization = 3;
        } else if (position == 2) {
            int monthCapitalization = 1;
        } else if (position == 3) {
            int noCapitalization = 0;
        }
        textView1.setText(String.valueOf(yearCapitalization));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
