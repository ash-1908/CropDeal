import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  protected userEmail: string = "";
  protected userPassword: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  protected submitForm(): void {
    alert(
      "Email: " + this.userEmail + "\nPassword: " + this.userPassword
    );
  }

}
