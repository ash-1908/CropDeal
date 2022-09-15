import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reset-pwd',
  templateUrl: './reset-pwd.component.html',
  styleUrls: ['./reset-pwd.component.css']
})
export class ResetPwdComponent implements OnInit {
  
  protected userPassword: string = "";
  protected userRePassword: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  protected submitForm() : void {
    alert(
      "Password: " + this.userPassword + "\nRe-entered Password: " + this.userRePassword
    );
  }

  
}
