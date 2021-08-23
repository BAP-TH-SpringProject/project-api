package com.bap.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class NotificationsController {
@GetMapping("/notifications")
public String getListUser() {
    String notice ="Notification";
    return notice;
}
}
