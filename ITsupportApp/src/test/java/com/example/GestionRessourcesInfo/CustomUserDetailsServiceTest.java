//package com.example.GestionRessourcesInfo;
//
//
//import com.example.GestionRessourcesInfo.model.Personne;
//import com.example.GestionRessourcesInfo.repository.PersonneRepository;
//import com.example.GestionRessourcesInfo.service.CustomUserDetailsService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//public class CustomUserDetailsServiceTest {
//
//    @InjectMocks
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Mock
//    private PersonneRepository personneRepository;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testLoadUserByUsername_Success() {
//        // Arrange
//        String username = "testuser";
//        Personne personne = new Personne();
//        personne.setUsername(username);
//        personne.setPassword("password");
//        personne.setAuthorities(/* set authorities */);
//
//        when(personneRepository.findByUsername(username)).thenReturn(personne);
//
//        // Act
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
//
//        // Assert
//        assertEquals(username, userDetails.getUsername());
//        assertEquals("password", userDetails.getPassword());
//        // Add assertions for authorities if needed
//    }
//
//    @Test
//    void testLoadUserByUsername_UserNotFound() {
//        // Arrange
//        String username = "nonexistentuser";
//
//        when(personneRepository.findByUsername(username)).thenReturn(null);
//
//        // Act & Assert
//        assertThrows(UsernameNotFoundException.class, () -> {
//            customUserDetailsService.loadUserByUsername(username);
//        });
//    }
//}
//
