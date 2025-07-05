package com.example.demo.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.AppUser;

public class AppUserDetails implements UserDetails{

    private final AppUser appUser;

    public AppUserDetails(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> appUser.getUserType().toString());
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Assuming account is never expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming account is never locked
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming credentials are never expired
    }

}
