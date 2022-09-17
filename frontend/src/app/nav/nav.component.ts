import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { MainService } from '../main.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],
})
export class NavComponent implements OnInit {
  protected authenticated: boolean = false;
  private response: ResponseModel = new ResponseModel();

  constructor(private mainService: MainService, private router: Router) {}

  ngOnInit(): void {
    let jwt = localStorage.getItem('jwt');
    if (jwt) {
      // in case jwt token exists in localstorage, validate it and refresh it
      this.mainService
        .validateJwt(jwt)
        .subscribe((res) => (this.response = res));
      this.authenticated = true;
      localStorage.setItem('jwt', this.response.jwt);
    }
  }
}
