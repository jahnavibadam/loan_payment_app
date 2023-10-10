package com.natwest.CarLoanDocsService.service;

import com.natwest.CarLoanDocsService.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CarLoanDocService {
    public void uploadFile(MultipartFile aadhaarCard,
                           MultipartFile panCard,
                           MultipartFile incomeProof,
                           MultipartFile bankStatement,
                           MultipartFile drivingLicense,
                           String tenure,
                           String emi,
                           String aadhaarNumber,
                           String firstName,
                           String lastName,
                           String panNumber
    ) throws IOException;

    public void getAllFiles();
}
