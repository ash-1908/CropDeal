import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RatingComponent } from './rating/rating.component';
import { RatingRoutingModule } from './rating-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    RatingComponent
  ],
  imports: [
    CommonModule,
    RatingRoutingModule,
    NgbModule
  ]
})
export class RatingModule { }
