package com.natwest.CarLoanDocsService.repository;

import com.natwest.CarLoanDocsService.model.FileInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarLoanDocRepository extends MongoRepository<FileInfo,String> {
}
