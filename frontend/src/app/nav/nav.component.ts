import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResponseModel } from 'src/assets/model/ResponseModel';
import { MainService } from '../main.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],
})
export class NavComponent implements OnInit {
  @Input()
  public userIsAuthenticated: boolean;

  constructor() {}

  ngOnInit(): void {
    
  }
}
