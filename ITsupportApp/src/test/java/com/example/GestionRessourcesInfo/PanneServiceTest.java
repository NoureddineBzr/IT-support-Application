//package com.example.GestionRessourcesInfo;
//
//import com.example.GestionRessourcesInfo.model.Panne;
//import com.example.GestionRessourcesInfo.repository.PanneRepository;
//import com.example.GestionRessourcesInfo.service.PanneService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class PanneServiceTest {
//
//    @InjectMocks
//    private PanneService panneService;
//
//    @Mock
//    private PanneRepository panneRepository;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreerPanne() {
//        // Arrange
//        Panne panne = new Panne();
//        panne.setId(1L);
//        panne.setDescription("Test Panne");
//
//        when(panneRepository.save(panne)).thenReturn(panne);
//
//        // Act
//        Panne createdPanne = panneService.creerPanne(panne);
//
//        // Assert
//        assertEquals(panne.getDescription(), createdPanne.getDescription());
//        assertEquals(panne.getId(), createdPanne.getId());
//        verify(panneRepository, times(1)).save(panne);
//    }
//
//    @Test
//    void testGetAllPannes() {
//        // Arrange
//        Panne panne1 = new Panne();
//        panne1.setDescription("Panne 1");
//
//        Panne panne2 = new Panne();
//        panne2.setDescription("Panne 2");
//
//        when(panneRepository.findAll()).thenReturn(Arrays.asList(panne1, panne2));
//
//        // Act
//        List<Panne> pannes = panneService.getAllPannes();
//
//        // Assert
//        assertEquals(2, pannes.size());
//        verify(panneRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testGetPanneById_Success() {
//        // Arrange
//        Panne panne = new Panne();
//        panne.setId(1L);
//        panne.setDescription("Panne");
//
//        when(panneRepository.findById(1L)).thenReturn(Optional.of(panne));
//
//        // Act
//        Panne result = panneService.getPanneById(1L);
//
//        // Assert
//        assertEquals(panne.getDescription(), result.getDescription());
//        verify(panneRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void testGetPanneById_NotFound() {
//        // Arrange
//        when(panneRepository.findById(1L)).thenReturn(Optional.empty());
//
//        // Act
//        Panne result = panneService.getPanneById(1L);
//
//        // Assert
//        assertNull(result);
//        verify(panneRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void testUpdatePanne() {
//        // Arrange
//        Panne panne = new Panne();
//        panne.setId(1L);
//        panne.setDescription("Old Description");
//
//        when(panneRepository.save(panne)).thenReturn(panne);
//
//        panne.setDescription("Updated Description");
//
//        // Act
//        Panne updatedPanne = panneService.updatePanne(panne);
//
//        // Assert
//        assertEquals("Updated Description", updatedPanne.getDescription());
//        verify(panneRepository, times(1)).save(panne);
//    }
//
//    @Test
//    void testDeletePanne() {
//        // Arrange
//        doNothing().when(panneRepository).deleteById(1L);
//
//        // Act
//        panneService.deletePanne(1L);
//
//        // Assert
//        verify(panneRepository, times(1)).deleteById(1L);
//    }
//}
