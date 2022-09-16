import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ResponseModel } from 'src/assets/model/ResponseModel';
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
  user:User=new User();
  bank:any;
  address:any;
  res: ResponseModel = new ResponseModel();

  constructor(private service:ServiceService,private actRoute:ActivatedRoute) { 
    this.service.getUser().subscribe(data => {
      
        this.user.userId = 123;
        this.user.userFullName = "ANMOL";
        this.user.userType = "ROLE_FARMER"
      
    })
    console.log("logging response: " + this.res.id);
  } 

  ngOnInit(): void {
    
    console.log("inside init");
    this.actRoute.params.subscribe(params=>{
      this.username=params['username'];

   });

    // MAKE THIS FOR ID
   this.service.getUserByUserName(this.username).subscribe(data=>{
    this.user=data;
    console.log("user is:");
    console.log(this.user);
    this.bank=data.bank;
    this.address=data.address;
  });
   
  }

}
