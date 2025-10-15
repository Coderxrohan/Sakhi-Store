package com.sakhi.store.controller;
import com.sakhi.store.dto.request.LoginRequest;
import com.sakhi.store.dto.request.RegisterRequest;
import com.sakhi.store.dto.response.AuthResponse;
import com.sakhi.store.model.User;
import com.sakhi.store.payload.ApiResponse;
import com.sakhi.store.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final ModelMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        User u = mapper.map(req, User.class);
        User created = userService.register(u);
        return ResponseEntity.ok(new ApiResponse(true, "User registered", mapper.map(created, com.sakhi.store.dto.response.UserResponse.class)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        String token = userService.login(req.getEmail(), req.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
