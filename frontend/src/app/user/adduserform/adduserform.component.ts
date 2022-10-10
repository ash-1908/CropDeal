import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Address } from '../model/address';
import { Bank } from '../model/bank';
import { User } from '../model/user';
import { Userr } from '../model/userr';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-adduserform',
  templateUrl: './adduserform.component.html',
  styleUrls: ['./adduserform.component.css'],
})
export class AdduserformComponent implements OnInit {
  id: string;
  user1: User;
  username: string = '';
  user: User = {
    roles: '',
    email: '',
    active: true,
    fullName: '',
  };
  roles: string = '';
  bank: Bank = {};
  address: Address = {};
  val: boolean = false;

  msg: string;

  addstatus: string;
  userDb: any;

  constructor(private service: ServiceService, private router: Router) {}

  ngOnInit(): void {
    let signupId = localStorage.getItem('user_id')
      ? localStorage.getItem('user_id')
      : '';
    this.user.id = signupId ? signupId : '';
  }

  goToAdminPage() {
    this.router.navigate(['admin']);
  }

  onsubmit(RegisterForm: NgForm): void {
    // this.user.roles = RegisterForm.value.usertype;
    // this.user.fullName = RegisterForm.value.fullname;
    this.user.userName = RegisterForm.value.username;
    // this.user.email = RegisterForm.value.email;
    this.user.phoneNumber = RegisterForm.value.mobileno;
    //this.user.active=true;

    this.bank.accountHolderName = RegisterForm.value.accountname;
    this.bank.bankName = RegisterForm.value.bankname;
    this.bank.bankBranch = RegisterForm.value.bankbranch;
    this.bank.bankIFSC = RegisterForm.value.ifsccode;
    this.bank.accountNo = RegisterForm.value.accountno;

    this.address.city = RegisterForm.value.city;
    this.address.country = RegisterForm.value.country;
    this.address.houseNo = RegisterForm.value.houseno;
    this.address.streetName = RegisterForm.value.streetname;

    this.address.localityName = RegisterForm.value.localityname;
    this.address.pincode = RegisterForm.value.pincode;
    this.address.state = RegisterForm.value.state;

    this.user.bank = this.bank;
    this.user.address = this.address;

    console.log('requested user data is:');
    console.log(this.user);

    this.service.addUser(this.user).subscribe(
      (data) => {
        console.log('Added database data is:');
        console.log(data);
        console.log('error is :');
        this.router.navigate(['../../user/profile']);
      },

      (err: any) => {
        alert(JSON.parse(JSON.stringify(err.error.text)));
       
      }
    );
  }
}
