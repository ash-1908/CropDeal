import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavComponent } from './nav/nav.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ServiceService } from './user/service/service.service';
import { TokenInterceptorServiceService } from './user/tokeninterceptorservice/token-interceptor-service.service';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServiceService,
    {
      provide:  HTTP_INTERCEPTORS,
      useClass:TokenInterceptorServiceService,
      multi:true
      
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
