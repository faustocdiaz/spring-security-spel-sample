package com.overflow.spel.demo.sepldemo.repository;

import com.overflow.spel.demo.sepldemo.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {

    @Query("select s from Store s where s.myUser.id = ?#{principal.id}")
    List<Store> findByMyUserId();

}
