package com.sakhi.store.model;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String mobileNumber;

    private String otp;        // temporary OTP (for verification)
    private boolean verified;  // whether mobile is verified
}

