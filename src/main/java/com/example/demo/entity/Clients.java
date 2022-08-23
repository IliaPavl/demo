package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Client_ID")
    @NonNull
    private Long id;
    @Column(name = "ClientName")
    @NonNull
    private String clientName;
    @Column(name = "FullName")
    @NonNull
    private String fullName;
    @Column(name = "Number")
    @NonNull
    private String number;
    @Column(name = "DateAdd")
    @NonNull
    private Date dateAdd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ClientStatus_ID")
    @NonNull
    private ClientStatus status;

}
