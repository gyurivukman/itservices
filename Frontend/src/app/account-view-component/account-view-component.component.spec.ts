import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountViewComponentComponent } from './account-view-component.component';

describe('AccountViewComponentComponent', () => {
  let component: AccountViewComponentComponent;
  let fixture: ComponentFixture<AccountViewComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccountViewComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountViewComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
