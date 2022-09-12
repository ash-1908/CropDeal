import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private getUserApi:string;

  constructor(private http:HttpClient) { 

       this.getUserApi="http://localhost:8080/user/get-user"
  }

  public getUserById(id:number):Observable<User>{
    return  this.http.get<User>(this.getUserApi+"/"+id);
   }
}
