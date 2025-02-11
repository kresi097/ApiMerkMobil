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

    public MerkMobil getMerkMobilById(Long id) {
        return merkMobilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merk mobil dengan id " + id + " tidak ditemukan."));
    }


    public MerkMobil createMerkMobil(MerkMobil merkMobil) {
        return merkMobilRepository.save(merkMobil);
    }

    public MerkMobil updateMerkMobil(Long id, MerkMobil updatedMerkMobil) {
        Optional<MerkMobil> existingOptional = merkMobilRepository.findById(id);
        if (!existingOptional.isPresent()) {
            // Melempar exception jika data tidak ditemukan
            throw new RuntimeException("Merk mobil dengan id " + id + " tidak ditemukan.");
        }

        MerkMobil existing = existingOptional.get();
        // Perbarui field yang diperlukan
        existing.setNama(updatedMerkMobil.getNama());
        existing.setTahunBerdiri(updatedMerkMobil.getTahunBerdiri());
        existing.setNegaraAsal(updatedMerkMobil.getNegaraAsal());

        return merkMobilRepository.save(existing);
    }

    public void deleteMerkMobil(Long id) {
        merkMobilRepository.deleteById(id);
    }
}
