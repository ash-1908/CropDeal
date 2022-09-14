import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http';
import { Observable }from 'rxjs';
import { Cropitem } from './cropitem';

@Injectable({
  providedIn: 'root'
})
export class CropitemService {

  private baseURL = "http://localhost:8084/api/v1/cropitems/";

  constructor(private httpClient:HttpClient) { }

  getCropitemsList(): Observable<Cropitem[]>{
    return this.httpClient.get<Cropitem[]>(`${this.baseURL}`);
  }

  saveCropitem(cropitem: Cropitem): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, cropitem);
  }

  getCropitemById(cropid: number): Observable<Cropitem>{
    return this.httpClient.get<Cropitem>(`${this.baseURL}/${cropid}`);
  }

  updateCropitem(cropid: number, cropitem: Cropitem): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${cropid}`, cropitem);
  }

  deleteCropitem(cropid: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${cropid}`);
  }
}
