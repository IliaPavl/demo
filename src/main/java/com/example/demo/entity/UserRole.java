package com.example.demo.entity;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ConstructorBinding()
@AllArgsConstructor()
public class UserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserRole_ID")
    @NonNull
    private Long id;
    @Column(name = "UserRoleName")
    @NonNull
    private String userRole;

    @Override
    public String getAuthority() {
        return userRole;
    }
}
