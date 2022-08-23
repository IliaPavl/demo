package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User implements UserDetails {
    private static final String ACTIVE = "Active";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    @NonNull
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Client_ID", unique = true)
    @NonNull
    private Clients clients;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserRole_ID")
    @NonNull
    private UserRole userRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserStatus_ID")
    @NonNull
    private UserStatus userStatus;

    @Column(name = "UserFIO")
    @NotNull
    @NonNull
    private String userFio;

    @Column(name = "UserLogin")
    @NotNull
    @NonNull
    private String userLogin;

    @Column(name = "UserPwd")
    @NotNull
    @NonNull
    private String userPwd;

    @Column(name = "UserEmail")
    @NotNull
    @NonNull
    private String userEmail;

    @Column(name = "UserRegistration_link")
    @NotNull
    @NonNull
    private String userRegistrationLink;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(userRole);
    }

    @Override
    public String getPassword() {
        return userPwd;
    }

    @Override
    public String getUsername() {
        return userLogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return userStatus.getUserStatus().equals(ACTIVE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return userStatus.getUserStatus().equals(ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userStatus.getUserStatus().equals(ACTIVE);
    }

    @Override
    public boolean isEnabled() {
        return userStatus.getUserStatus().equals(ACTIVE);
    }
}
