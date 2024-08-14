import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Equipement } from '../models/equipement';
import { isPlatformBrowser } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class EquipementService {
  private apiUrl = 'http://localhost:8080/api/equipements';
  private platformId: Object;

  constructor(private http: HttpClient, @Inject(PLATFORM_ID) platformId: Object) {
    this.platformId = platformId;
  }

  private getAuthHeaders(): HttpHeaders {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('token');
      if (token) {
        headers = headers.set('Authorization', `Bearer ${token}`);
      }
    }
    return headers;
  }

  addEquipement(equipement: Equipement): Observable<Equipement> {
    const headers = this.getAuthHeaders();
    return this.http.post<Equipement>(`${this.apiUrl}/addEqui`, equipement, { headers });
  }

  getAllEquipements(): Observable<Equipement[]> {
    const headers = this.getAuthHeaders();
    return this.http.get<Equipement[]>(this.apiUrl, { headers });
  }

  deleteEquipement(id: number | undefined): Observable<void> {
    const headers = this.getAuthHeaders();
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`, { headers });
  }

  updateEquipement(equipement: Equipement): Observable<Equipement> {
    const headers = this.getAuthHeaders();
    return this.http.put<Equipement>(`${this.apiUrl}/edit/${equipement.id}`, equipement, { headers });
  }
}
