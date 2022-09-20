import { TestBed } from '@angular/core/testing';

import { TokenInterceptorServiceService } from './token-interceptor-service.service';

describe('TokenInterceptorServiceService', () => {
  let service: TokenInterceptorServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TokenInterceptorServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
