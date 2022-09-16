import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ResponseModel } from 'src/assets/model/ResponseModel';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private rootUrl = "http://localhost:8081/";

  constructor(private http: HttpClient, private router: Router) { }

  public signIn(email: string, password: string): boolean {
    let sub = "signin";
    // this.http.post(this.rootUrl+sub, {email, password}).subscribe(res);
    let res = new ResponseModel();
    res.name = "anmol"
    let jwt = "somejwttoken";
    localStorage.setItem("jwt", jwt);
    this.router.navigate(["../../user/profile/" + res.name])
    return true;
  }

  protected signOut(): void {
    localStorage.removeItem("jwt");
  }

  protected signUp(email: string, password: string, fullName: string): void {
    let res = new ResponseModel();
    res.id = '123'
    res.name = "anmol"
    let jwt = res.jwt;
    localStorage.setItem("jwt", jwt);
  }
  protected forgotPassword(email: string, method: string): boolean {
    return false;
  }
  protected validateOtp(otp: string): boolean {
    return false;
  }
  
  protected validateJwt(token: string): boolean {
    return true;
  }
  
  protected resetPassword(password: string): boolean {
    return false;
  }
}
