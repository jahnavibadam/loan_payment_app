package com.example.LoanInfoService.controller;

import com.example.LoanInfoService.model.LoanInfo;
import com.example.LoanInfoService.service.LoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class LoanInfoController {

    @Autowired
    private LoanInfoService service;

    @GetMapping("/getAll")
    public List<LoanInfo> getAllLoans(){
        return service.getAllLoans();
    }

    @GetMapping("/loanInformation")
    public List<LoanInfo> getAllLoans(@RequestHeader String emailid) {
        return service.getAllLoans(emailid);
    }

    @GetMapping("/test")
    public String test(){
        return "Loan Controller works";
    }

    @PostMapping("/approve/{loanId}")
    public ResponseEntity<?> approveLoan(@PathVariable String loanId){
        return new ResponseEntity<>(service.approveLoanById(loanId), HttpStatus.OK);
    }

    @PostMapping("/reject/{loanId}")
    public ResponseEntity<?> rejectLoan(@PathVariable String loanId){
        return new ResponseEntity<>(service.rejectLoanById(loanId),HttpStatus.OK);
    }
//
//    @PutMapping("/loanInformation/{id}")
//    public ResponseEntity<?> updateLoanStatus(@RequestHeader String email, @RequestBody Loan newLoan, @PathVariable String id){
//        Loan updatedLoan=service.updateLoan(email,newLoan,id);
//        return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
//    }
}
