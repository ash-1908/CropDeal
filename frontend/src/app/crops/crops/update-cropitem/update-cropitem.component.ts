import { Component, OnInit } from '@angular/core';
import { CropitemService } from '../cropitem.service';
import { Cropitem } from '../cropitem';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-cropitem',
  templateUrl: './update-cropitem.component.html',
  styleUrls: ['./update-cropitem.component.css']
})
export class UpdateCropitemComponent implements OnInit {

  cropid:number;
  cropitem: Cropitem = new Cropitem();
  constructor(private cropitemService: CropitemService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.cropid = this.route.snapshot.params['cropid'];

    this.cropitemService.getCropitemById(this.cropid).subscribe(data => {
      this.cropitem = data;
    }, error => console.log(error));
  }
  
  onSubmit(){
    this.cropitemService.updateCropitem(this.cropid, this.cropitem).subscribe( data =>{
      this.goToCropitemList();
    }
    , error => console.log(error));
  }

  goToCropitemList(){
    this.router.navigate(['crops/cropitems']);
  }

}
