package com.itsupport.controller;

import com.itsupport.dto.UserUpdateDto;
import com.itsupport.exception.ClientNotFoundException;
import com.itsupport.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/get-all-clients")
    @ApiOperation(value = "Get all clients", notes = "Retrieves a list of all clients.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of clients retrieved successfully."),
            @ApiResponse(code = 404, message = "Clients not found.")
    })
    public ResponseEntity<?> getAllClients() {
        try {
            var clients = clientService.getAllClients();
            return ResponseEntity.ok(clients);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/get-client-by-id/{id}")
    @ApiOperation(value = "Get client by ID", notes = "Retrieves a specific client by their ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client retrieved successfully."),
            @ApiResponse(code = 404, message = "Client not found.")
    })
    public ResponseEntity<?> getClientById(
            @ApiParam(value = "ID of the client", required = true) @PathVariable("id") String id) {
        try {
            var client = clientService.getClientById(Long.valueOf(id));
            return ResponseEntity.ok(client);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/update-client/{id}")
    @ApiOperation(value = "Update client", notes = "Updates the details of a specific client.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client updated successfully."),
            @ApiResponse(code = 404, message = "Client not found.")
    })
    public ResponseEntity<?> updateClient(
            @ApiParam(value = "ID of the client", required = true) @PathVariable("id") String id,
            @ApiParam(value = "Client update details", required = true) @RequestBody UserUpdateDto userUpdateDto) {
        try {
            var updatedClient = clientService.updateClient(Long.valueOf(id), userUpdateDto);
            return ResponseEntity.ok(updatedClient);
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping("/delete-client/{id}")
    @ApiOperation(value = "Delete client", notes = "Deletes a specific client by their ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Client deleted successfully."),
            @ApiResponse(code = 404, message = "Client not found.")
    })
    public ResponseEntity<?> deleteClient(
            @ApiParam(value = "ID of the client", required = true) @PathVariable("id") String id) {
        try {
            clientService.deleteClient(Long.valueOf(id));
            return ResponseEntity.noContent().build();
        } catch (ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
