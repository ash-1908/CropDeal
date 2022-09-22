import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceService } from '../service/service.service';

@Injectable({
  providedIn: 'root',
})
export class TokenInterceptorServiceService implements HttpInterceptor {
  constructor(private injector: Injector) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    // let service=this.injector.get(ServiceService)
    let tokenizedReq = req.clone({
      setHeaders: {
        Authorization:
          'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50SW5mbyI6eyJpZCI6MSwiZW1haWwiOiJ0ZXN0QGdtYWlsLmNvbSIsImZ1bGxOYW1lIjoidGVzdCIsImFjdGl2ZSI6dHJ1ZSwicm9sZXMiOiJST0xFX0ZBUk1FUiJ9LCJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY2MzE0NzQ0MCwiZXhwIjoxNjYzMTY1NDQwfQ.8LZKKwr_bRBqxAzfVAv-CbvUGQwpP9783pKUhWorbFU',
      },
    });
    return next.handle(tokenizedReq);
  }
}
