package com.overflow.spel.demo.sepldemo.repository;


import com.overflow.spel.demo.sepldemo.domain.MyAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyAuthorityRepository extends JpaRepository<MyAuthority,Integer> {
}
