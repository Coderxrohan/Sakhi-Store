package com.sakhi.store.dto.response;
import lombok.Data;
@Data
public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private String businessName;
    private String address;
}
