import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MainService } from 'src/app/main.service';
import { User } from 'src/app/user/model/user';
import { ServiceService } from 'src/app/user/service/service.service';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css'],
})
export class SigninComponent implements OnInit {
  protected userEmail: string = '';
  protected userPassword: string = '';
  private res = new ResponseModel();

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  // call signin method in service, upon success set the current user and set the jwt token in localstorage
  protected submitForm(): void {
    this.authService
      .signIn(this.userEmail, this.userPassword)
      .subscribe((res) => this.res = res);
   
    this.router.navigate(['../../user/profile/', this.res.id]);
  }
}
