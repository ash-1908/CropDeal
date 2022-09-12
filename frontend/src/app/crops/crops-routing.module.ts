import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CropsComponent } from './crops/crops.component';


const routes: Routes = [
  {
    path: '',
    component: CropsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CropsRoutingModule { }