import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  userId = localStorage.getItem('user_id');
  constructor() {}

  ngOnInit(): void {}
}
