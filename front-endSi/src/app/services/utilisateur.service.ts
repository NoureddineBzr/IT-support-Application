import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UtilisateurDTO } from '../models/utilisateur-dto';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  private apiUrl = 'http://localhost:8080/api/utilisateurs';

  constructor(private http: HttpClient) {}


  addUtilisateur(utilisateur: UtilisateurDTO): Observable<UtilisateurDTO> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.post<UtilisateurDTO>(`${this.apiUrl}/addUser`, utilisateur, { headers });
  }


  getAllUtilisateurs(): Observable<UtilisateurDTO[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
    return this.http.get<UtilisateurDTO[]>(this.apiUrl, { headers });
  }





}
