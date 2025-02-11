package com.example.ApiMerkMobil.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "merk_mobil")
public class MerkMobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nama;

    @Column(name = "tahun_berdiri")
    private Integer tahunBerdiri;

    @Column(name = "negara_asal")
    private String negaraAsal;
}
