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
 
  userId:string="";
  email:string="";
  user:User=new User();
  bank:any;
  address:any;
  res: ResponseModel = new ResponseModel();

  constructor(private service:ServiceService,private actRoute:ActivatedRoute) { 
    this.service.getUser().subscribe(data => {
      
        this.userId = "63285c9fcbbc536e9426d312";
        this.user.fullName = "xyz abc";
        this.user.roles = "ROLE_FARMER";
      
    })
    console.log("logging response: " + this.res.id);
  } 

  ngOnInit(): void {
    
  //   console.log("inside init");
  //   this.actRoute.params.subscribe(params=>{
  //     this.username=params['username'];

  //  });

    // MAKE THIS FOR ID
   this.service.getUserById(this.userId).subscribe(data=>{
    this.user=data;
    console.log("user is:");
    console.log(this.user);
    console.log(this.user?.roles);
    this.bank=data.bank;
    this.address=data.address;
  });
   
  }

}
