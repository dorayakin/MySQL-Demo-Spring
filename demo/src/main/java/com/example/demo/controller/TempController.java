package com.example.demo.controller;

import com.example.demo.security.AppUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class TempController {

    @GetMapping("/")
    public String tempHome(Model model,@AuthenticationPrincipal AppUserDetails userDetails) {
        String userRole = userDetails.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElse("NO_ROLES");
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("userRole", userRole);
        return "index";
    }
}
