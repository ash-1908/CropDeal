import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MainService } from 'src/app/main.service';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  protected userEmail: string = '';
  protected userPassword: string = '';
  protected userFullName: string = '';
  protected userIsFarmer: boolean = true;
  protected res: ResponseModel = new ResponseModel();
  protected error = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    private mainService: MainService
  ) {}

  ngOnInit(): void {
    this.error = '';
  }

  protected submitForm(): void {
    this.authService
      .signUp(
        this.userEmail,
        this.userPassword,
        this.userFullName,
        this.userIsFarmer
      )
      .subscribe({
        next: (res) => {
          this.res = res;
          this.mainService.setUserIsAuthenticated(true);

          this.router.navigate(['../../user/register/']);
        },
        error: (error) => {
          this.error = error;
        },
      });
  }
}
