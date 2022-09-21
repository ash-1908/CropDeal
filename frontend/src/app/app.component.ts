import { Component } from '@angular/core';
import { MainService } from './main.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'CropDeal';
  
  constructor(private mainService: MainService) {
  }

  ngOnInit() {
    
  }
}
