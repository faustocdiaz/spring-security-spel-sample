package com.overflow.spel.demo.sepldemo.security;

import com.overflow.spel.demo.sepldemo.domain.MySpringUser;
import com.overflow.spel.demo.sepldemo.domain.MyUser;
import com.overflow.spel.demo.sepldemo.repository.MyUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    //Principal
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<MyUser> myUser = myUserRepository.findFirstByUsername(s);

        return myUser.map( (user) -> {
            return new MySpringUser(
                    user,
                    user.getMyAuthorities().stream().
                            map( authority ->
                                    new SimpleGrantedAuthority(authority.getName())).
                            collect(Collectors.toList()));
        }).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
