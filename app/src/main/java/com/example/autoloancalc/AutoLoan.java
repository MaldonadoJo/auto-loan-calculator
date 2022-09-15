package com.example.autoloancalc;

import android.os.Parcel;
import android.os.Parcelable;

public class AutoLoan implements Parcelable {
    private Double price;
    private Double downPayment;
    private Double tradeInValue;
    private Integer numMonths;
    private Double rateInPercent;
    private Double taxPercent;

    public AutoLoan(){

    }
    public AutoLoan(Double price, Double downPayment, Double tradeInValue, Integer numMonths, Double rateInPercent, Double taxPercent) {
        this.price = price;
        this.downPayment = downPayment;
        this.tradeInValue = tradeInValue;
        this.numMonths = numMonths;
        this.rateInPercent = rateInPercent;
        this.taxPercent = taxPercent;
    }

    protected AutoLoan(Parcel in) {
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        if (in.readByte() == 0) {
            downPayment = null;
        } else {
            downPayment = in.readDouble();
        }
        if (in.readByte() == 0) {
            tradeInValue = null;
        } else {
            tradeInValue = in.readDouble();
        }
        if (in.readByte() == 0) {
            numMonths = null;
        } else {
            numMonths = in.readInt();
        }
        if (in.readByte() == 0) {
            rateInPercent = null;
        } else {
            rateInPercent = in.readDouble();
        }
        if (in.readByte() == 0) {
            taxPercent = null;
        } else {
            taxPercent = in.readDouble();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(price);
        }
        if (downPayment == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(downPayment);
        }
        if (tradeInValue == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(tradeInValue);
        }
        if (numMonths == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(numMonths);
        }
        if (rateInPercent == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(rateInPercent);
        }
        if (taxPercent == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(taxPercent);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AutoLoan> CREATOR = new Creator<AutoLoan>() {
        @Override
        public AutoLoan createFromParcel(Parcel in) {
            return new AutoLoan(in);
        }

        @Override
        public AutoLoan[] newArray(int size) {
            return new AutoLoan[size];
        }
    };

    public Double getSalesTax(){
        return price * .01 * taxPercent;
    }
    public Double getTotalLoan(){
        return price + getSalesTax() - downPayment - tradeInValue;
    }
    public Double getTotalInterest(){
        return getTotalAmount() - getTotalLoan();
    }
    public Double getTotalAmount(){
        return getMonthlyPayment() * numMonths;
    }
    public Double getMonthlyPayment(){
        double rate = 0.01 * rateInPercent / 12;
        return getTotalLoan() * (rate * Math.pow(1 + rate,numMonths))/(Math.pow(1 + rate,numMonths) - 1);
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Double downPayment) {
        this.downPayment = downPayment;
    }

    public Double getTradeInValue() {
        return tradeInValue;
    }

    public void setTradeInValue(Double tradeInValue) {
        this.tradeInValue = tradeInValue;
    }

    public Integer getNumMonths() {
        return numMonths;
    }

    public void setNumMonths(Integer numMonths) {
        this.numMonths = numMonths;
    }

    public Double getRateInPercent() {
        return rateInPercent;
    }

    public void setRateInPercent(Double rateInPercent) {
        this.rateInPercent = rateInPercent;
    }

    public Double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Double taxPercent) {
        this.taxPercent = taxPercent;
    }
}
