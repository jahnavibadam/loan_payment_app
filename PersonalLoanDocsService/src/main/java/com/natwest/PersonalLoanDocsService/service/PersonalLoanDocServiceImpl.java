package com.natwest.PersonalLoanDocsService.service;

import com.natwest.PersonalLoanDocsService.model.FileInfo;
import com.natwest.PersonalLoanDocsService.model.FileProps;
import com.natwest.PersonalLoanDocsService.repository.PersonalLoanDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalLoanDocServiceImpl implements PersonalLoanDocService{

    @Autowired
    private PersonalLoanDocRepository personalLoanDocRepository;

    @Override
    public void uploadFile(MultipartFile aadhaardCard,
                           MultipartFile panCard,
                           MultipartFile signatureProof,
                           MultipartFile addressProof,
                           MultipartFile bankStatements,
                           MultipartFile salarySlips,
                           String tenure,
                           String emi,
                           String aadhaarNumber) throws IOException {
        FileInfo file = new FileInfo();
        file.setLoanType("personal");
        file.setAadhaarNumber(aadhaarNumber);
        file.setTenure(tenure);
        file.setEmi(emi);

        saveFile(aadhaardCard, file.getAadhaarCard());
        saveFile(panCard, file.getPanCard());
        saveFile(signatureProof, file.getSignatureProof());
        saveFile(addressProof, file.getAddressProof());
        saveFile(bankStatements, file.getBankStatements());
        saveFile(salarySlips, file.getSalarySlips());

        personalLoanDocRepository.save(file);

    }

    @Override
    public void getAllFiles() {
        List<FileInfo> fileInfoList = personalLoanDocRepository.findAll();

        String baseFilePath = "/Users/ramkumar/Desktop/personalLoanDocs/";

        fileInfoList.forEach(file->{
            List<FileProps> allDocs = new ArrayList<>();
            allDocs.add(file.getAadhaarCard());
            allDocs.add(file.getPanCard());
            allDocs.add(file.getSignatureProof());
            allDocs.add(file.getSignatureProof());
            allDocs.add(file.getBankStatements());
            allDocs.add(file.getAddressProof());

            String aadhaarNumber = file.getAadhaarNumber();
            String filePath = baseFilePath + aadhaarNumber + '/';

            File folder = new java.io.File(filePath);
            if (!folder.exists()) {
                if (folder.mkdirs()) {
                    System.out.println("Folder created successfully.");
                } else {
                    throw new RuntimeException("Failed to create the folder.");
                }
            }

            allDocs.forEach(doc -> {
                String originalFileName = doc.getFileName();
                String modifiedFileName = originalFileName;
                int count = 1;

                // Check for existing files with the same name
                while (new java.io.File(filePath + modifiedFileName).exists()) {
                    int dotIndex = originalFileName.lastIndexOf('.');
                    String fileNameWithoutExtension = dotIndex > 0 ? originalFileName.substring(0, dotIndex) : originalFileName;
                    String fileExtension = dotIndex > 0 ? originalFileName.substring(dotIndex) : "";
                    modifiedFileName = fileNameWithoutExtension + " (" + count + ")" + fileExtension;
                    count++;
                }

                try {
                    FileOutputStream fos = new FileOutputStream(filePath + modifiedFileName);
                    byte[] data = doc.getData();
                    fos.write(data);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });

    }

    public void saveFile(MultipartFile file, FileProps fileProps) throws IOException {
        fileProps.setFileName(file.getOriginalFilename());
        fileProps.setData(file.getBytes());
        fileProps.setContentType(file.getContentType());
    }
}
