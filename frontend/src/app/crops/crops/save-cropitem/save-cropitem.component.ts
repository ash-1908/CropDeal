import { Component, OnInit } from '@angular/core';
import { Cropitem } from '../cropitem';
import { CropitemService } from '../cropitem.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-save-cropitem',
  templateUrl: './save-cropitem.component.html',
  styleUrls: ['./save-cropitem.component.css']
})
export class SaveCropitemComponent implements OnInit {

  cropitem: Cropitem = new Cropitem();

  constructor(private cropitemService:CropitemService,
    private router: Router) { }

  ngOnInit(): void {
  }

  createCropitem(){
    this.cropitemService.saveCropitem(this.cropitem).subscribe( data => {
        console.log(data);
        this.goToCropitemList();
      },
      error => console.log(error));
  }

  goToCropitemList(){
    this.router.navigate(['crops/cropitems']);
  }

  onSubmit(){
    console.log(this.cropitem);
    this.createCropitem();
  }

}
