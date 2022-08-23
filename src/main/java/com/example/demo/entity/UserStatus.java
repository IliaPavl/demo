package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserStatus_ID")
    @NonNull
    private Long id;
    @Column(name = "UserStatusName")
    @NonNull
    private String userStatus;

}
