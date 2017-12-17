import { TestBed, inject } from '@angular/core/testing';

import { AccountModifyService } from './account-modify.service';

describe('AccountModifyService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AccountModifyService]
    });
  });

  it('should be created', inject([AccountModifyService], (service: AccountModifyService) => {
    expect(service).toBeTruthy();
  }));
});
