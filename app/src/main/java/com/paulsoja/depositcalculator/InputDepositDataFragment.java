package com.paulsoja.depositcalculator;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Paul Soja on 20.06.2017.
 */

public class InputDepositDataFragment extends Fragment implements View.OnClickListener{

    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_deposit_data, container, false);
        button = (Button) view.findViewById(R.id.button_schedule);
        Spinner spinner = (Spinner) view.findViewById(R.id.Spinner_capitalization);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_capitalization, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ViewResultDepositFragment fragment = new ViewResultDepositFragment();
        getFragmentManager().beginTransaction().replace(R.id.Fragment_viewResultDeposit, fragment);
    }
}
