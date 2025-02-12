package com.example.ApiMerkMobil;

import com.example.ApiMerkMobil.entity.MerkMobil;
import com.example.ApiMerkMobil.repository.MerkMobilRepository;
import com.example.ApiMerkMobil.service.MerkMobilService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class MerkMobilServiceTest {

    @Mock
    private MerkMobilRepository merkMobilRepository;

    @InjectMocks
    private MerkMobilService merkMobilService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMerkMobil() {
        // Given
        List<MerkMobil> merkList = Arrays.asList(
                new MerkMobil(1L, "Toyota", 1937, "Jepang"),
                new MerkMobil(2L, "Honda", 1948, "Jepang")
        );
        when(merkMobilRepository.findAll()).thenReturn(merkList);

        // When
        List<MerkMobil> result = merkMobilService.getAllMerkMobil();

        // Then
        assertEquals(2, result.size());
        verify(merkMobilRepository, times(1)).findAll();
    }

    @Test
    void testGetMerkMobilByIdFound() {
        // Given
        MerkMobil toyota = new MerkMobil(1L, "Toyota", 1937, "Jepang");
        when(merkMobilRepository.findById(1L)).thenReturn(Optional.of(toyota));

        // When
        MerkMobil result = merkMobilService.getMerkMobilById(1L);

        // Then
        assertNotNull(result);
        assertEquals("Toyota", result.getNama());
        verify(merkMobilRepository, times(1)).findById(1L);
    }

    @Test
    void testGetMerkMobilByIdNotFound() {
        // Given
        when(merkMobilRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then: Expected exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            merkMobilService.getMerkMobilById(1L);
        });
        assertEquals("Merk mobil dengan id 1 tidak ditemukan.", exception.getMessage());
        verify(merkMobilRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateMerkMobilNoDuplicate() {
        // Given
        MerkMobil ford = new MerkMobil(null, "Ford", 1903, "Amerika Serikat");
        when(merkMobilRepository.findByNama("Ford")).thenReturn(Optional.empty());
        MerkMobil savedFord = new MerkMobil(3L, "Ford", 1903, "Amerika Serikat");
        when(merkMobilRepository.save(ford)).thenReturn(savedFord);

        // When
        MerkMobil result = merkMobilService.createMerkMobil(ford);

        // Then
        assertNotNull(result);
        assertEquals(3L, result.getId());
        verify(merkMobilRepository, times(1)).findByNama("Ford");
        verify(merkMobilRepository, times(1)).save(ford);
    }

    @Test
    void testCreateMerkMobilDuplicate() {
        // Given
        MerkMobil ford = new MerkMobil(null, "Ford", 1903, "Amerika Serikat");
        MerkMobil existingFord = new MerkMobil(3L, "Ford", 1903, "Amerika Serikat");
        when(merkMobilRepository.findByNama("Ford")).thenReturn(Optional.of(existingFord));

        // When & Then: Expected exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            merkMobilService.createMerkMobil(ford);
        });
        assertEquals("Merk mobil dengan nama 'Ford' sudah ada.", exception.getMessage());
        verify(merkMobilRepository, times(1)).findByNama("Ford");
        verify(merkMobilRepository, never()).save(any(MerkMobil.class));
    }

    @Test
    void testUpdateMerkMobilFound() {
        // Given
        MerkMobil existing = new MerkMobil(1L, "Toyota", 1937, "Jepang");
        MerkMobil updatedData = new MerkMobil(null, "Toyota Updated", 1937, "Jepang");
        when(merkMobilRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(merkMobilRepository.save(existing)).thenReturn(existing);

        // When
        MerkMobil result = merkMobilService.updateMerkMobil(1L, updatedData);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Toyota Updated", result.getNama());
        verify(merkMobilRepository, times(1)).findById(1L);
        verify(merkMobilRepository, times(1)).save(existing);
    }

    @Test
    void testUpdateMerkMobilNotFound() {
        // Given
        MerkMobil updatedData = new MerkMobil(null, "Toyota Updated", 1937, "Jepang");
        when(merkMobilRepository.findById(1L)).thenReturn(Optional.empty());

        // When & Then: Expected exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            merkMobilService.updateMerkMobil(1L, updatedData);
        });
        assertEquals("Merk mobil dengan id 1 tidak ditemukan.", exception.getMessage());
        verify(merkMobilRepository, times(1)).findById(1L);
        verify(merkMobilRepository, never()).save(any(MerkMobil.class));
    }

    @Test
    void testDeleteMerkMobilFound() {
        // Given
        when(merkMobilRepository.existsById(1L)).thenReturn(true);

        // When
        merkMobilService.deleteMerkMobil(1L);

        // Then
        verify(merkMobilRepository, times(1)).existsById(1L);
        verify(merkMobilRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteMerkMobilNotFound() {
        // Given
        when(merkMobilRepository.existsById(1L)).thenReturn(false);

        // When & Then: Expected exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            merkMobilService.deleteMerkMobil(1L);
        });
        assertEquals("Merk mobil dengan id 1 tidak ditemukan.", exception.getMessage());
        verify(merkMobilRepository, times(1)).existsById(1L);
        verify(merkMobilRepository, never()).deleteById(anyLong());
    }
}
