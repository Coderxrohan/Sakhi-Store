package com.sakhi.store.dto.request;
import lombok.Data;
@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private String businessName;
    private String address;
}
