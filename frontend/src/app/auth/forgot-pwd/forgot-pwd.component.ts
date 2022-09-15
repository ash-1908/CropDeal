import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-forgot-pwd',
  templateUrl: './forgot-pwd.component.html',
  styleUrls: ['./forgot-pwd.component.css']
})
export class ForgotPwdComponent implements OnInit {

  protected method: string = "";
  protected userEmail: string = "";

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  methodOnChange(method: string): void {
    this.method = method;
  }

  protected submitForm() :void {
    alert(
      "Email: " + this.userEmail + "\nMethod: " + this.method
    );
  }
}
