import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CropsComponent } from './crops/crops.component';
import { CropsRoutingModule } from './crops-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    CropsComponent
  ],
  imports: [
    CommonModule,
    CropsRoutingModule,
    NgbModule
  ]
})
export class CropsModule { }
