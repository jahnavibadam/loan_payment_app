package com.example.otpservice.service;

import com.example.otpservice.model.OtpModel;

public interface OtpService {
    public String generateOtp();

    public void sendOtp(String phoneNumber);

    public boolean authenticateOtp(String phoneNumber, String otp);


}
