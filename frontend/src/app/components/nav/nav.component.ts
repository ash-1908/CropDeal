import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { AuthService } from '../../auth/auth.service';
import { MainService } from '../../main.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],
})
export class NavComponent implements OnInit {
  @Input()
  public userIsAuthenticated: boolean = false;

  constructor(
    private mainService: MainService,
    private authService: AuthService
  ) {
    this.mainService.userIsAuthenticated$.subscribe(
      (res) => (this.userIsAuthenticated = res)
    );

    let jwtExists = localStorage.getItem("jwt");
    if(jwtExists != null && jwtExists != '') this.userIsAuthenticated = true;
    else this.userIsAuthenticated = false;
  }

  ngOnInit(): void {
    
  }

  signOut(): void {
    this.authService.signOut();
    this.mainService.setUserIsAuthenticated(false);
    this.userIsAuthenticated = false;
  }
}
