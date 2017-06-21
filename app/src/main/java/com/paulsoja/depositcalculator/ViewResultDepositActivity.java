package com.paulsoja.depositcalculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Paul Soja on 21.06.2017.
 */

public class ViewResultDepositActivity extends FragmentActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE && isLarge()) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            ViewResultDepositFragment fragment = new ViewResultDepositFragment();
            getSupportFragmentManager().beginTransaction().add(fragment, "ViewResultDeposit").commit();
        }
    }

    boolean isLarge() {
        return (getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
