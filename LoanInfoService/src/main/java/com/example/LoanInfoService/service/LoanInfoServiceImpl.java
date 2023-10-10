package com.example.LoanInfoService.service;

import com.example.LoanInfoService.model.LoanInfo;
import com.example.LoanInfoService.repository.LoanInfoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanInfoServiceImpl implements LoanInfoService{

    @Autowired
    private LoanInfoRepository loanInfoRepository;
    @Override
    @RabbitListener(queues = "rabbitmq_queueLoan")
    public void receivedMessage(LoanInfo loanInfo) {
        //we receive the data from personal loan registry
        System.out.println(loanInfo);
        loanInfoRepository.save(loanInfo);
    }

    @Override
    public List<LoanInfo> getAllLoans(String emailid){
        return loanInfoRepository.findByEmailid(emailid);
    }

    @Override
    public List<LoanInfo> getAllLoans(){
        return loanInfoRepository.findAll();
    }

    @Override
    public String approveLoanById(String loanId) {
        LoanInfo loanInfo = loanInfoRepository.getByLoanId(loanId);
        loanInfo.setLoanStatus("approved");
        loanInfoRepository.save(loanInfo);
        return "Approved";
    }

    @Override
    public String rejectLoanById(String loanId) {
        LoanInfo loanInfo = loanInfoRepository.getByLoanId(loanId);
        loanInfo.setLoanStatus("rejected");
        loanInfoRepository.save(loanInfo);
        return "Rejected";
    }
}
