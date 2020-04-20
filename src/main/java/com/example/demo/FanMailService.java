package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FanMailService {

    @Autowired
    FanMailRepository fanMailRepository;

    public void createMail(FanMail fanmail) {
        java.util.Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        fanMailRepository.createMail(fanmail, sqlDate);
    }
}
