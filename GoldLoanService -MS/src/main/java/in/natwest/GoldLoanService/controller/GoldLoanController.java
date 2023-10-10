package in.natwest.GoldLoanService.controller;

import in.natwest.GoldLoanService.service.GoldLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/loan/gold/docs")
public class GoldLoanController {
    @Autowired
    private GoldLoanService service;
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("aadhaarCard") MultipartFile aadhaardCard,
                             @RequestParam("panCard") MultipartFile panCard,
                             @RequestParam("addressProof") MultipartFile addressProof,
                             @RequestParam("tenure") String tenure,
                             @RequestParam("emi") String emi,
                             @RequestParam("aadhaarNumber") String aadhaarNumber,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("panNumber") String panNumber
    )
            throws IOException {
        service.uploadFile(aadhaardCard, panCard, addressProof,tenure, emi, aadhaarNumber,firstName,lastName,panNumber);
        return "Success";
    }

    @GetMapping("/get")
    public String getFiles(){
        service.getAllFiles();
        return "Success";
    }


}

