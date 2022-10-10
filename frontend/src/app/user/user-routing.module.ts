import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SaveCropitemComponent } from '../crops/crops/save-cropitem/save-cropitem.component';
import { AdduserformComponent } from './adduserform/adduserform.component';
import { AdminComponent } from './admin/admin.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UpdateFormComponent } from './update-form/update-form.component';
import { Updateform1Component } from './updateformAdmin/updateform1.component';

import { UserComponent } from './user/user.component';

const routes: Routes = [
  {
    path: '',
    component: NavbarComponent,
    children: [
      { path: '', redirectTo: 'profile', pathMatch: 'full' },
      { path: 'register', component: AdduserformComponent },
      { path: 'profile', component: UserComponent },
      { path: 'update', component: UpdateFormComponent },
      {path:'admin/homepage' ,component:AdminComponent},
       {path:'admin/update',component:Updateform1Component}

    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UserRoutingModule {}
