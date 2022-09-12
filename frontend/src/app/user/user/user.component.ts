import { Component, OnInit } from '@angular/core';
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

  user:User={};
  bank:Bank={} ;
  address:Address={};

  constructor(private service:ServiceService) { 
    console.log("user is in constructer:");
  }

  ngOnInit(): void {

   this.service.getUserById(1).subscribe(data=>{this.user=data});
   console.log("user is:");
   console.log(this.user);
  }

}
