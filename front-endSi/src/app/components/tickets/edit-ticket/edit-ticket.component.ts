import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {EtatTicket} from "../../../models/enums/etat-ticket";
import {TicketService} from "../../../services/ticket.service";
import {TicketDeSupport} from "../../../models/ticket-de-support";

@Component({
  selector: 'app-edit-ticket',
  templateUrl: './edit-ticket.component.html',
  styleUrls: ['./edit-ticket.component.css']
})
export class EditTicketComponent implements OnInit {
  ticketForm!: FormGroup;
  etatOptions = Object.values(EtatTicket);

  constructor(
    private fb: FormBuilder,
    private ticketService: TicketService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.ticketService.getTicketById(Number(id)).subscribe(
        ticket => {
          this.ticketForm = this.fb.group({
            description: [ticket.description, Validators.required],
            etat: [ticket.etat, Validators.required],
            dateCreation: [ticket.dateCreation, Validators.required],
            dateResolution: [ticket.dateResolution],
            utilisateur: this.fb.group({
              id: [ticket.utilisateur.id, Validators.required]
            }),
            technicienIT: this.fb.group({
              id: [ticket.technicienIT.id]
            }),
            panne: this.fb.group({
              id: [ticket.panne.id]
            })
          });
        },
        error => {
          console.error('Erreur lors de la récupération du ticket:', error);
        }
      );
    }
  }

  onSubmit(): void {
    if (this.ticketForm.valid) {
      const id = this.route.snapshot.paramMap.get('id');
      if (id) {
        const ticket: TicketDeSupport = this.ticketForm.value;
        this.ticketService.updateTicket(Number(id), ticket).subscribe(
          response => {
            console.log('Ticket modifié avec succès');
            this.router.navigate(['/tickets-list']);
          },
          error => {
            console.error('Erreur lors de la modification du ticket:', error);
          }
        );
      }
    }
  }
}
