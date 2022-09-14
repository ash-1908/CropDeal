import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CropitemDetailsComponent } from './cropitem-details.component';

describe('CropitemDetailsComponent', () => {
  let component: CropitemDetailsComponent;
  let fixture: ComponentFixture<CropitemDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CropitemDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CropitemDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
