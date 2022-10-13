import { Component, OnInit } from '@angular/core';
import { Cropitem } from '../cropitem';
import { CropitemService } from '../cropitem.service';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/user/service/service.service';

@Component({
  selector: 'app-cropitem-list',
  templateUrl: './cropitem-list.component.html',
  styleUrls: ['./cropitem-list.component.css'],
})
export class CropitemListComponent implements OnInit {
  private userId: string = localStorage.getItem('user_id') + '';
  private userRole: string = localStorage.getItem('user_role') + '';
  private idList: string[] = [];
  protected userIsFarmerFlag: boolean = true;

  cropitems: Cropitem[];

  constructor(
    private cropitemService: CropitemService,
    private userService: ServiceService,
    private router: Router
  ) {
    if (this.userRole === 'ROLE_ADMIN')
      this.cropitemService.getAllCropitemsList().subscribe((data) => {
        this.cropitems = data;
      });
    else {
      this.userService
        .getUserCrops(this.userId)
        .subscribe((data) => (this.idList = data));
      this.cropitemService.getCropitemsList(this.idList).subscribe((data) => {
        this.cropitems = data;
      });
    }
  }

  ngOnInit(): void {
    this.getCropitems();
  }

  private getCropitems() {
    if (this.userRole === 'ROLE_ADMIN')
      this.cropitemService.getAllCropitemsList().subscribe((data) => {
        this.cropitems = data;
      });
    else {
      this.userService
        .getUserCrops(this.userId)
        .subscribe((data) => (this.idList = data));
      this.cropitemService.getCropitemsList(this.idList).subscribe((data) => {
        this.cropitems = data;
      });
    }
  }

  updateCropitem(id: string) {
    this.router.navigate(['crops/update-cropitem', id]);
  }

  deleteCropitem(id: string) {
    if (confirm('Are you sure delete the crop?'))
      this.cropitemService.deleteCropitem(id).subscribe((data) => {
        console.log(data);
        this.getCropitems();
      });
    window.location.reload();
  }

  cropitemDetails(id: string) {
    this.router.navigate(['crops/cropitem-details', id]);
  }
}
