package com.example.LoanInfoService.service;

import com.example.LoanInfoService.model.Loan;
import com.example.LoanInfoService.model.LoanInfo;

import java.util.List;

public interface LoanInfoService {

    public void receivedMessage(LoanInfo loanInfo);

    public List<Loan> getAllLoans(String email);

    Loan updateLoan(String email,Loan newLoan, String id);
}
