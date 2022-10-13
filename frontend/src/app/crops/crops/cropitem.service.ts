import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Cropitem } from './cropitem';
import { ResponseModel } from 'src/assets/model/ResponseModel';

@Injectable({
  providedIn: 'root',
})
export class CropitemService {
  private baseURL = 'http://localhost:8083/api/v1/cropitems/';
  private AUTH_URL = 'http://localhost:8081/validate-token';
  private addCropUrl = 'http://localhost:8082/user/add-crop/';

  constructor(private httpClient: HttpClient) {}

  // this method should get all crop items related to id
  getAllCropitemsList(): Observable<Cropitem[]> {
    return this.httpClient.get<Cropitem[]>(`${this.baseURL}`);
  }
  getCropitemsList(idList: string[]): Observable<Cropitem[]> {
    return this.httpClient.post<Cropitem[]>(`${this.baseURL} + list`, idList);
  }

  //  saveCropitem(cropitem: Cropitem): Observable<Cropitem>{

  //    return this.httpClient.post<Cropitem>(this.addCropUrl +"6324e2a86879610ec04cdc37", cropitem);

  // }

  saveCropitem(cropitem: Cropitem): Observable<Cropitem> {
    return this.httpClient.post<Cropitem>(`${this.baseURL}`, cropitem);
  }

  getCropitemById(id: string): Observable<Cropitem> {
    return this.httpClient.get<Cropitem>(`${this.baseURL}${id}`);
  }

  updateCropitem(id: string, cropitem: Cropitem): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}${id}`, cropitem);
  }

  deleteCropitem(id: string): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}${id}`);
  }
}
