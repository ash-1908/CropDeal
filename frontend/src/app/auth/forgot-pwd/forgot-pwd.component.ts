import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-forgot-pwd',
  templateUrl: './forgot-pwd.component.html',
  styleUrls: ['./forgot-pwd.component.css'],
})
export class ForgotPwdComponent implements OnInit {
  protected sendEmail = true;
  protected userEmail: string = '';
  protected serverAck = '';
  protected error = '';
  protected showModal = false;

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    this.error = '';
    this.showModal = false;
  }

  methodOnChange(method: boolean): void {
    this.sendEmail = method;
  }

  protected submitForm(): void {
    let method = this.sendEmail ? 'email' : 'otp';
    this.authService.forgotPassword(this.userEmail, method).subscribe({
      next: (res) => {
        if (res.email == null) this.serverAck = res.phone;
        else this.serverAck = res.email;
        if (method.match('otp')) {
          this.serverAck =
            this.serverAck.slice(0, 5) + '*****' + this.serverAck.slice(10);
          alert('OTP has been sent to phone number: ' + this.serverAck);
          this.showModal = true;
        } else {
          let splitEmail = this.serverAck.split('@');
          this.serverAck =
            splitEmail[0].slice(
              splitEmail[0].length - 4,
              splitEmail[0].length
            ) +
            '@' +
            splitEmail[1];
          alert(
            'Email has been sent to email address: *******' + this.serverAck
          );
          this.router.navigate(['/']);
        }
      },
      error: (error) => {
        this.error = error;
      },
    });
  }
}
