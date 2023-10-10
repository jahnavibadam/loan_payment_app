package com.natwest.PersonalLoanDocsService.service;

import com.natwest.PersonalLoanDocsService.model.ZipFileContent;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    public ZipFileContent getFileById(String id) throws IOException;
}
