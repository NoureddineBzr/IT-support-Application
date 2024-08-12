package com.itsupport.auth.controller;

import com.itsupport.auth.exception.*;
import com.itsupport.auth.model.*;
import com.itsupport.auth.service.AuthService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
@Api(value = "Authentication Management", tags = {"Authentication Management"})
public class AuthController {

    private final AuthService userService;


    @ApiOperation(value = "Register an admin", notes = "Registers a new admin user.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully registered the admin"),
            @ApiResponse(code = 409, message = "Conflict - registration error")
    })
    @PostMapping("/register/admin")
    public ResponseEntity<?> adminRegister(
            @ApiParam(value = "Registration request containing user details", required = true) @RequestBody RegisterRequest registerRequest) {
        try {
            var authResponse = userService.adminRegister(registerRequest);
            return ResponseEntity.ok(authResponse);
        } catch (RegistrationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


    @ApiOperation(value = "Register a technician", notes = "Registers a new technician user.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully registered the technician"),
            @ApiResponse(code = 409, message = "Conflict - registration error")
    })
    @PostMapping("/register/technician")
    public ResponseEntity<?> technicianRegister(
            @ApiParam(value = "Registration request containing user details", required = true) @RequestBody RegisterRequest registerRequest) {
        try {
            var authResponse = userService.technicianRegister(registerRequest);
            return ResponseEntity.ok(authResponse);
        } catch (RegistrationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


    @ApiOperation(value = "Register a client", notes = "Registers a new client user.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully registered the client"),
            @ApiResponse(code = 409, message = "Conflict - registration error")
    })
    @PostMapping("/register/client")
    public ResponseEntity<?> clientRegister(
            @ApiParam(value = "Registration request containing user details", required = true) @RequestBody RegisterRequest registerRequest) {
        try {
            var authResponse = userService.clientRegister(registerRequest);
            return ResponseEntity.ok(authResponse);
        } catch (RegistrationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
