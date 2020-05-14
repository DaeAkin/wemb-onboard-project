package com.wemb.toy.domain.user.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wemb.toy.BaseAuditingEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Slf4j
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private long id;

    public User(String name, String password, Integer number) {
        this.name = name;
        this.password = password;
        this.number = number;
    }


    private String name;
    @com.fasterxml.jackson.annotation.JsonIgnore
    private String password;

    @Min(0)
    @Max(150)
    private Integer number;


    @Override
    @com.fasterxml.jackson.annotation.JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    public void initialize(PasswordEncoder encoder) {
        encodePassword(encoder);
    }

    private void encodePassword(PasswordEncoder encoder) {
        this.password = encoder.encode(this.password);
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    @com.fasterxml.jackson.annotation.JsonIgnore
    public String getUsername() {
        return Long.toString(id);
    }

    @Override
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @com.fasterxml.jackson.annotation.JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}