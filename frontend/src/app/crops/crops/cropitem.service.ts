import { Injectable } from '@angular/core';
import{ HttpClient } from '@angular/common/http';
import { Observable, of }from 'rxjs';
import { Cropitem } from './cropitem';
import { ResponseModel } from 'src/assets/model/ResponseModel';

@Injectable({
  providedIn: 'root'
})
export class CropitemService {

  private baseURL = "http://localhost:8083/api/v1/cropitems/";
  private AUTH_URL = "http://localhost:8081/validate-token";

 // private addCropUrl="http://localhost:8082/user/add-crop/"

  constructor(private httpClient:HttpClient) { }

  getUser(): Observable<ResponseModel> {
    let req = new ResponseModel();
    req.jwt = localStorage.getItem("jwt") || "";
    // if(req.jwt !== "")
    //   return this.httpClient.post<ResponseModel>(this.AUTH_URL, req);
    // mocking data
    req.id = "63285c9fcbbc536e9426d312";
    req.role = "ROLE_DEALER"
    return of(req);
  }
  // this method should get all crop items related to id
  getCropitemsList(): Observable<Cropitem[]>{
    // INSTEAD OF THIS URL CALL RUTUJA URL GET CROP ITEMS
    // YOU WILL GET A LIST OF CROP ITEM ID
    // CALL YOUR MS WITH LIST OF IDS AND GET THE CROP ITEMS
    // return this.httpClient.get<Cropitem[]>(`${this.baseURL}`);
    let cropItemList: Cropitem[] = [];
    let cropItem = new Cropitem();
    cropItem.cropid = 1
    cropItem.cropname = "mango"
    cropItem.cropprice = "12"
    cropItem.cropqnt = "123"
    cropItem.croptype = "Fruit"
    cropItemList.push(cropItem);
    return of(cropItemList);
  }

  // saveCropitem(cropitem: Cropitem): Observable<Cropitem>{

  //   return this.httpClient.put<Cropitem>(this.addCropUrl +"6324e2a86879610ec04cdc37", cropitem);
   
  // }

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
