package com.itsupport.controller;

import com.itsupport.dto.UserUpdateDto;
import com.itsupport.exception.TechnicianNotFoundException;
import com.itsupport.service.TechnicianService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/technician")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TechnicianController {

    private final TechnicianService technicianService;


    @GetMapping("/get-all-technicians")
    @ApiOperation(value = "Get all technicians", notes = "Retrieves a list of all technicians.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of technicians retrieved successfully."),
            @ApiResponse(code = 404, message = "Technicians not found.")
    })
    public ResponseEntity<?> getAllTechnicians() {
        try {
            var technicians = technicianService.getAllTechnicians();
            return ResponseEntity.ok(technicians);
        } catch (TechnicianNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/get-available-technicians")
    @ApiOperation(value = "Get available technicians", notes = "Retrieves a list of available technicians.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of available technicians retrieved successfully."),
            @ApiResponse(code = 404, message = "Technicians not found.")
    })
    public ResponseEntity<?> getAvailableTechnicians() {
        try {
            var technicians = technicianService.getAvailableTechnicians();
            return ResponseEntity.ok(technicians);
        } catch (TechnicianNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/get-technician-by-id/{id}")
    @ApiOperation(value = "Get technician by ID", notes = "Retrieves a specific technician by their ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Technician retrieved successfully."),
            @ApiResponse(code = 404, message = "Technician not found.")
    })
    public ResponseEntity<?> getTechnicianById(
            @ApiParam(value = "ID of the technician", required = true) @PathVariable("id") String id) {
        try {
            var technician = technicianService.getTechnicianById(Long.valueOf(id));
            return ResponseEntity.ok(technician);
        } catch (TechnicianNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/update-technician/{id}")
    @ApiOperation(value = "Update technician", notes = "Updates the details of a specific technician.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Technician updated successfully."),
            @ApiResponse(code = 404, message = "Technician not found.")
    })
    public ResponseEntity<?> updateTechnician(
            @ApiParam(value = "ID of the technician", required = true) @PathVariable("id") String id,
            @ApiParam(value = "Technician update details", required = true) @RequestBody UserUpdateDto userUpdateDto) {
        try {
            var updatedTechnician = technicianService.updateTechnician(Long.valueOf(id), userUpdateDto);
            return ResponseEntity.ok(updatedTechnician);
        } catch (TechnicianNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping("/delete-technician/{id}")
    @ApiOperation(value = "Delete technician", notes = "Deletes a specific technician by their ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Technician deleted successfully."),
            @ApiResponse(code = 404, message = "Technician not found.")
    })
    public ResponseEntity<?> deleteTechnician(
            @ApiParam(value = "ID of the technician", required = true) @PathVariable("id") String id) {
        try {
            technicianService.deleteTechnician(Long.valueOf(id));
            return ResponseEntity.noContent().build();
        } catch (TechnicianNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
