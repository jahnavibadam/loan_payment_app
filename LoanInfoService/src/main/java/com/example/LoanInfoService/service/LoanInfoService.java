package com.example.LoanInfoService.service;

import com.example.LoanInfoService.model.LoanInfo;

import java.util.List;


public interface LoanInfoService {

    public void receivedMessage(LoanInfo loanInfo);

    public List<LoanInfo> getAllLoans(String emailid);

    public LoanInfo getLoan(String emailid, String id);

    public LoanInfo updateLoan(String emailid, String id, String amount);
//
//    Loan updateLoan(String email,Loan newLoan, String id);
}
