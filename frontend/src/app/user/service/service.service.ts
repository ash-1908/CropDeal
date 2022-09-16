import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { MainService } from 'src/app/main.service';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root',
})
export class ServiceService {
  private getUserApi: string;

  private getUserbyUserNameApi: string;

  private updateApi: string;

  public user: User = new User();

  private AUTH_MS = 'http://localhost:8081/validate-token'

  constructor(private http: HttpClient) {
    
    (this.getUserApi = 'http://localhost:8090/users/user/get-user-by-email'),
      (this.getUserbyUserNameApi =
        'http://localhost:8082/user/get-user-username'),
      (this.updateApi = 'http://localhost:8090/users/user/update-user/');
  }

  getUser(): Observable<ResponseModel> {
    let req = new ResponseModel();
    let jwt: string = localStorage.getItem("jwt") || '';
    
    req.jwt = jwt;
      // return this.http.post<ResponseModel>(this.AUTH_MS, req);
    req.name = "Anmol";
    return of(req);
    
 
  }

  public getUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(this.getUserApi + '/' + email);
  }

  public getUserByUserName(username: String): Observable<User> {
    return this.http.get<User>(this.getUserbyUserNameApi + '/' + username);
  }

  public updateUser(id: number, user: User): Observable<User> {
    return this.http.put<User>(this.updateApi + id, user);
  }
}
