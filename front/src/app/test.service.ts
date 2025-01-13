import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestService {
  private Url= "http://localhost:8083/test"

  constructor(private httpClient:HttpClient) { }
  uploadFile(file: File): Observable<number> {
        const formData = new FormData();
        formData.append('file', file);
        return this.httpClient.post<number>(`${this.Url}/upload`, formData);
      }
}
