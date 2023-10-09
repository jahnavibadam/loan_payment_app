package com.natwest.PersonalLoanDocsService.controller;

import com.natwest.PersonalLoanDocsService.model.FileInfo;
import com.natwest.PersonalLoanDocsService.service.PersonalLoanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loan/personal/docs")
public class PersonaLoanDocController {

    @Autowired
    private PersonalLoanDocService personalLoanDocService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("aadhaarCard") MultipartFile aadhaardCard,
                           @RequestParam("panCard") MultipartFile panCard,
                           @RequestParam("signatureProof") MultipartFile signatureProof,
                           @RequestParam("addressProof") MultipartFile addressProof,
                           @RequestParam("bankStatements") MultipartFile bankStatements,
                           @RequestParam("salarySlips") MultipartFile salarySlips,
                           @RequestParam("tenure") String tenure,
                           @RequestParam("emi") String emi,
                           @RequestParam("aadhaarNumber") String aadhaarNumber,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("panNumber") String panNumber  )
            throws IOException {
        personalLoanDocService.uploadFile(aadhaardCard, panCard, signatureProof, addressProof, bankStatements, salarySlips, tenure, emi, aadhaarNumber, firstName, lastName, panNumber);
        return "Success";
    }

    @GetMapping("/get")
    public String getFiles(){
       personalLoanDocService.getAllFiles();
       return "Success";
    }
}
