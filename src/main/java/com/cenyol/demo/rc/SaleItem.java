package com.cenyol.demo.rc;

import java.util.Date;

/**
 * @author Chenhanqun mail: chenhanqun1@corp.netease.com
 * @date 2019-05-27 17:29
 */
public class SaleItem {
    private int month;
    private Date date;
    private String transationId;
    private double saleNumbers;

    public SaleItem(int month, Date date, String transationId, double saleNumbers) {
        this.month = month;
        this.date = date;
        this.transationId = transationId;
        this.saleNumbers = saleNumbers;
    }

    public int getQuarter() {
        return (getMonth() + 2) / 3;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransationId() {
        return transationId;
    }

    public void setTransationId(String transationId) {
        this.transationId = transationId;
    }

    public double getSaleNumbers() {
        return saleNumbers;
    }

    public void setSaleNumbers(double saleNumbers) {
        this.saleNumbers = saleNumbers;
    }
}
