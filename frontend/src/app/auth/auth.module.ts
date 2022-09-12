import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthRoutingModule } from './auth-routing.module';
import { AuthComponent } from './auth/auth.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { ForgotPwdComponent } from './forgot-pwd/forgot-pwd.component';
import { ResetPwdComponent } from './reset-pwd/reset-pwd.component';
import { ValidateOtpComponent } from './validate-otp/validate-otp.component';

@NgModule({
  declarations: [
    AuthComponent,
    SigninComponent,
    SignupComponent,
    ForgotPwdComponent,
    ResetPwdComponent,
    ValidateOtpComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    NgbModule
  ],
  exports: [
    
  ]
})
export class AuthModule { }
