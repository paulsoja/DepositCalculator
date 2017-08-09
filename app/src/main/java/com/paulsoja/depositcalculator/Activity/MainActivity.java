package com.paulsoja.depositcalculator.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.paulsoja.depositcalculator.Fragments.InputDepositDataFragment;
import com.paulsoja.depositcalculator.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputDepositDataFragment inputFragment = new InputDepositDataFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, inputFragment).commit();
    }
}
