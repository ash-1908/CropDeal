import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  userr:string="";
  constructor() { 
    this.userr="test1";
  }

  ngOnInit(): void {

   
  };
   
  }

