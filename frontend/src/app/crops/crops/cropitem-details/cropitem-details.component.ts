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

  id: string
  cropitem: Cropitem
  constructor(private route: ActivatedRoute, private cropitemService: CropitemService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.cropitem = new Cropitem();
    this.cropitemService.getCropitemById(this.id).subscribe( data => {
      this.cropitem = data;
    });
  
  }


}
