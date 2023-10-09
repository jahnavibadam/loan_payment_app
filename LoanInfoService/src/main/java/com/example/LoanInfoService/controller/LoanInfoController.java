package com.example.LoanInfoService.controller;

import com.example.LoanInfoService.model.LoanInfo;
import com.example.LoanInfoService.service.LoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LoanInfoController {

    @Autowired
    private LoanInfoService service;

    @GetMapping("/loanInformation")
    public List<LoanInfo> getAllLoans(@RequestHeader String emailid) {
        return service.getAllLoans(emailid);
    }

    @GetMapping("/test")
    public String test(){
        return "Loan Controller works";
    }
//
//    @PutMapping("/loanInformation/{id}")
//    public ResponseEntity<?> updateLoanStatus(@RequestHeader String email, @RequestBody Loan newLoan, @PathVariable String id){
//        Loan updatedLoan=service.updateLoan(email,newLoan,id);
//        return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
//    }
}
