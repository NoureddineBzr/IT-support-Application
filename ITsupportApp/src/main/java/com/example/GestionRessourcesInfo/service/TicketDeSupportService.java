package com.example.GestionRessourcesInfo.service;

import com.example.GestionRessourcesInfo.model.TicketDeSupport;
import com.example.GestionRessourcesInfo.repository.TicketDeSupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketDeSupportService {

    @Autowired
    private TicketDeSupportRepository ticketDeSupportRepository;

    public TicketDeSupport creerTicketDeSupport(TicketDeSupport ticketDeSupport) {
        return ticketDeSupportRepository.save(ticketDeSupport);
    }

    public List<TicketDeSupport> getAllTicketsDeSupport() {
        return ticketDeSupportRepository.findAll();
    }

    public TicketDeSupport getTicketDeSupportById(Long id) {
        return ticketDeSupportRepository.findById(id).orElse(null);
    }

    public TicketDeSupport updateTicketDeSupport(TicketDeSupport ticketDeSupport) {
        return ticketDeSupportRepository.save(ticketDeSupport);
    }

    public void deleteTicketDeSupport(Long id) {
        ticketDeSupportRepository.deleteById(id);
    }
}