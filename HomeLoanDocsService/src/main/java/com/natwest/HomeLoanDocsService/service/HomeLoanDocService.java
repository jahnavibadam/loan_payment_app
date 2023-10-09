package com.natwest.HomeLoanDocsService.service;

import com.natwest.HomeLoanDocsService.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HomeLoanDocService {
    void uploadFile(MultipartFile aadhaarCard,
                    MultipartFile panCard,
                    MultipartFile signatureProof,
                    MultipartFile addressProof,
                    MultipartFile bankStatements,
                    MultipartFile paymentReceipts,
                    MultipartFile occupancyCertificate,
                    MultipartFile approvedPlanCopy,
                    MultipartFile form16,
                    String tenure,
                    String emi,
                    String aadhaarNumber,
                    String firstName,
                    String lastName,
                    String panNumber
    ) throws IOException;

    void getAllFiles();
}
