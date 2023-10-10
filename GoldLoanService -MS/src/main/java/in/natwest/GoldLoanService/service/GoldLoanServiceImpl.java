package in.natwest.GoldLoanService.service;

import in.natwest.GoldLoanService.model.FileInfo;
import in.natwest.GoldLoanService.model.FileProps;
import in.natwest.GoldLoanService.model.LoanInfo;
import in.natwest.GoldLoanService.repository.GoldLoanRepository;
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
public class GoldLoanServiceImpl implements GoldLoanService {
    @Autowired
    private GoldLoanRepository repository;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void uploadFile(MultipartFile aadhaardCard,
                           MultipartFile panCard,
                           MultipartFile addressProof,
                           String tenure,
                           String emi,
                           String aadhaarNumber, String firstName, String lastName, String panNumber) throws IOException {
        FileInfo file = new FileInfo();
        file.setLoanType("personal");
        file.setAadhaarNumber(aadhaarNumber);
        file.setTenure(tenure);
        file.setEmi(emi);
        file.setFirstName(firstName);
        file.setLastName(lastName);
        file.setPanNumber(panNumber);

        saveFile(aadhaardCard, file.getAadhaarCard());
        saveFile(panCard, file.getPanCard());

        saveFile(addressProof, file.getAddressProof());


        String date = LocalDate.now().toString();

        Object loanInfo = new LoanInfo(UUID.randomUUID().toString(),"gold","pending",emi,tenure,tenure,"10000","0","10000","10.49","0","0",date,"abc@gmail.com",aadhaarNumber);
        rabbitTemplate.convertAndSend("rabbitmq_exchangeKey", "rabbitmq_routeKey", loanInfo);

        repository.save(file);

    }

    @Override
    public void getAllFiles() {
        List<FileInfo> fileInfoList = repository.findAll();

        String baseFilePath="/Users/HP/Desktop/goldloan";

        fileInfoList.forEach(file->{
            List<FileProps> allDocs = new ArrayList<>();
            allDocs.add(file.getAadhaarCard());
            allDocs.add(file.getPanCard());
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
                    byte[] data = doc.getFiledata();
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
        fileProps.setFiledata(file.getBytes());
        fileProps.setContentType(file.getContentType());
    }


}

