import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavComponent } from './nav/nav.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ServiceService } from './user/service/service.service';
import { TokenInterceptorServiceService } from './user/tokeninterceptorservice/token-interceptor-service.service';
import { HomeComponent } from './home/home.component';
import { AuthService } from './auth/auth.service';
import { AdminComponent } from './admin/admin.component';
import { Updateform1Component } from './updateform1/updateform1.component';
import { AdduserformComponent } from './adduserform/adduserform.component';

@NgModule({
  declarations: [AppComponent, NavComponent, HomeComponent, AdminComponent, Updateform1Component, AdduserformComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    ServiceService,
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorServiceService,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
