package com.paulsoja.depositcalculator;

import android.content.Intent;
import android.os.Bundle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by p-sha on 22.07.2017.
 */

public class BundleUtil {

    public static void putIntegerList(Bundle bundle, String key, List<Integer> value) {
        if (value == null) {
            bundle.putIntegerArrayList(key, null);
        } else {
            bundle.putIntegerArrayList(key, new ArrayList<Integer>(value));
        }
    }

    public static List<Integer> getIntegerList(Bundle bundle, String key) {
        return bundle.getIntegerArrayList(key);
    }

    public static void put(Intent intent, String key, Integer value) {
        if (value != null) {
            intent.putExtra(key, value);
        }
    }

    public static void put(Intent intent, String key, Boolean value) {
        if (value != null) {
            intent.putExtra(key, value);
        }
    }

    public static void put(Intent intent, String key, String value) {
        if (value != null) {
            intent.putExtra(key, value);
        }
    }

    public static String getString(Intent intent, String key) {
        return intent.getStringExtra(key);
    }

    public static void put(Bundle bundle, String key, String value) {
        bundle.putString(key, value);
    }

    public static String getString(Bundle bundle, String key) {
        return bundle.getString(key, null);
    }

    public static void put(Bundle bundle, String key, Integer value) {
        if (value != null) {
            bundle.putInt(key, value);
        }
    }

    public static void put(Intent intent, String key, BigDecimal value) {
        intent.putExtra(key, value == null ? null : value.toPlainString());
    }

    public static void put(Bundle bundle, String key, Boolean value) {
        if (value != null) {
            bundle.putBoolean(key, value);
        }
    }

    public static Integer getInteger(Bundle bundle, String key) {
        return getInteger(bundle, key, null);
    }

    public static Integer getInteger(Bundle bundle, String key, Integer defaultValue) {
        if (bundle.containsKey(key)) {
            return bundle.getInt(key);
        } else {
            return defaultValue;
        }
    }

    public static boolean getBoolean(Bundle bundle, String key, boolean defaultValue) {
        if (bundle.containsKey(key)) {
            return bundle.getBoolean(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    public static boolean getBoolean(Intent intent, String key, boolean defaultValue) {
        if (intent.hasExtra(key)) {
            return intent.getBooleanExtra(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    public static Integer getInteger(Intent intent, String key) {
        if (intent.getExtras() == null) {
            return null;
        }
        return getInteger(intent.getExtras(), key);
    }

    public static void put(Bundle bundle, String key, BigDecimal value) {
        bundle.putString(key, value == null ? null : value.toPlainString());
    }

    public static BigDecimal getDecimal(Bundle bundle, String key) {
        String value = bundle.getString(key, null);
        return value == null ? null : new BigDecimal(value);
    }

    public static BigDecimal getDecimal(Intent intent, String key) {
        String value = intent.getStringExtra(key);
        return value == null ? null : new BigDecimal(value);
    }

}
