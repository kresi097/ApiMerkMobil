package com.example.ApiMerkMobil.controller;

import com.example.ApiMerkMobil.entity.MerkMobil;
import com.example.ApiMerkMobil.service.MerkMobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/merk-mobil")
public class MerkMobilController {

    @Autowired
    private MerkMobilService merkMobilService;

    @GetMapping
    public List<MerkMobil> getAllMerkMobil() {
        return merkMobilService.getAllMerkMobil();
    }

    @GetMapping("/{id}")
    public Optional<MerkMobil> getMerkMobilById(@PathVariable Long id) {
        return merkMobilService.getMerkMobilById(id);
    }

    @PostMapping
    public MerkMobil createMerkMobil(@RequestBody MerkMobil merkMobil) {
        return merkMobilService.createMerkMobil(merkMobil);
    }

    @PutMapping("/{id}")
    public MerkMobil updateMerkMobil(@PathVariable Long id, @RequestBody MerkMobil updatedMerkMobil) {
        return merkMobilService.updateMerkMobil(id, updatedMerkMobil);
    }

    @DeleteMapping("/{id}")
    public void deleteMerkMobil(@PathVariable Long id) {
        merkMobilService.deleteMerkMobil(id);
    }
}
