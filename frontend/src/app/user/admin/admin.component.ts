import { Binary } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { Userr } from '../model/userr';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  users:Userr[];
  userId:string=''  ;
  userStatus:boolean;
  user:any;
  fullname:string;
  constructor(private userService:ServiceService,private router: Router) {
    userService.getAllUsers().subscribe(data=>this.users=data);
    console.log(this.users);
   }

  ngOnInit(): void {

    
  }

  register(){
    this.router.navigate(['register']);
  }


  updateUser(id:string):void{

    this.userService.getId();
    this.userId=id;
    console.log(this.userId)
    this.router.navigate(['admin/user/update']);

    
  }

  markUser(id:string,userStatus:boolean){

    this.userService.markUserStatus(id,userStatus).subscribe(data=>{
        console.log(data);
       })

       setTimeout(function(){
         window.location.reload();
      }, 500); 
    
    
  }

 
  deleteUser(id:string){
    
   
   this.user=this.users.find(user=>user.id==id)
    console.log(this.user.fullName);
    alert('deleting '+id+" "+this.user.fullName);
 
    this.userService.deleteUserById(id).subscribe(data=>{
      console.log("deleted user response : "+data);
    })
    window.location.reload();

  }





}
