import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

    user:User;
    userId:string="6324e2a86879610ec04cdc37";

   constructor(userService:ServiceService) {

    
    
  }

  ngOnInit(): void {
    
  };
   
  }

