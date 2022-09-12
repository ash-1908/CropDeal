import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CropsComponent } from './crops.component';

describe('CropsComponent', () => {
  let component: CropsComponent;
  let fixture: ComponentFixture<CropsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CropsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CropsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
