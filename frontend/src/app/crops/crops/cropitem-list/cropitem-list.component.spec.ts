import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CropitemListComponent } from './cropitem-list.component';

describe('CropitemListComponent', () => {
  let component: CropitemListComponent;
  let fixture: ComponentFixture<CropitemListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CropitemListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CropitemListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
