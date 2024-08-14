package com.example.GestionRessourcesInfo.controller;


import com.example.GestionRessourcesInfo.model.TechnicienIT;
import com.example.GestionRessourcesInfo.service.TechnicienITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/techniciens")
public class TechnicienITController {

    @Autowired
    private TechnicienITService technicienITService;

    @PostMapping("/addTech")
    public ResponseEntity<TechnicienIT> creerTechnicienIT(@RequestBody TechnicienIT technicienIT) {
        TechnicienIT createdTechnicien = technicienITService.creerTechnicienIT(technicienIT);
        return ResponseEntity.ok(createdTechnicien);
    }

    @GetMapping
    public ResponseEntity<List<TechnicienIT>> getAllTechnicienITs() {
        List<TechnicienIT> techniciens = technicienITService.getAllTechnicienITs();
        return ResponseEntity.ok(techniciens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicienIT> getTechnicienITById(@PathVariable Long id) {
        TechnicienIT technicien = technicienITService.getTechnicienITById(id);
        return ResponseEntity.ok(technicien);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<TechnicienIT> updateTechnicienIT(@PathVariable Long id, @RequestBody TechnicienIT technicienIT) {
        technicienIT.setId(id);
        TechnicienIT updatedTechnicien = technicienITService.updateTechnicienIT(technicienIT);
        return ResponseEntity.ok(updatedTechnicien);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTechnicienIT(@PathVariable Long id) {
        technicienITService.deleteTechnicienIT(id);
        return ResponseEntity.noContent().build();
    }
}
