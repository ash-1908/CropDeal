import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdduserformComponent } from './adduserform.component';

describe('AdduserformComponent', () => {
  let component: AdduserformComponent;
  let fixture: ComponentFixture<AdduserformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdduserformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdduserformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
