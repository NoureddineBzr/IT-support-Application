package com.itsupport.controller;

import com.itsupport.dto.TicketDto;
import com.itsupport.exception.*;
import com.itsupport.service.EquipmentBreakdownService;
import com.itsupport.service.TicketService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TicketController {

    private final EquipmentBreakdownService equipmentBreakdownService;

    private final TicketService ticketService;


    @PostMapping("/client/report-breakdown-ticket/{equipmentId}&{breakdownId}")
    @ApiOperation(value = "Report breakdown with ticket", notes = "Reports a breakdown for equipment and creates a ticket.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Breakdown reported and ticket created successfully."),
            @ApiResponse(code = 404, message = "Equipment or breakdown or client not found.")
    })
    public ResponseEntity<?> reportBreakdownWithTicket(
            @ApiParam(value = "ID of the equipment", required = true) @PathVariable("equipmentId") String equipmentId,
            @ApiParam(value = "ID of the breakdown", required = true) @PathVariable("breakdownId") String breakdownId,
            @ApiParam(value = "Ticket details", required = true) @RequestBody TicketDto ticketDto) {
        try {
            var report = equipmentBreakdownService.reportBreakdown(Long.valueOf(equipmentId), Long.valueOf(breakdownId));
            var ticket = ticketService.createTicket(report, ticketDto);
            return ResponseEntity.ok(ticket);
        } catch (EquipmentNotFoundException | BreakdownNotFoundException | ClientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/client/get-all-tickets/{id}")
    @ApiOperation(value = "Get all tickets by client ID", notes = "Retrieves all tickets associated with a specific client.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of tickets retrieved successfully."),
            @ApiResponse(code = 404, message = "Tickets not found.")
    })
    public ResponseEntity<?> getAllTicketsByClient(
            @ApiParam(value = "ID of the client", required = true) @PathVariable("id") String id) {
        try {
            var tickets = ticketService.getTicketsByClient(Long.valueOf(id));
            return ResponseEntity.ok(tickets);
        } catch (TicketNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/admin/assign-ticket/{ticketId}/to/{technicianId}")
    @ApiOperation(value = "Assign ticket to technician", notes = "Assigns a specific ticket to a technician.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ticket assigned to technician successfully."),
            @ApiResponse(code = 404, message = "Ticket or technician not found.")
    })
    public ResponseEntity<?> assignTicketToTechnician(
            @ApiParam(value = "ID of the ticket", required = true) @PathVariable("ticketId") String ticketId,
            @ApiParam(value = "ID of the technician", required = true) @PathVariable("technicianId") String technicianId) {
        try {
            var ticket = ticketService.assignTicketToTechnician(Long.valueOf(ticketId), Long.valueOf(technicianId));
            return ResponseEntity.ok(ticket);
        } catch (TicketNotFoundException | TechnicianNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/admin/get-all-tickets")
    @ApiOperation(value = "Get all tickets", notes = "Retrieves a list of all tickets.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of tickets retrieved successfully."),
            @ApiResponse(code = 404, message = "Tickets not found.")
    })
    public ResponseEntity<?> getAllTickets() {
        try {
            var tickets = ticketService.getAllTickets();
            return ResponseEntity.ok(tickets);
        } catch (TicketNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/admin/get-pending-tickets")
    @ApiOperation(value = "Get pending tickets", notes = "Retrieves a list of all pending tickets.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of pending tickets retrieved successfully."),
            @ApiResponse(code = 404, message = "Tickets not found.")
    })
    public ResponseEntity<?> getPendingTickets() {
        try {
            var tickets = ticketService.getPendingTickets();
            return ResponseEntity.ok(tickets);
        } catch (TicketNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/technician/get-processing-tickets/{id}")
    @ApiOperation(value = "Get processing tickets by technician ID", notes = "Retrieves all tickets currently being processed by a specific technician.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of processing tickets retrieved successfully."),
            @ApiResponse(code = 404, message = "Tickets not found.")
    })
    public ResponseEntity<?> getProcessingTickets(
            @ApiParam(value = "ID of the technician", required = true) @PathVariable("id") String id) {
        try {
            var tickets = ticketService.getProcessingTickets(Long.valueOf(id));
            return ResponseEntity.ok(tickets);
        } catch (TicketNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/technician/get-all-tickets/{id}")
    @ApiOperation(value = "Get all tickets by technician ID", notes = "Retrieves all tickets assigned to a specific technician.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all tickets retrieved successfully."),
            @ApiResponse(code = 404, message = "Tickets not found.")
    })
    public ResponseEntity<?> getAllTicketsByTechnician(
            @ApiParam(value = "ID of the technician", required = true) @PathVariable("id") String id) {
        try {
            var tickets = ticketService.getTicketsByTechnician(Long.valueOf(id));
            return ResponseEntity.ok(tickets);
        } catch (TicketNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/technician/repairing-ticket/{id}")
    @ApiOperation(value = "Update ticket status to 'repairing'", notes = "Updates the status of a specific ticket to 'repairing'.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ticket status updated to 'repairing' successfully."),
            @ApiResponse(code = 404, message = "Ticket not found.")
    })
    public ResponseEntity<?> repairingTicket(
            @ApiParam(value = "ID of the ticket", required = true) @PathVariable("id") String id) {
        try {
            var ticket = ticketService.repairingTicket(Long.valueOf(id));
            return ResponseEntity.ok(ticket);
        } catch (TicketNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/technician/repaired-ticket/{id}")
    @ApiOperation(value = "Update ticket status to 'repaired'", notes = "Updates the status of a specific ticket to 'repaired'.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ticket status updated to 'repaired' successfully."),
            @ApiResponse(code = 404, message = "Ticket, equipment, or technician not found.")
    })
    public ResponseEntity<?> repairedTicket(
            @ApiParam(value = "ID of the ticket", required = true) @PathVariable("id") String id) {
        try {
            var ticket = ticketService.repairedTicket(Long.valueOf(id));
            return ResponseEntity.ok(ticket);
        } catch (TicketNotFoundException | EquipmentNotFoundException | TechnicianNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/technician/failed-ticket/{id}")
    @ApiOperation(value = "Update ticket status to 'failed'", notes = "Updates the status of a specific ticket to 'failed'.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ticket status updated to 'failed' successfully."),
            @ApiResponse(code = 404, message = "Ticket, equipment, or technician not found.")
    })
    public ResponseEntity<?> failedTicket(
            @ApiParam(value = "ID of the ticket", required = true) @PathVariable("id") String id) {
        try {
            var ticket = ticketService.failedTicket(Long.valueOf(id));
            return ResponseEntity.ok(ticket);
        } catch (TicketNotFoundException | EquipmentNotFoundException | TechnicianNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
