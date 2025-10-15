package com.sakhi.store.service;

import com.sakhi.store.model.User;
import com.sakhi.store.repository.UserRepository;
import com.sakhi.store.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public String sendOtp(String mobileNumber) {
        String otp = String.format("%06d", new Random().nextInt(999999));
        User user = userRepository.findByMobileNumber(mobileNumber)
                .orElse(User.builder().mobileNumber(mobileNumber).build());
        user.setOtp(otp);
        user.setVerified(false);
        userRepository.save(user);
        return "OTP sent to " + mobileNumber + ": " + otp;
    }

    public String verifyOtp(String mobileNumber, String otp) {
        User user = userRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!otp.equals(user.getOtp())) throw new RuntimeException("Invalid OTP");
        user.setVerified(true);
        user.setOtp(null);
        userRepository.save(user);
        return jwtUtil.generateToken(mobileNumber);
    }
}
