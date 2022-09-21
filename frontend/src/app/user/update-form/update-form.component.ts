import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
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
   val:boolean;
  

  constructor(private service:ServiceService,private router:Router) { }

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

  console.log( this.user.fullName+"empty full name");
  console.log( this.user.bank.accountHolderName+"empty full bank");
  console.log( this.user.address+"empty full address")

  if(this.user.fullName==""&&this.user.roles=="" && this.user.phoneNumber==0&&this.user.userName==""&&this.user.email==""&&
  this.bank.accountHolderName==""&& this.bank.accountNo==0&& this.bank.bankBranch==""&& this.bank.bankIFSC==""&& this.bank.bankName==""&&
  this.address.city==""&&this.address.country==""&&this.address.houseNo==""&&this.address.localityName==""&&this.address.pincode==0&&this.address.state==""&&this.address.streetName==""
  )
  {
   alert('Provide atleast one value')

  }
  else{
    this.service.updateUser(this.id,this.user).subscribe(data=>{
  
    this.val=true;
    alert('Value updated Successfully .....')
     this.router.navigate(['user/profile']);

     });
    
    }


  }

}
