package com.example.LoanInfoService.repository;

import com.example.LoanInfoService.model.Loan;
import com.example.LoanInfoService.model.LoanInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanInfoRepository extends JpaRepository<LoanInfo, String> {
    List<Loan> findByUserEmail(String userEmail);
}
