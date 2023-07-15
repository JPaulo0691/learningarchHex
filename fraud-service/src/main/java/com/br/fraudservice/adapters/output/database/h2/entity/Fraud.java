package com.br.fraudservice.adapters.output.database.h2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Fraud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String document;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
