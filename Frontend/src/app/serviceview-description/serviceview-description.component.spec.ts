import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicedescriptionComponent } from './servicedescription.component';

describe('ServicedescriptionComponent', () => {
  let component: ServicedescriptionComponent;
  let fixture: ComponentFixture<ServicedescriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServicedescriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicedescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
