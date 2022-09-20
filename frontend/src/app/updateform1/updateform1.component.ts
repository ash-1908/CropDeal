import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Address } from '../user/model/address';
import { Bank } from '../user/model/bank';
import { Userr } from '../user/model/userr';
import { ServiceService } from '../user/service/service.service';

@Component({
  selector: 'app-updateform1',
  templateUrl: './updateform1.component.html',
  styleUrls: ['./updateform1.component.css']
})
export class Updateform1Component implements OnInit {

   id:string;
   username:string="";
   user:Userr={
     id: '',
     roles: '',
     email:'',
     active:true
   };
   roles:string='';
   bank:Bank={};
   address:Address={};
   val:boolean=false;

  constructor(private service:ServiceService) { }

  ngOnInit(): void {
  }

  onsubmit(updateForm:NgForm):void{

    console.log("data in ng form"+updateForm.value.usertype)
    console.log("data in ng form"+updateForm.value.username)
    console.log("data in ng form"+updateForm.value.accountno)

    this.id=this.service.getId();
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
    console.log("updated data is:");
    console.log(data);
  })


  }


}
