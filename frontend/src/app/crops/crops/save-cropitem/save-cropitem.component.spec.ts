import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveCropitemComponent } from './save-cropitem.component';

describe('SaveCropitemComponent', () => {
  let component: SaveCropitemComponent;
  let fixture: ComponentFixture<SaveCropitemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveCropitemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveCropitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
