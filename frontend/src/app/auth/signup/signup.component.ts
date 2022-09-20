import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  protected userEmail: string = "";
  protected userPassword: string = "";
  protected userFullName: string = "";
  constructor() { }

  ngOnInit(): void {
  }

  protected submitForm(): void {
    alert(
      "Email: " + this.userEmail + "\nPassword: " + this.userPassword
    )
  }
}
