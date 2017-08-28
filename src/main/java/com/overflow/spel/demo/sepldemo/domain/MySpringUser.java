package com.overflow.spel.demo.sepldemo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MySpringUser  extends User {

    private MyUser user;

    public MySpringUser(MyUser myUser, Collection<? extends GrantedAuthority> authorities) {
        super(myUser.getUsername(), myUser.getPassword(), myUser.isEnabled()
                , true, true, true, authorities);

        this.setUser(myUser);
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public Long getId(){
        return this.getUser().getId();
    }
}
