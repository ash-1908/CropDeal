import { Component, OnInit } from '@angular/core';
import { Cropitem } from '../cropitem';
import { CropitemService } from '../cropitem.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cropitem-list',
  templateUrl: './cropitem-list.component.html',
  styleUrls: ['./cropitem-list.component.css'],
})
export class CropitemListComponent implements OnInit {
  private userId: string = '';
  private userRole: string = '';
  protected userIsFarmerFlag: boolean = true;

  cropitems: Cropitem[] = [];


  constructor(
    private cropitemService: CropitemService,
    private router: Router
  ) {
    this.cropitemService.getUser().subscribe((data) => {
      this.userId = data.id;
      this.userRole = data.role;
      if(data.role === "ROLE_FARMER") this.userIsFarmerFlag = true
      else this.userIsFarmerFlag = false;
    });

    this.cropitemService.getCropitemsList().subscribe((data) => {
      this.cropitems = data;
    });

  }

  ngOnInit(): void {
    this.getCropitems();
  }

  private getCropitems() {
    this.cropitemService.getCropitemsList().subscribe((data) => {
      this.cropitems = data;
    });
  }

  updateCropitem(cropid: number) {
    this.router.navigate(['crops/update-cropitem', cropid]);
  }

  deleteCropitem(cropid: number) {
    if (confirm('Are you sure delete the crop?'))
      this.cropitemService.deleteCropitem(cropid).subscribe((data) => {
        alert('Crop deleted Successfully');
        //console.log(data);
        this.ngOnInit();
        //this.getCropitems();
      });
  }

  cropitemDetails(cropid: number) {
    this.router.navigate(['crops/cropitem-details', cropid]);
  }
}
