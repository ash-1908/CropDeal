import { Component } from '@angular/core';
import { main } from '@popperjs/core';
import { MainService } from './main.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'CropDeal';
  protected userIsAuthenticated = false;

  constructor(private mainService: MainService) {}

  ngOnInit() {
    // if jwt token already exists and is valid, then user doesnt need to sign in again
    let jwt = localStorage.getItem('jwt') || '';
    if (jwt !== '') {
      this.mainService.validateJwt(jwt).subscribe((res) => {
        jwt = res.jwt;
        this.mainService.setCurrentUser(res);
      });
      localStorage.setItem('jwt', jwt);
      this.userIsAuthenticated = true;
    }
  }
}
