import { Component, OnInit } from '@angular/core';
import { Cropitem } from '../cropitem';
import { CropitemService } from '../cropitem.service';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/user/service/service.service';

@Component({
  selector: 'app-save-cropitem',
  templateUrl: './save-cropitem.component.html',
  styleUrls: ['./save-cropitem.component.css'],
})
export class SaveCropitemComponent implements OnInit {
  cropitem: Cropitem = new Cropitem();

  constructor(
    private cropitemService: CropitemService,
    private userService: ServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  createCropitem() {
    this.cropitemService.saveCropitem(this.cropitem).subscribe(
      (data) => {
        console.log(data);
        this.goToCropitemList();
        let userId = localStorage.getItem("user_id") || '';
        this.userService.addCropToUser(userId, data.id).subscribe((data) => {
          console.log(data);
        });
      },
      (error) => console.log(error)
    );
  }

  goToCropitemList() {
    this.router.navigate(['crops/cropitems']);
  }

  onSubmit() {
    console.log(this.cropitem);
    this.createCropitem();
  }
}
