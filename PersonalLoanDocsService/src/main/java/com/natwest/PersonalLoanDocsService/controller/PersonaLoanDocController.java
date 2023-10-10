package com.natwest.PersonalLoanDocsService.controller;

import com.natwest.PersonalLoanDocsService.model.ZipFileContent;
import com.natwest.PersonalLoanDocsService.service.PersonalLoanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/loan/personal/docs")
@CrossOrigin(origins = "*")
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

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ZipFileContent> getFilesById(@PathVariable String id) throws IOException {
        return new ResponseEntity<>(personalLoanDocService.getFileById(id), HttpStatus.OK);
    }

}
