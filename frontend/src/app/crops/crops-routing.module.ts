import { NgModule } from '@angular/core';
import { Routes, RouterModule, Router } from '@angular/router';

import { CropsComponent } from './crops/crops.component';
import { CropitemListComponent } from './crops/cropitem-list/cropitem-list.component';
import { SaveCropitemComponent } from './crops/save-cropitem/save-cropitem.component';
import { UpdateCropitemComponent } from './crops/update-cropitem/update-cropitem.component';
import { CropitemDetailsComponent } from './crops/cropitem-details/cropitem-details.component';


const routes: Routes = [
  {
    path: '',
    component: CropsComponent,
    children: [
      { path: '', redirectTo: 'cropitems', pathMatch:'full'},
      { path: 'cropitems', component: CropitemListComponent },
      { path: 'save-cropitem', component: SaveCropitemComponent},
      
      { path: "update-cropitem/:id", component: UpdateCropitemComponent},
      {path: 'cropitem-details/:id', component: CropitemDetailsComponent}
    ]

  },
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CropsRoutingModule {
  constructor(private router: Router) {
    this.router.errorHandler = (error: any) => {
        this.router.navigate(['404']); // or redirect to default route
    }
  }
 }