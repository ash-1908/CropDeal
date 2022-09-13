import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCropitemComponent } from './update-cropitem.component';

describe('UpdateCropitemComponent', () => {
  let component: UpdateCropitemComponent;
  let fixture: ComponentFixture<UpdateCropitemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCropitemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateCropitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
