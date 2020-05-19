import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class HttpService {
phoneNumber: string;


  constructor(private http: HttpClient) { }

   getPhoneNumber(phoneNumber) {
  
    return this.http.get('http://localhost:8080/finraDemo/phone/'+phoneNumber);
  }
}