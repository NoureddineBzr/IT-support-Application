import { Component, OnInit } from '@angular/core';
import {TicketDeSupport} from "../../../models/ticket-de-support";
import {TicketService} from "../../../services/ticket.service";

@Component({
  selector: 'app-list-ticket',
  templateUrl: './list-ticket.component.html',
  styleUrls: ['./list-ticket.component.css']
})
export class ListTicketComponent implements OnInit {
  tickets: TicketDeSupport[] = [];

  constructor(private ticketService: TicketService) {}

  ngOnInit(): void {
    this.ticketService.getAllTickets().subscribe(
      (data: TicketDeSupport[]) => {
        this.tickets = data;
      },
      (error: any) => {
        console.error('Erreur lors de la récupération des tickets:', error);
      }
    );
  }

  deleteTicket(id: number): void {
    this.ticketService.deleteTicket(id).subscribe(
      () => {
        this.tickets = this.tickets.filter(ticket => ticket.id !== id);
      },
      (error: any) => {
        console.error('Erreur lors de la suppression du ticket:', error);
      }
    );
  }
}
