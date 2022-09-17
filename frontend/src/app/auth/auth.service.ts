import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ResponseModel } from 'src/assets/model/ResponseModel';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  // url of authentication server
  private rootUrl = 'http://localhost:8081/';
  constructor(private http: HttpClient, private router: Router) {}

  // sends credentials and receives jwt
  public signIn(email: string, password: string): Observable<ResponseModel> {
    let endpoint = 'signin';
    return this.http.post<ResponseModel>(this.rootUrl + endpoint, {
      email,
      password,
    });
  }
  // post user data and receive jwt
  public signUp(
    email: string,
    password: string,
    fullName: string
  ): Observable<ResponseModel> {
    let endpoint = 'signup';
    return this.http.post<ResponseModel>(this.rootUrl + endpoint, {
      email,
      password,
      fullName,
    });
  }
  // post user email and preferred password reset method, return acknowledgement of further communication 
  public forgotPassword(email: string, method: string): Observable<string> {
    let endpoint = 'forgot-password?email=' + email + '&method=' + method;
    return this.http.post<string>(this.rootUrl + endpoint, {});
  }
  // post user email and otp, return if the otp is valid
  public validateOtp(email: string, resetCode: string): Observable<boolean> {
    let endpoint = 'forgot-password/otp';
    return this.http.post<boolean>(this.rootUrl + endpoint, { email, resetCode });
  }
  // post jwt and receive refreshed jwt if valid
  public validateJwt(jwt: string): Observable<ResponseModel> {
    let endpoint = 'validate-token';
    return this.http.post<ResponseModel>(this.rootUrl + endpoint, { jwt });
  }
  // post new password and reset token, receives jwt
  public resetPassword(
    password: string,
    resetToken: string
  ): Observable<ResponseModel> {
    let endpoint = 'forgot-password/reset';
    return this.http.post<ResponseModel>(
      this.rootUrl + endpoint + '?resetToken=' + resetToken,
      { password }
    );
  }
}
