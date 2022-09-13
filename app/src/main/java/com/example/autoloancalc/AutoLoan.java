package com.example.autoloancalc;

public class AutoLoan {
    private Double price;
    private Double downPayment;
    private Double tradeInValue;
    private Integer numMonths;
    private Double rateInPercent;
    private Double taxPercent;

    public AutoLoan(Double price, Double downPayment, Double tradeInValue, Integer numMonths, Double rateInPercent, Double taxPercent) {
        this.price = price;
        this.downPayment = downPayment;
        this.tradeInValue = tradeInValue;
        this.numMonths = numMonths;
        this.rateInPercent = rateInPercent;
        this.taxPercent = taxPercent;
    }
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
