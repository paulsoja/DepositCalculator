package com.paulsoja.depositcalculator.Models;

import android.os.Bundle;

import com.paulsoja.depositcalculator.Utils.BundleUtil;

import java.math.BigDecimal;

/**
 * Created by Paul Soja on 09.07.2017.
 */

public class ViewResultItems {

    private int number = 100;
    private BigDecimal sumStart = BigDecimal.valueOf(50);
    private BigDecimal sumRefill = BigDecimal.valueOf(100);
    private BigDecimal profit = BigDecimal.valueOf(200);
    private BigDecimal sumEnd = BigDecimal.valueOf(300);

    public ViewResultItems() {}

    public ViewResultItems(int number, BigDecimal sumStart, BigDecimal sumRefill, BigDecimal profit, BigDecimal sumEnd) {
        this.number = number;
        this.sumStart = sumStart;
        this.sumRefill = sumRefill;
        this.profit = profit;
        this.sumEnd = sumEnd;
    }

    public ViewResultItems(Bundle data) {
        sumStart = BundleUtil.getDecimal(data, "sumStart");
        sumRefill = BundleUtil.getDecimal(data, "sumRefill");
        profit = BundleUtil.getDecimal(data, "profit");
        sumEnd = BundleUtil.getDecimal(data, "sumEnd");
    }

    public Bundle serialize() {
        Bundle data = new Bundle();
        BundleUtil.put(data, "sumStart", sumStart);
        BundleUtil.put(data, "sumRefill", sumRefill);
        BundleUtil.put(data, "profit", profit);
        BundleUtil.put(data, "sumEnd", sumEnd);
        return data;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getSumStart() {
        return sumStart;
    }

    public void setSumStart(BigDecimal sumStart) {
        this.sumStart = sumStart;
    }

    public BigDecimal getSumRefill() {
        return sumRefill;
    }

    public void setSumRefill(BigDecimal sumRefill) {
        this.sumRefill = sumRefill;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getSumEnd() {
        return sumEnd;
    }

    public void setSumEnd(BigDecimal sumEnd) {
        this.sumEnd = sumEnd;
    }
}
