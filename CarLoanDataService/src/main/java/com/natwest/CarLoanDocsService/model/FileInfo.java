package com.natwest.CarLoanDocsService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personalLoanDocs")
public class FileInfo {
//    firstName: '',
//    middleName:'',
//    lastName:'',
//    aadhar:'',
//    PAN:'',
//    loanAmt:'',
//    // roi:'',
//    tenure:'',
//    monthlyIncome:'',
//    monthlyExpense:'',
//    panCard: null,
//    aadharCard: null,
//    incomeProof: null,
//    bankStatement: null,
//    drivingLicense: null,

    @Id
    private String id;
    private String loanType;
    private String aadhar;
    private String tenure;
    private String emi;
    private FileProps aadharCard = new FileProps();
    private FileProps panCard = new FileProps();
    private FileProps incomeProof = new FileProps();

    private FileProps bankStatement = new FileProps();
    private FileProps drivingLicense = new FileProps();

    public FileInfo() {
    }

    public FileInfo(String id, String loanType, String aadhar, String tenure, String emi, FileProps aadharCard, FileProps panCard, FileProps incomeProof, FileProps bankStatement, FileProps drivingLicense) {
        this.id = id;
        this.loanType = loanType;
        this.aadhar = aadhar;
        this.tenure = tenure;
        this.emi = emi;
        this.aadharCard = aadharCard;
        this.panCard = panCard;
        this.incomeProof = incomeProof;
        this.bankStatement = bankStatement;
        this.drivingLicense = drivingLicense;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getEmi() {
        return emi;
    }

    public void setEmi(String emi) {
        this.emi = emi;
    }

    public FileProps getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(FileProps aadharCard) {
        this.aadharCard = aadharCard;
    }

    public FileProps getPanCard() {
        return panCard;
    }

    public void setPanCard(FileProps panCard) {
        this.panCard = panCard;
    }

    public FileProps getIncomeProof() {
        return incomeProof;
    }

    public void setIncomeProof(FileProps incomeProof) {
        this.incomeProof = incomeProof;
    }

    public FileProps getBankStatement() {
        return bankStatement;
    }

    public void setBankStatement(FileProps bankStatement) {
        this.bankStatement = bankStatement;
    }

    public FileProps getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(FileProps drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
}
