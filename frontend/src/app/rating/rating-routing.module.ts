import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RatingComponent } from './rating/rating.component';


const routes: Routes = [
  {
    path: '',
    component: RatingComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RatingRoutingModule { }