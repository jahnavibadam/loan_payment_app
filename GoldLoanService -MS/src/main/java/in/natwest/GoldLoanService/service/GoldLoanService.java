package in.natwest.GoldLoanService.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GoldLoanService {
    public void uploadFile(MultipartFile aadhaardCard,
                           MultipartFile panCard,
                           MultipartFile addressProof,
                           String tenure,
                           String emi,
                           String aadhaarNumber, String firstName,
                           String lastName,
                           String panNumber
    ) throws IOException;

    public void getAllFiles();

}
