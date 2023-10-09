package com.natwest.HomeLoanDocsService.controller;

import com.natwest.HomeLoanDocsService.model.FileInfo;
import com.natwest.HomeLoanDocsService.service.HomeLoanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("")
public class HomeLoanDocController {

    @Autowired
    private HomeLoanDocService homeLoanDocService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("aadhaarCard") MultipartFile aadhaarCard,
                             @RequestParam("panCard") MultipartFile panCard,
                             @RequestParam("signatureProof") MultipartFile signatureProof,
                             @RequestParam("addressProof") MultipartFile addressProof,
                             @RequestParam("bankStatements") MultipartFile bankStatements,
                             @RequestParam("paymentReceipts") MultipartFile paymentReceipts,
                             @RequestParam("occupancyCertificate") MultipartFile occupancyCertificate,
                             @RequestParam("approvedPlanCopy") MultipartFile approvedPlanCopy,
                             @RequestParam("form16") MultipartFile form16,
                             @RequestParam("tenure") String tenure,
                             @RequestParam("emi") String emi,
                             @RequestParam("aadhaarNumber") String aadhaarNumber,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("panNumber") String panNumber) throws IOException {
        homeLoanDocService.uploadFile(aadhaarCard, panCard, signatureProof, addressProof, bankStatements, paymentReceipts,
                occupancyCertificate, approvedPlanCopy, form16, tenure, emi, aadhaarNumber, firstName, lastName, panNumber);
        return "Success";
    }

    @GetMapping("/get")
    public String getFiles(){
        homeLoanDocService.getAllFiles();
        return "Success";
    }
}
