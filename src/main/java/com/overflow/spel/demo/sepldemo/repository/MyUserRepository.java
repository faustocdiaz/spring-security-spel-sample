package com.overflow.spel.demo.sepldemo.repository;


import com.overflow.spel.demo.sepldemo.domain.MyUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MyUserRepository extends CrudRepository<MyUser,Long> {
    public Optional<MyUser> findFirstByUsername(String username);
}
