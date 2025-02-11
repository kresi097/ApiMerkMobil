package com.example.ApiMerkMobil.service;

import com.example.ApiMerkMobil.entity.MerkMobil;
import com.example.ApiMerkMobil.repository.MerkMobilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerkMobilService {

    @Autowired
    private MerkMobilRepository merkMobilRepository;

    public List<MerkMobil> getAllMerkMobil() {
        return merkMobilRepository.findAll();
    }

    public Optional<MerkMobil> getMerkMobilById(Long id) {
        return merkMobilRepository.findById(id);
    }

    public MerkMobil createMerkMobil(MerkMobil merkMobil) {
        return merkMobilRepository.save(merkMobil);
    }

    public MerkMobil updateMerkMobil(Long id, MerkMobil updatedMerkMobil) {
        updatedMerkMobil.setId(id);
        return merkMobilRepository.save(updatedMerkMobil);
    }

    public void deleteMerkMobil(Long id) {
        merkMobilRepository.deleteById(id);
    }
}
