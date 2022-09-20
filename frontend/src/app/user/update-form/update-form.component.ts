import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Address } from '../model/address';
import { Bank } from '../model/bank';
import { User } from '../model/user';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-update-form',
  templateUrl: './update-form.component.html',
  styleUrls: ['./update-form.component.css']
})
export class UpdateFormComponent implements OnInit {
  
   id:string="63285c9fcbbc536e9426d312";
   username:string="";
   user:User={};
   bank:Bank={};
   address:Address={};
   val:boolean=false;
  

  constructor(private service:ServiceService) { }

  ngOnInit(): void {

    // this.actRoute.params.subscribe(params=>{
    //   this.username=params['username'];
      
    // });

    // this.service.getUserById(this.id).subscribe(data=>{
    //   this.id=data.userId;
    //   console.log(this.id,"and data  of user is");
    //   console.log("=>",data);
      
    // });
  }
 

  
  onsubmit(updateForm:NgForm):void{

    console.log(updateForm.value)
   this.user.roles=updateForm.value.usertype;
   this.user.fullName=updateForm.value.fullname;
   this.user.userName=updateForm.value.username;
   this.user.email=updateForm.value.email;
   this.user.phoneNumber=updateForm.value.mobileno;
   this.user.active=true;


   this.bank.accountHolderName=updateForm.value.accountname;
   this.bank.bankName=updateForm.value.bankname;
   this.bank.bankBranch=updateForm.value.bankbranch;
   this.bank.bankIFSC=updateForm.value.ifsccode;
   this.bank.accountNo=updateForm.value.accountno;

   this.address.city=updateForm.value.city;
   this.address.country=updateForm.value.country;
   this.address.houseNo=updateForm.value.houseno;
   this.address.streetName=updateForm.value.streetname;
  
   this.address.localityName=updateForm.value.localityname;
   this.address.pincode=updateForm.value.pincode;
   this.address.state=updateForm.value.state;
   
   this.user.bank=this.bank;
   this.user.address=this.address;

   console.log("requested user data is:");
  console.log(this.user);

  this.service.updateUser(this.id,this.user).subscribe(data=>{
    console.log("data is:");
    console.log(data);
  })

   setTimeout(()=>window.location.reload(),1500);
   
  }

}
