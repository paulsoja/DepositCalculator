package com.paulsoja.depositcalculator.Utils;

import android.widget.EditText;

import java.math.BigDecimal;

/**
 * Created by p-sha on 22.07.2017.
 */

public class ConvertUtil {

    public static BigDecimal bigDecimalFromEt(EditText text) {
        return new BigDecimal(text.getText().toString());
    }

    public static int intFromEt(EditText text) {
        return Integer.parseInt(text.getText().toString());
    }

}
