package com.kint.springsecurity.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @Column(name = "user_Id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(name = "first_name", length = 255)
    private String firstname;


    @Column(name = "last_name", length = 255)
    private String lastname;

    @Column(name = "email", length = 255)
    private String email;


    @Column(name = "password", length = 255)
    @JsonIgnore
    private String password;


    @Column(name = "phone_number", length = 255)
    private String phonenumber;

    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }
}
