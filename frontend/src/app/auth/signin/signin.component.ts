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
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  protected userEmail: string = "";
  protected userPassword: string = "";
  res = new ResponseModel();

  constructor(private authService:AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  protected submitForm(): void {
    alert(
      "Email: " + this.userEmail + "\nPassword: " + this.userPassword
    );
  }

  shareData() : void {
    // from sign in i get response
    //convert response to user
    this.authService.signIn("ad", "dafa");
  }

}
