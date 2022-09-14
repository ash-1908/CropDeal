
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { UpdateFormComponent } from './update-form/update-form.component';

import { UserComponent } from './user/user.component';


const routes: Routes = [
  {
  path : "" ,
  component:NavbarComponent ,
  children: [
    {path: '', redirectTo: '', pathMatch: 'full'},
    {path:"profile/:username" ,component:UserComponent },
    { path:"update/:username" ,component:UpdateFormComponent}

  ],

  
     },
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }