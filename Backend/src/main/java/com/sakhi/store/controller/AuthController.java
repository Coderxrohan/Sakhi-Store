package com.sakhi.store.controller;

import com.sakhi.store.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String mobileNumber) {
        return authService.sendOtp(mobileNumber);
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String mobileNumber, @RequestParam String otp) {
        return authService.verifyOtp(mobileNumber, otp);
    }
}
