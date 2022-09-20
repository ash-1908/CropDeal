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

  id:string;
  cropitem: Cropitem = new Cropitem();
  constructor(private cropitemService: CropitemService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.cropitemService.getCropitemById(this.id).subscribe(data => {
      this.cropitem = data;
    }, error => console.log(error));
  }
  
  onSubmit(){
    this.cropitemService.updateCropitem(this.id, this.cropitem).subscribe( data =>{
      this.goToCropitemList();
    }
    , error => console.log(error));
  }

  goToCropitemList(){
    this.router.navigate(['crops/cropitems']);
  }

}
