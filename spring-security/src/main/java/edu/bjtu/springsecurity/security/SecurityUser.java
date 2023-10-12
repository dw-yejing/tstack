package edu.bjtu.springsecurity.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class SecurityUser extends User {
    private String id;

    public SecurityUser(String id, String username, String password, boolean accountNonExpired, boolean credentialsNonExpired, Collection<? extends GrantedAuthority> authorities){
        super(username, password, true, accountNonExpired, credentialsNonExpired, true,authorities);
        this.id = id;
    }

}
