import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-forgot-pwd',
  templateUrl: './forgot-pwd.component.html',
  styleUrls: ['./forgot-pwd.component.css'],
})
export class ForgotPwdComponent implements OnInit {
  protected sendEmail = true;
  protected userEmail: string = '';

  constructor(private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {}

  methodOnChange(method: boolean): void {
    this.sendEmail = method;
  }

  protected submitForm(): void {
    alert(
      'Email: ' + this.userEmail + '\nMethod: ' + (this.sendEmail
        ? 'Sending email'
        : 'Sending OTP')
    );
  }
}
