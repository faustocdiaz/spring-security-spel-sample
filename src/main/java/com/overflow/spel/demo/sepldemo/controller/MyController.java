package com.overflow.spel.demo.sepldemo.controller;


import com.overflow.spel.demo.sepldemo.domain.Store;
import com.overflow.spel.demo.sepldemo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    StoreRepository storeRepository;

    @RequestMapping("/stores")
    public List<Store> getStores(){

        return storeRepository.findByMyUserId();

    }
}
