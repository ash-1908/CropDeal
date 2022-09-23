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
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  userId: string = '';
  email: string = '';
  user: User = new User();
  bank: any;
  address: any;
  res: ResponseModel = new ResponseModel();

  userType:boolean;

  constructor(
    private service: ServiceService,
    private actRoute: ActivatedRoute
  ) {
    let id = this.actRoute.snapshot.params['id'];
    this.service.getUserById(id).subscribe((data) => {
      this.user = data;
      this.bank = data.bank;
      this.address = data.address;


    });
  }

  ngOnInit(): void {

   let role=localStorage.getItem("user_role");
   if(role=='ROLE_ADMIN'){
        this.userType=false;
   }
   else
   {
    this.userType=true
   }
   

  }
}
