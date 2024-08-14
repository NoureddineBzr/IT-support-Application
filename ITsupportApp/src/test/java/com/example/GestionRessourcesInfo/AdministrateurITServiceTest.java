//package com.example.GestionRessourcesInfo;
//
//import com.example.GestionRessourcesInfo.model.AdministrateurIT;
//import com.example.GestionRessourcesInfo.model.enums.Role;
//import com.example.GestionRessourcesInfo.repository.AdministrateurITRepository;
//import com.example.GestionRessourcesInfo.service.AdministrateurITService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.Optional;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class AdministrateurITServiceTest {
//
//    @Autowired
//    private AdministrateurITService administrateurITService;
//
//    @Autowired
//    private AdministrateurITRepository administrateurITRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @BeforeEach
//    public void setup() {
//        administrateurITRepository.deleteAll(); // Vide le dépôt avant chaque test
//    }
//
//    @Test
//    public void testCreateAdminUserIfNotExist() {
//        // Acte
//        administrateurITService.createAdminUserIfNotExist();
//
//        // Vérification
//        Optional<AdministrateurIT> admin = administrateurITRepository.findByEmail("admin@example.com");
//        Assertions.assertTrue(admin.isPresent(), "L'admin devrait être présent");
//        Assertions.assertEquals("zineb", admin.get().getUsername(), "Le nom d'utilisateur devrait être 'zineb'");
//        Assertions.assertEquals(Role.ADMIN, admin.get().getRole(), "Le rôle devrait être ADMIN");
//        Assertions.assertTrue(passwordEncoder.matches("zineb", admin.get().getPassword()), "Le mot de passe devrait correspondre à 'zineb'");
//    }
//
//    @Test
//    public void testAdminUserAlreadyExists() {
//        // Arrange
//        AdministrateurIT existingAdmin = new AdministrateurIT();
//        existingAdmin.setUsername("existingAdmin");
//        existingAdmin.setEmail("admin@example.com");
//        existingAdmin.setRole(Role.ADMIN);
//        existingAdmin.setPassword(passwordEncoder.encode("existingPassword"));
//        administrateurITRepository.save(existingAdmin);
//
//        // Acte
//        administrateurITService.createAdminUserIfNotExist();
//
//        // Vérification
//        Optional<AdministrateurIT> admin = administrateurITRepository.findByEmail("admin@example.com");
//        Assertions.assertTrue(admin.isPresent(), "L'admin devrait être présent");
//        Assertions.assertEquals("existingAdmin", admin.get().getUsername(), "Le nom d'utilisateur devrait rester 'existingAdmin'");
//        Assertions.assertTrue(passwordEncoder.matches("existingPassword", admin.get().getPassword()), "Le mot de passe devrait rester 'existingPassword'");
//    }
//}
