import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user/user.component';
import { UserRoutingModule } from './user-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { UpdateFormComponent } from './update-form/update-form.component';
import { ServiceService } from './service/service.service';
import { TokenInterceptorServiceService } from './tokeninterceptorservice/token-interceptor-service.service';


@NgModule({
  declarations: [
    UserComponent,
    NavbarComponent,
    UpdateFormComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
    
  ],

  providers: [ServiceService,
    {
      provide:  HTTP_INTERCEPTORS,
      useClass:TokenInterceptorServiceService,
      multi:true
      
  }],

})
export class UserModule { }
