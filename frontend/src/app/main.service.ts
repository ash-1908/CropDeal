import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, Subject, throwError } from 'rxjs';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { User } from './user/model/user';

@Injectable({
  providedIn: 'root',
})
export class MainService {
  private VALIDATE_TOKEN_URL = 'http://localhost:8081/validate-token';

  constructor(private http: HttpClient, private router: Router) {}

  public validateJwt(jwt: string): Observable<ResponseModel> {
    return this.http
      .post<ResponseModel>(this.VALIDATE_TOKEN_URL, { jwt })
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred.
      console.error('An error occurred:', error.error);
      return throwError(() => new Error('Network error.'));
    } else if (error.status === 511) {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(`Session expired.`);
      this.router.navigate(['/auth/signin']);
      return throwError(() => new Error('Session expired.'));
    } else {
      console.error('Unexpected error occured. Error: ' + error.error);
      return throwError(() => new Error('Unexpected error occured.'));
    }
  }
}
