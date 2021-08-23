package com.bap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bap.api.model.entity.Notifications;

@Repository
public interface NotificationRep  extends JpaRepository<Notifications, Long>{

}
