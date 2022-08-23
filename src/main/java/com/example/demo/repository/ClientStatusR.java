package com.example.demo.repository;

import com.example.demo.entity.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientStatusR extends JpaRepository<ClientStatus, Long> {
}
