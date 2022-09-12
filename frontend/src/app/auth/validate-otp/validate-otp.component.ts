import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-validate-otp',
  templateUrl: './validate-otp.component.html',
  styleUrls: ['./validate-otp.component.css']
})
export class ValidateOtpComponent implements OnInit {

  phoneNumber = '+91****83838'

  constructor() { }

  ngOnInit(): void {
  }

}
