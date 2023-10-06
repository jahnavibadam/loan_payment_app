package com.example.LoanInfoService.controller;

import com.example.LoanInfoService.model.Loan;
import com.example.LoanInfoService.service.LoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1")
public class LoanInfoController {

    @Autowired
    private LoanInfoService service;

    @GetMapping("/loanInformation")
    public List<Loan> getAllLoans(@RequestHeader String email) {
        return service.getAllLoans(email);
    }

    @PutMapping("/loanInformation/{id}")
    public ResponseEntity<?> updateLoanStatus(@RequestHeader String email, @RequestBody Loan newLoan, @PathVariable String id){
        Loan updatedLoan=service.updateLoan(email,newLoan,id);
        return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
    }
}
