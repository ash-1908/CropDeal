import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.module').then((m) => m.AuthModule),
  },
  {
    path: 'user',
    loadChildren: () => import('./user/user.module').then((m) => m.UserModule),
  },
  {
    path: 'bill',
    loadChildren: () => import('./bill/bill.module').then((m) => m.BillModule),
  },
  {
    path: 'crops',
    loadChildren: () =>
      import('./crops/crops.module').then((m) => m.CropsModule),
  },
  {
    path: 'rating',
    loadChildren: () =>
      import('./rating/rating.module').then((m) => m.RatingModule),
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: 'NavComponent',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
