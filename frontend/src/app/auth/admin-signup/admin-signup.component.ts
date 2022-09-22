import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MainService } from 'src/app/main.service';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-admin-signup',
  templateUrl: './admin-signup.component.html',
  styleUrls: ['./admin-signup.component.css']
})
export class AdminSignupComponent implements OnInit {
  protected userEmail: string = '';
  protected userPassword: string = '';
  protected userFullName: string = '';
  protected res: ResponseModel = new ResponseModel();
  private ADMIN_ROLE = 'ROLE_ADMIN';
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
    this.authService.signUpAdmin(this.userEmail, this.userPassword, this.userFullName, this.ADMIN_ROLE).subscribe({
      next: (res) => {
        this.res = res;
        this.mainService.setUserIsAuthenticated(true);
        this.router.navigate([`../../user/profile/${res.id}`]);
      },
      error: (error) => {
        this.error = error;
      },
    });
  }
}
