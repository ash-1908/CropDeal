import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-validate-otp',
  templateUrl: './validate-otp.component.html',
  styleUrls: ['./validate-otp.component.css'],
})
export class ValidateOtpComponent implements OnInit {
  @Input()
  public phone: string = '';
  protected otpDigit1: string = '';
  protected otpDigit2: string = '';
  protected otpDigit3: string = '';
  protected otpDigit4: string = '';
  private otp: string = '';
  protected otpIsCorrect: boolean;
  protected errorMsg: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  protected submitForm(): void {
    this.otp =
      this.otpDigit1 + this.otpDigit2 + this.otpDigit3 + this.otpDigit4;
    let id = localStorage.getItem('user_id');
    if (id == null) this.errorMsg = 'Some error occured. Please retry';
    else
      this.authService.validateOtp(id, this.otp).subscribe((res) => {
        console.log('otp validation response' + res);
        this.otpIsCorrect = res;
        if (this.otpIsCorrect) {
          this.errorMsg = '';
          this.router.navigate([`../../auth/forgot-password/reset/${this.otp}`]);
        } else {
          this.errorMsg = 'Wrong OTP';
        }
      });
  }
}
