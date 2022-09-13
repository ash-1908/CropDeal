import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CropsComponent } from './crops/crops.component';
import { CropsRoutingModule } from './crops-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CropitemListComponent } from './crops/cropitem-list/cropitem-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SaveCropitemComponent } from './crops/save-cropitem/save-cropitem.component';
import { UpdateCropitemComponent } from './crops/update-cropitem/update-cropitem.component';
import { CropitemDetailsComponent } from './crops/cropitem-details/cropitem-details.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    CropsComponent,
    CropitemListComponent,
    SaveCropitemComponent,
    UpdateCropitemComponent,
    CropitemDetailsComponent
  ],
  imports: [
    CommonModule,
    CropsRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ]
})
export class CropsModule { }
