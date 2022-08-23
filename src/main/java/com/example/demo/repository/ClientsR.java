package com.example.demo.repository;

import com.example.demo.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsR extends JpaRepository<Clients, Long> {
}
