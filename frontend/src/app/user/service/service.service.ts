import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private getUserApi:string;
  
  private getUserbyUserNameApi:string;

  private updateApi:string;



  constructor(private http:HttpClient) { 

       this.getUserApi="http://localhost:8090/users/user/get-user-by-email",
       this.getUserbyUserNameApi="http://localhost:8082/user/get-user-username",
       this.updateApi="http://localhost:8090/users/user/update-user/"
  }

  public getUserByEmail(email:string):Observable<User>{
    return  this.http.get<User>(this.getUserApi+"/"+email);
   }

   public getUserByUserName(username:String):Observable<User>{
    return  this.http.get<User>(this.getUserbyUserNameApi+"/"+username);
   }

   public updateUser(id:number,user:User):Observable<User>{
    return this.http.put<User>(this.updateApi+id,user);

   }


}
