package com.cenyol.demo.rc;

/**
 * @author Chenhanqun mail: chenhanqun1@corp.netease.com
 * @date 2019-05-27 17:29
 */
public class QuarterSalesItem {
    private int quarter;
    private double total;

    public QuarterSalesItem(int quarter, double total) {
        this.quarter = quarter;
        this.total = total;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
