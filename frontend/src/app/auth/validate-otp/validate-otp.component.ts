import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-validate-otp',
  templateUrl: './validate-otp.component.html',
  styleUrls: ['./validate-otp.component.css']
})
export class ValidateOtpComponent implements OnInit {

  protected phoneNumber: string = '+91****83838'
  protected otpDigit1: string = "";
  protected otpDigit2: string = "";
  protected otpDigit3: string = "";
  protected otpDigit4: string = "";
  private otp: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  protected submitForm() : void {
    this.otp = this.otpDigit1+this.otpDigit2+this.otpDigit3+this.otpDigit4;
    alert("OTP: " + this.otp);
  }

}
