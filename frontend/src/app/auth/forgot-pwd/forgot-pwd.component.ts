import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-forgot-pwd',
  templateUrl: './forgot-pwd.component.html',
  styleUrls: ['./forgot-pwd.component.css']
})
export class ForgotPwdComponent implements OnInit {

  method = 'email';

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  methodOnChange(method: string): void {
    this.method = method;
  }

  forwardRequest(): void {
    console.log("hi")
    if(this.method === 'otp')
      this.router.navigate(["validate-otp"], {relativeTo: this.route});
    else
      this.router.navigate(["reset"], {relativeTo: this.route});
  }
}
