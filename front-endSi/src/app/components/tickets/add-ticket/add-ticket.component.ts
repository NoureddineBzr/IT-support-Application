import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {EtatTicket} from "../../../models/enums/etat-ticket";
import {TicketService} from "../../../services/ticket.service";
import {TicketDeSupport} from "../../../models/ticket-de-support";

@Component({
  selector: 'app-add-ticket',
  templateUrl: './add-ticket.component.html',
  styleUrls: ['./add-ticket.component.css']
})
export class AddTicketComponent implements OnInit {
  ticketForm!: FormGroup;
  etatOptions = Object.values(EtatTicket);

  constructor(
    private fb: FormBuilder,
    private ticketService: TicketService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.ticketForm = this.fb.group({
      description: ['', Validators.required],
      etat: ['', Validators.required],
      dateCreation: [new Date(), Validators.required],
      dateResolution: [''],
      utilisateur: this.fb.group({
        id: ['', Validators.required]
      }),
      technicienIT: this.fb.group({
        id: ['']
      }),
      panne: this.fb.group({
        id: ['']
      })
    });
  }

  onSubmit(): void {
    if (this.ticketForm.valid) {
      const ticket: TicketDeSupport = this.ticketForm.value;
      this.ticketService.addTicket(ticket).subscribe(
        () => {
          console.log('Ticket ajouté avec succès');
          this.router.navigate(['/tickets-list']);
        },
          (error: any) => {
          console.error('Erreur lors de l\'ajout du ticket:', error);
        }
      );
    }
  }
}
