package com.paulsoja.depositcalculator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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

import java.math.BigDecimal;

/**
 * Created by Paul Soja on 20.06.2017.
 */

public class InputDepositDataFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button button;
    private EditText etSumStart;
    private EditText etSumRefill;
    private EditText etProfit;
    private EditText etInterval;
    private TextView txtSumEnd;
    private TextView txtProfit;
    private TextView txtSumWithProfit;

    int capitalization;

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
        txtSumEnd = (TextView) view.findViewById(R.id.textView1);
        txtProfit = (TextView) view.findViewById(R.id.textView2);
        txtSumWithProfit = (TextView) view.findViewById(R.id.textView3);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_capitalization, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        etSumStart.addTextChangedListener(watcher);
        etSumRefill.addTextChangedListener(watcher);
        etProfit.addTextChangedListener(watcher);
        etInterval.addTextChangedListener(watcher);

        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ViewResultDepositFragment fragment = new ViewResultDepositFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] chooseItem = getResources().getStringArray(R.array.spinner_capitalization);
        if (position == 0) {
            capitalization = 12;
        } else if (position == 1) {
            capitalization = 3;
        } else if (position == 2) {
            capitalization = 1;
        } else if (position == 3) {
            capitalization = 0;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void getCalculate() {
        ViewResultItems items = new ViewResultItems();
        items.setSumStart(ConvertUtil.bigDecimalFromEt(etSumStart));
        items.setSumRefill(ConvertUtil.bigDecimalFromEt(etSumRefill));
        items.setProfit(ConvertUtil.bigDecimalFromEt(etProfit));
        int interval = ConvertUtil.intFromEt(etInterval);

        BigDecimal resultSumWithRefill = BigDecimal.ZERO;
        for (int i = 0; i < interval; i++) {
            resultSumWithRefill = resultSumWithRefill.add(items.getSumRefill());
        }
        resultSumWithRefill = resultSumWithRefill.add(items.getSumStart());
        txtSumEnd.setText(String.valueOf(resultSumWithRefill));
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            getCalculate();
        }
    };
}
