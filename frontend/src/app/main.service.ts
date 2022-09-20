import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { User } from './user/model/user';

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor() { }

  userData: Subject<User> = new Subject<User>();
}
