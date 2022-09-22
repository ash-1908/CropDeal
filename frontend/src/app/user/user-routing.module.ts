import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SaveCropitemComponent } from '../crops/crops/save-cropitem/save-cropitem.component';
import { AdduserformComponent } from './adduserform/adduserform.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UpdateFormComponent } from './update-form/update-form.component';

import { UserComponent } from './user/user.component';

const routes: Routes = [
  {
    path: '',
    component: NavbarComponent,
    children: [
      { path: '', redirectTo: '', pathMatch: 'full' },
      { path: 'register', component: AdduserformComponent },
      { path: 'profile/:id', component: UserComponent },
      { path: 'update', component: UpdateFormComponent },
      { path: 'crops/save-cropitem', component: SaveCropitemComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UserRoutingModule {}
