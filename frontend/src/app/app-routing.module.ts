import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdduserformComponent } from './adduserform/adduserform.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { NavComponent } from './nav/nav.component';
import { Updateform1Component } from './updateform1/updateform1.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
     path:'admin',component:AdminComponent
  },
  {
    path:'register',component:AdduserformComponent
  },
  {
    path:'admin/user/update' ,component:Updateform1Component
  },
  {
    path: 'auth', loadChildren: () => import("./auth/auth.module").then(m => m.AuthModule) 
  },
  {
    path: 'user', loadChildren: () => import("./user/user.module").then(m => m.UserModule)
  },
  {
    path: 'bill', loadChildren: () => import("./bill/bill.module").then(m => m.BillModule)
  },
  {
    path: 'crops', loadChildren: () => import("./crops/crops.module").then(m => m.CropsModule)
  },
  {
    path: 'rating', loadChildren: () => import("./rating/rating.module").then(m => m.RatingModule)
  },
  {
    path: '**', pathMatch: 'full', redirectTo: 'NavComponent'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
