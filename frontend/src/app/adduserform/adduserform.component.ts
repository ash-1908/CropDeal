import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Address } from '../user/model/address';
import { Bank } from '../user/model/bank';
import { User } from '../user/model/user';
import { Userr } from '../user/model/userr';
import { ServiceService } from '../user/service/service.service';

@Component({
  selector: 'app-adduserform',
  templateUrl: './adduserform.component.html',
  styleUrls: ['./adduserform.component.css']
})
export class AdduserformComponent implements OnInit {

  id:string;
   username:string="";
   user:User={
     roles: '',
     email:'',
     active:true
   };
   roles:string='';
   bank:Bank={};
   address:Address={};
   val:boolean=false;
   
   msg:string;

   addstatus:string
   userDb:any;

  constructor(private service:ServiceService) { }

  ngOnInit(): void {
  }

  onsubmit(RegisterForm:NgForm):void{

    // console.log("data in ng form"+updateForm.value.usertype)
    // console.log("data in ng form"+updateForm.value.username)
    // console.log("data in ng form"+updateForm.value.accountno)

  // this.id=this.service.getId();
   this.user.roles=RegisterForm.value.usertype;
   this.user.fullName=RegisterForm.value.fullname;
   this.user.userName=RegisterForm.value.username;
   this.user.email=RegisterForm.value.email;
   this.user.phoneNumber=RegisterForm.value.mobileno;
   //this.user.active=true;


   this.bank.accountHolderName=RegisterForm.value.accountname;
   this.bank.bankName=RegisterForm.value.bankname;
   this.bank.bankBranch=RegisterForm.value.bankbranch;
   this.bank.bankIFSC=RegisterForm.value.ifsccode;
   this.bank.accountNo=RegisterForm.value.accountno;

   this.address.city=RegisterForm.value.city;
   this.address.country=RegisterForm.value.country;
   this.address.houseNo=RegisterForm.value.houseno;
   this.address.streetName=RegisterForm.value.streetname;
  
   this.address.localityName=RegisterForm.value.localityname;
   this.address.pincode=RegisterForm.value.pincode;
   this.address.state=RegisterForm.value.state;
   
   this.user.bank=this.bank;
   this.user.address=this.address;

   console.log("requested user data is:");
   console.log(this.user);

  this.service.addUser(this.user).subscribe(data=>
    {
    console.log("Added database data is:");
    console.log(data);
    console.log("error is :");
    },
 
    (err: any) => {alert(JSON.parse(JSON.stringify(err.error.text)));window.location.reload()}
    )

  }


}
