package com.emse.spring.automacorp.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/api/admin/username")
    public String getAdminUsername(@AuthenticationPrincipal UserDetails userDetails) {
        return "Admin username: " + userDetails.getUsername();
    }
}