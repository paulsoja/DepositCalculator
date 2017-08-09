package com.paulsoja.depositcalculator.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.paulsoja.depositcalculator.Fragments.InputDepositDataFragment;
import com.paulsoja.depositcalculator.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);

        InputDepositDataFragment inputFragment = new InputDepositDataFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, inputFragment).commit();
    }
}
