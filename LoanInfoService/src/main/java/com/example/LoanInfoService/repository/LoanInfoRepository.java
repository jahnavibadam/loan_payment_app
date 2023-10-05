package com.example.LoanInfoService.repository;

import com.example.LoanInfoService.model.LoanInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanInfoRepository extends JpaRepository<LoanInfo, String> {
}
