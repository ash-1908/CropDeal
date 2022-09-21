import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-reset-pwd',
  templateUrl: './reset-pwd.component.html',
  styleUrls: ['./reset-pwd.component.css'],
})
export class ResetPwdComponent implements OnInit {
  protected userPassword: string = '';
  protected userRePassword: string = '';

  constructor(
    private authService: AuthService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {}

  protected submitForm(): void {
    let resetToken = this.route.snapshot.params['token'];
    this.authService.resetPassword(this.userPassword, resetToken).subscribe();
    this.router.navigate(['/']);
  }
}
