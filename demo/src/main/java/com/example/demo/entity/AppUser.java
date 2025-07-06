package com.example.demo.entity;

import com.example.demo.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private UserType userType;

    private Long createdBy;

    private LocalDateTime createdAt;

    private Long UpdatedBy;

    private LocalDateTime updatedAt;

    private Long deletedBy;

    private LocalDateTime deletedAt;
}
