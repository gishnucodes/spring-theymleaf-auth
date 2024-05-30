package com.github.gishnu.basicauthsvc.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.github.gishnu.basicauthsvc.entity.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomUserDetailsServce implements UserDetails {

    private final  User user = User.builder().name("gishnu").password("password").isEnabled(true).build();

    @SuppressWarnings("unchecked")
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList authList = new ArrayList<GrantedAuthority>();
        authList.add(new GrantedAuthorityDefaults("ROLE_USER"));
        authList.add(new GrantedAuthorityDefaults("ROLE_ADMIN"));

        return authList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
    
    

} 
