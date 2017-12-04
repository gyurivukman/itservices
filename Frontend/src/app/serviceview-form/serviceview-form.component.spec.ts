import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceviewFormComponent } from './serviceview-form.component';

describe('ServiceviewFormComponent', () => {
  let component: ServiceviewFormComponent;
  let fixture: ComponentFixture<ServiceviewFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceviewFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceviewFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
