package com.example.LoanInfoService.model;

public class Loan {
    private String loanId;
    private String totalPrincipal;
    private String totalAmountPaid;
    private String emi;
    private String amountPaid;
    private String principalLeft;
    private String rateOfInterest;
    private String paidEmiNumber;
    private String missedEmi;
    private String tenureLeft;

    public Loan() {
    }


    public Loan(String loanId, String totalPrincipal, String totalAmountPaid, String emi, String amountPaid, String principalLeft, String rateOfInterest, String paidEmiNumber, String missedEmi, String tenureLeft) {
        this.loanId = loanId;
        this.totalPrincipal = totalPrincipal;
        this.totalAmountPaid = totalAmountPaid;
        this.emi = emi;
        this.amountPaid = amountPaid;
        this.principalLeft = principalLeft;
        this.rateOfInterest = rateOfInterest;
        this.paidEmiNumber = paidEmiNumber;
        this.missedEmi = missedEmi;
        this.tenureLeft = tenureLeft;
    }

    public String getMissedEmi() {
        return missedEmi;
    }

    public void setMissedEmi(String missedEmi) {
        this.missedEmi = missedEmi;
    }

    public String getPaidEmiNumber() {
        return paidEmiNumber;
    }

    public void setPaidEmiNumber(String paidEmiNumber) {
        this.paidEmiNumber = paidEmiNumber;
    }

    public String getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(String rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getTenureLeft() {
        return tenureLeft;
    }

    public void setTenureLeft(String tenureLeft) {
        this.tenureLeft = tenureLeft;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getTotalPrincipal() {
        return totalPrincipal;
    }

    public void setTotalPrincipal(String totalPrincipal) {
        this.totalPrincipal = totalPrincipal;
    }

    public String getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(String totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public String getEmi() {
        return emi;
    }

    public void setEmi(String emi) {
        this.emi = emi;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPrincipalLeft() {
        return principalLeft;
    }

    public void setPrincipalLeft(String principalLeft) {
        this.principalLeft = principalLeft;
    }
}
