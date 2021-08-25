package com.bap.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.api.model.entity.Notifications;
import com.bap.api.service.NoticeService;

@RestController
public class NotificationsController {
    @Autowired
    private NoticeService notice;
    @GetMapping("admin/notifications")
    public ResponseEntity<List<Notifications>> getListUser() {
        return new ResponseEntity<>((List<Notifications>) notice.findAll(), HttpStatus.OK);

    }

}
