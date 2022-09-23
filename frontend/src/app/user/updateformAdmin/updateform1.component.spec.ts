import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Updateform1Component } from './updateform1.component';

describe('Updateform1Component', () => {
  let component: Updateform1Component;
  let fixture: ComponentFixture<Updateform1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Updateform1Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Updateform1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
