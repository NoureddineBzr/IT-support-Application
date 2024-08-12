package com.itsupport.controller;

import com.itsupport.dto.UserUpdateDto;
import com.itsupport.exception.AdminNotFoundException;
import com.itsupport.service.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AdminController {

    private final AdminService adminService;


    @GetMapping("/get-all-admins")
    @ApiOperation(value = "Get all admins", notes = "Retrieves a list of all admins.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of admins retrieved successfully."),
            @ApiResponse(code = 404, message = "Admins not found.")
    })
    public ResponseEntity<?> getAllAdmins() {
        try {
            var admins = adminService.getAllAdmins();
            return ResponseEntity.ok(admins);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/admin/get-admin-by-id/{id}")
    @ApiOperation(value = "Get admin by ID", notes = "Retrieves a specific admin by their ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Admin retrieved successfully."),
            @ApiResponse(code = 404, message = "Admin not found.")
    })
    public ResponseEntity<?> getAdminById(
            @ApiParam(value = "ID of the admin", required = true) @PathVariable("id") String id) {
        try {
            var admin = adminService.getAdminById(Long.valueOf(id));
            return ResponseEntity.ok(admin);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/admin/update-admin/{id}")
    @ApiOperation(value = "Update admin", notes = "Updates the details of a specific admin.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Admin updated successfully."),
            @ApiResponse(code = 404, message = "Admin not found.")
    })
    public ResponseEntity<?> updateAdmin(
            @ApiParam(value = "ID of the admin", required = true) @PathVariable("id") String id,
            @ApiParam(value = "Admin update details", required = true) @RequestBody UserUpdateDto userUpdateDto) {
        try {
            var updatedAdmin = adminService.updateAdmin(Long.valueOf(id), userUpdateDto);
            return ResponseEntity.ok(updatedAdmin);
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping("/admin/delete-admin/{id}")
    @ApiOperation(value = "Delete admin", notes = "Deletes a specific admin by their ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Admin deleted successfully."),
            @ApiResponse(code = 404, message = "Admin not found.")
    })
    public ResponseEntity<?> deleteAdmin(
            @ApiParam(value = "ID of the admin", required = true) @PathVariable("id") String id) {
        try {
            adminService.deleteAdmin(Long.valueOf(id));
            return ResponseEntity.noContent().build();
        } catch (AdminNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
