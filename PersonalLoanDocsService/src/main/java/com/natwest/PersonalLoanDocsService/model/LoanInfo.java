package com.natwest.PersonalLoanDocsService.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = LoanInfo.class)
public class LoanInfo implements Serializable {

    @Id
    private String loanId;
    private String loanType;  //personal home car gold
    private String loanStatus;  //pending, accepted, rejected
    private String loanAmount; //submitted loan Amount
    private String loanEmi; //loan emi
    private String loanPending; //amount left to be paid
    private String loanTenure;

    private String emailid;
    private String aadhaar;
    private String mobile;

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LoanInfo() {
    }

    public LoanInfo(String loanId, String loanType, String loanStatus, String loanAmount, String loanEmi, String loanPending, String loanTenure) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanStatus = loanStatus;
        this.loanAmount = loanAmount;
        this.loanEmi = loanEmi;
        this.loanPending = loanPending;
        this.loanTenure = loanTenure;
    }

    public LoanInfo(String loanId, String loanType, String loanStatus, String loanAmount, String loanEmi, String loanPending, String loanTenure, String emailid) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanStatus = loanStatus;
        this.loanAmount = loanAmount;
        this.loanEmi = loanEmi;
        this.loanPending = loanPending;
        this.loanTenure = loanTenure;
        this.emailid = emailid;
    }


    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanEmi() {
        return loanEmi;
    }

    public void setLoanEmi(String loanEmi) {
        this.loanEmi = loanEmi;
    }

    public String getLoanPending() {
        return loanPending;
    }

    public void setLoanPending(String loanPending) {
        this.loanPending = loanPending;
    }

    public String getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(String loanTenure) {
        this.loanTenure = loanTenure;
    }
}
