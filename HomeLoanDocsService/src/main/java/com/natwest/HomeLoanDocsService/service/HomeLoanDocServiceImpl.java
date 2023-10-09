

package com.natwest.HomeLoanDocsService.service;

import com.natwest.HomeLoanDocsService.model.FileInfo;
import com.natwest.HomeLoanDocsService.model.FileProps;
import com.natwest.HomeLoanDocsService.model.LoanInfo;
import com.natwest.HomeLoanDocsService.repository.HomeLoanDocRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HomeLoanDocServiceImpl implements HomeLoanDocService{

    @Autowired
    private HomeLoanDocRepository homeLoanDocRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void uploadFile(MultipartFile aadhaarCard,
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
                           String aadhaarNumber, String firstName, String lastName, String panNumber) throws IOException {
        FileInfo file = new FileInfo();
        file.setLoanType("home");
        file.setAadhaarNumber(aadhaarNumber);
        file.setTenure(tenure);
        file.setEmi(emi);

        saveFile(aadhaarCard, file.getAadhaarCard());
        saveFile(panCard, file.getPanCard());
        saveFile(signatureProof, file.getSignatureProof());
        saveFile(addressProof, file.getAddressProof());
        saveFile(bankStatements, file.getBankStatements());
        saveFile(paymentReceipts, file.getPaymentReceipts());
        saveFile(occupancyCertificate, file.getOccupancyCertificate());
        saveFile(approvedPlanCopy, file.getApprovedPlanCopy());
        saveFile(form16, file.getForm16());

        String date = LocalDate.now().toString();

        Object loanInfo = new LoanInfo(UUID.randomUUID().toString(),"home","pending",emi,tenure,tenure,"10000","0","10000","10.49","0","0",date,"abc@gmail.com",aadhaarNumber);
        rabbitTemplate.convertAndSend("rabbitmq_exchangeKey", "rabbitmq_routeKey", loanInfo);

        homeLoanDocRepository.save(file);

    }

    @Override
    public void getAllFiles() {
        List<FileInfo> fileInfoList = homeLoanDocRepository.findAll();

        String baseFilePath = "";

        fileInfoList.forEach(file->{
            List<FileProps> allDocs = new ArrayList<>();
            allDocs.add(file.getAadhaarCard());
            allDocs.add(file.getPanCard());
            allDocs.add(file.getSignatureProof());
            allDocs.add(file.getSignatureProof());
            allDocs.add(file.getBankStatements());
            allDocs.add(file.getAddressProof());
            allDocs.add(file.getPaymentReceipts());
            allDocs.add(file.getOccupancyCertificate());
            allDocs.add(file.getApprovedPlanCopy());
            allDocs.add(file.getForm16());

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
