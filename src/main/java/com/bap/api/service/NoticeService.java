package com.bap.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.api.model.entity.Notifications;
import com.bap.api.model.entity.Users;
import com.bap.api.repository.NotificationRep;
@Service
public class NoticeService {
    @Autowired
    private NotificationRep notice;
    public List<Notifications> findAll() {
        return notice.findAll();
    }
    public Notifications create(Notifications n) {
        return notice.save(n);
    }
}
