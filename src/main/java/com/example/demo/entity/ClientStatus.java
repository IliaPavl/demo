package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClientStatus_ID")
    @NonNull
    private Long id;
    @Column(name = "ClientStatusName")
    @NonNull
    private String clientStatus;
}
