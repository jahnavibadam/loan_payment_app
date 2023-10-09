package com.natwest.PersonalLoanDocsService.service;

import com.natwest.PersonalLoanDocsService.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PersonalLoanDocService {
    public void uploadFile(MultipartFile aadhaardCard,
                           MultipartFile panCard,
                           MultipartFile signatureProof,
                           MultipartFile addressProof,
                           MultipartFile bankStatements,
                           MultipartFile salarySlips,
                           String tenure,
                           String emi,
                           String aadhaarNumber,
                           String firstName,
                           String lastName,
                           String panNumber
                           ) throws IOException;

    public void getAllFiles();
}
