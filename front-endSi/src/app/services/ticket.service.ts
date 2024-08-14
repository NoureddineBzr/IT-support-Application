import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TicketDeSupport } from '../models/ticket-de-support';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private apiUrl = 'http://localhost:8080/api/tickets';

  constructor(private http: HttpClient) {}

  addTicket(ticket: TicketDeSupport): Observable<TicketDeSupport> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.post<TicketDeSupport>(`${this.apiUrl}/addTicket`, ticket, { headers });
  }

  getAllTickets(): Observable<TicketDeSupport[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<TicketDeSupport[]>(`${this.apiUrl}/afficher`, { headers });
  }

  getTicketById(id: number): Observable<TicketDeSupport> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<TicketDeSupport>(`${this.apiUrl}/${id}`, { headers });
  }

  updateTicket(id: number, ticket: TicketDeSupport): Observable<TicketDeSupport> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.put<TicketDeSupport>(`${this.apiUrl}/update/${id}`, ticket, { headers });
  }

  deleteTicket(id: number): Observable<void> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers });
  }
}
