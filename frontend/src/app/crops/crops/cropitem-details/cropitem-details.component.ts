import { Component, OnInit } from '@angular/core';
import { Cropitem } from '../cropitem';
import { ActivatedRoute } from '@angular/router';
import { CropitemService } from '../cropitem.service';

@Component({
  selector: 'app-cropitem-details',
  templateUrl: './cropitem-details.component.html',
  styleUrls: ['./cropitem-details.component.css']
})
export class CropitemDetailsComponent implements OnInit {

  cropid: number
  cropitem: Cropitem
  constructor(private route: ActivatedRoute, private cropitemService: CropitemService) { }

  ngOnInit(): void {
    this.cropid = this.route.snapshot.params['cropid'];

    this.cropitem = new Cropitem();
    this.cropitemService.getCropitemById(this.cropid).subscribe( data => {
      this.cropitem = data;
    });
  
  }


}
