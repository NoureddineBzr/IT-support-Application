//package com.example.GestionRessourcesInfo;
//
//
//import com.example.GestionRessourcesInfo.model.Equipement;
//import com.example.GestionRessourcesInfo.repository.EquipementRepository;
//import com.example.GestionRessourcesInfo.service.EquipementService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.*;
//
//public class EquipementServiceTest {
//
//    @InjectMocks
//    private EquipementService equipementService;
//
//    @Mock
//    private EquipementRepository equipementRepository;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreerEquipement() {
//        // Arrange
//        Equipement equipement = new Equipement();
//        equipement.setId(1L);
//        when(equipementRepository.save(equipement)).thenReturn(equipement);
//
//        // Act
//        Equipement createdEquipement = equipementService.creerEquipement(equipement);
//
//        // Assert
//        assertEquals(equipement, createdEquipement);
//        verify(equipementRepository, times(1)).save(equipement);
//    }
//
//    @Test
//    void testGetAllEquipements() {
//        // Arrange
//        Equipement equipement1 = new Equipement();
//        Equipement equipement2 = new Equipement();
//        List<Equipement> equipements = Arrays.asList(equipement1, equipement2);
//        when(equipementRepository.findAll()).thenReturn(equipements);
//
//        // Act
//        List<Equipement> result = equipementService.getAllEquipements();
//
//        // Assert
//        assertEquals(equipements, result);
//        verify(equipementRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testGetEquipementById_Success() {
//        // Arrange
//        Long id = 1L;
//        Equipement equipement = new Equipement();
//        equipement.setId(id);
//        when(equipementRepository.findById(id)).thenReturn(Optional.of(equipement));
//
//        // Act
//        Equipement result = equipementService.getEquipementById(id);
//
//        // Assert
//        assertEquals(equipement, result);
//        verify(equipementRepository, times(1)).findById(id);
//    }
//
//    @Test
//    void testGetEquipementById_NotFound() {
//        // Arrange
//        Long id = 1L;
//        when(equipementRepository.findById(id)).thenReturn(Optional.empty());
//
//        // Act
//        Equipement result = equipementService.getEquipementById(id);
//
//        // Assert
//        assertNull(result);
//        verify(equipementRepository, times(1)).findById(id);
//    }
//
//    @Test
//    void testUpdateEquipement() {
//        // Arrange
//        Equipement equipement = new Equipement();
//        equipement.setId(1L);
//        when(equipementRepository.save(equipement)).thenReturn(equipement);
//
//        // Act
//        Equipement updatedEquipement = equipementService.updateEquipement(equipement);
//
//        // Assert
//        assertEquals(equipement, updatedEquipement);
//        verify(equipementRepository, times(1)).save(equipement);
//    }
//
//    @Test
//    void testDeleteEquipement() {
//        // Arrange
//        Long id = 1L;
//
//        // Act
//        equipementService.deleteEquipement(id);
//
//        // Assert
//        verify(equipementRepository, times(1)).deleteById(id);
//    }
//}
//
