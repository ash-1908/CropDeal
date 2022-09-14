import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Address } from '../model/address';
import { Bank } from '../model/bank';
import { User } from '../model/user';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
 
  username:string="";
  email:string="";
  user:User={};
  bank:any;
  address:any;

  constructor(private service:ServiceService,private actRoute:ActivatedRoute) { 
   
  }

  ngOnInit(): void {

    console.log("inside init");
    this.actRoute.params.subscribe(params=>{
      this.username=params['username'];

   });

    
   this.service.getUserByUserName(this.username).subscribe(data=>{
    this.user=data;
    console.log("user is:");
    console.log(this.user);
    this.bank=data.bank;
    this.address=data.address;
  });
   
  }

}
