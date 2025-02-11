package com.example.ApiMerkMobil.repository;

import com.example.ApiMerkMobil.entity.MerkMobil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerkMobilRepository extends JpaRepository<MerkMobil, Long> {
    Optional<MerkMobil> findByNama(String nama);
}
