import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BillComponent } from './bill/bill.component';


const routes: Routes = [
  {
    path: '',
    component: BillComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BillRoutingModule { }