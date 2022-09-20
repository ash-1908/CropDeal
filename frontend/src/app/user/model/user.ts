import { Address } from './address';
import { Bank } from './bank';

export class User {
  id?: string;
  fullName?: String;
  roles?: String;
  userName?: String;
  password?: String;
  phoneNumber?: number;
  email?: String;
  active?:boolean;
  bank?: Bank;
  address?: Address;
  cropIds?:string[];
  // LIST OF CROPITEMS
}
