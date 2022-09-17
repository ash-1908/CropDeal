import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { AuthService } from '../auth/auth.service';
import { MainService } from '../main.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],
})
export class NavComponent implements OnInit {
  @Input()
  public userIsAuthenticated: boolean = false;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.authService
      .isUserLoggedIn()
      .subscribe((auth) => (this.userIsAuthenticated = auth));
  }

  signOut(): void {
    this.authService.signOut();
    window.location.reload();
  }
}
