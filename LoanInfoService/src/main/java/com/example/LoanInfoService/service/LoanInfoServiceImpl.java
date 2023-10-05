package com.example.LoanInfoService.service;

import com.example.LoanInfoService.model.LoanInfo;
import com.example.LoanInfoService.repository.LoanInfoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
